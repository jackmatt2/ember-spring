package au.com.emberspring.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.persistence.Id;

import au.com.emberspring.ember.EmberLinks;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Category implements EmberLinks {

    private Long id;
    private String name;
    private List<Blog> blogs = new ArrayList<Blog>(0);
    
    @Id
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonIgnore
	public List<Blog> getBlogs() {
		return blogs;
	}
	
	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	public void addBlog(Blog blog) {
		this.blogs.add(blog);
		blog.setCategory(this);
	}
    
	@Override
	public ConcurrentMap<String, String> getLinks() {
		ConcurrentMap<String, String> links = new ConcurrentHashMap<String, String>();
		links.put("blogs", "blogs");
		return links;
	}
    
}
