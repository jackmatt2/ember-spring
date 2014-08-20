package au.com.emberspring.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import au.com.emberspring.domain.Blog;
import au.com.emberspring.domain.Post;


public interface FixtureDataDao {

	Blog getBlog(Long blogId);

	List<Blog> getAllBlogs();

	List<Post> getPostsForBlog(long blogId);

}
