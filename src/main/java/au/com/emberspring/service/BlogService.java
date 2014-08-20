package au.com.emberspring.service;

import java.util.List;

import au.com.emberspring.domain.Blog;
import au.com.emberspring.domain.Post;

public interface BlogService {

	Blog getBlog(Long blogId);

	List<Blog> getBlogs();

	List<Post> getPosts(long blogId);

}
