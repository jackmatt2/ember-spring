package au.com.emberspring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import au.com.emberspring.domain.Blog;
import au.com.emberspring.domain.Category;
import au.com.emberspring.domain.Post;


@Repository
public class FixtureDataDaoImpl implements FixtureDataDao {
	
	@Override
	public Blog getBlog(Long blogId) {
		
		if(blogId == 1L) {
			return getBlog1();
		}
		
		if(blogId == 2L) {
			return getBlog2();
		}
		
		if(blogId == 3L) {
			return getBlog3();
		}
		
		throw new RuntimeException(String.format("%d is an invalid blog id", blogId));
	}

	@Override
	public List<Blog> getAllBlogs() {
		List<Blog> blogs = new ArrayList<Blog>();
		blogs.add(getBlog1());
		blogs.add(getBlog2());
		blogs.add(getBlog3());
		return blogs;
	}
 
	
	private Blog getBlog1() {
		Blog blog = new Blog();
		blog.setId(1L);
		blog.setActive(true);
		blog.setName("EmberJs");
		blog.setCreateDate(new Date());
		
		useProgrammingCategory(blog);
		
		Post post1 = new Post();
		post1.setId(11L);
		post1.setCreateDate(new Date());
		post1.setComment("{async : false} on your ember model relationships is necessary to get 'links' working!");
		
		Post post2 = new Post();
		post2.setId(12L);
		post2.setCreateDate(new Date());
		post2.setComment("DS.attr('date') an accepts ISO or millisecond format but is serialized in ISO format only.");

		Post post3 = new Post();
		post3.setId(13L);
		post3.setCreateDate(new Date());
		post3.setComment("Don't forget to check out ember-cli (http://www.ember-cli.com/), it is necessary for any large ember application");
		
		blog.addPost(post1);
		blog.addPost(post2);
		
		return blog;
	}
	
	private Blog getBlog2() {
		Blog blog = new Blog();
		blog.setId(2L);
		blog.setActive(true);
		blog.setName("Spring Framework");
		blog.setCreateDate(new Date());
		
		useProgrammingCategory(blog);
		
		Post post1 = new Post();
		post1.setId(21L);
		post1.setCreateDate(new Date());
		post1.setComment("Don't forget to add Jackson to your classpath");
		
		blog.addPost(post1);
		
		return blog;
	}
	
	private Blog getBlog3() {
		Blog blog = new Blog();
		blog.setId(3L);
		blog.setActive(true);
		blog.setName("Spring + EmberJs");
		blog.setCreateDate(new Date());
		
		useProgrammingCategory(blog);
		
		Post post1 = new Post();
		post1.setId(31L);
		post1.setCreateDate(new Date());
		post1.setComment("Setting up ember to work with java can be confusing!");
		
		Post post2 = new Post();
		post2.setId(32L);
		post2.setCreateDate(new Date());
		post2.setComment("Hopefully this will make it much easier ...");
		
		blog.addPost(post1);
		blog.addPost(post2);
		
		return blog;
	}
	
	public void useProgrammingCategory(Blog blog) {
		Category category = new Category();
		category.setId(2L);
		category.setName("Programming");
		category.addBlog(blog);
	}

	@Override
	public List<Post> getPostsForBlog(long blogId) {
		return getBlog(blogId).getPosts();
	}
}
