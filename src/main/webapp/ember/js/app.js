App = Ember.Application.create();

//Adapter
App.ApplicationAdapter = DS.RESTAdapter.extend({
  namespace: 'emberspring'
});

//Serializer
App.ApplicationSerializer = DS.RESTSerializer.extend({
	  serializeIntoHash: function(hash, type, record, options) {
			var serialized = this.serialize(record, options);
			
			//Include the id in the payload
			serialized.id = record.id;
			
			//remove the root element
	    	Ember.merge(hash, serialized);
	  }
});

//Models
App.Blog = DS.Model.extend({
	active: DS.attr('boolean'),
	name: DS.attr('string'),
	createDate : DS.attr('date'),
	category: DS.belongsTo('category', {async : true}),
	posts : DS.hasMany('post', {async : true})
});

App.Category = DS.Model.extend({
	name: DS.attr('string'),
	blogs : DS.hasMany('post', {async : true})
});

App.Post = DS.Model.extend({
	comment: DS.attr('string'),
	blog : DS.belongsTo('blog', {async : true}),
	createDate : DS.attr('date')
});

//Router
App.Router.map(function() {
    this.resource('blogs', function() {
        this.route('blog', { path: '/:blog_id' });
    });
});

//Routes
App.BlogsRoute = Ember.Route.extend({
  model: function() {
    return this.store.find('blog');
  }
});

App.BlogsBlogController = Ember.ObjectController.extend({
	actions : {
		sendToServer : function(post) {
	        var self = this;
			post.save().then(function() {
				alert(self.store.metadataFor("post").serverSaid);
			});
		}
	}
});



