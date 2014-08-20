package au.com.emberspring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.com.emberspring.domain.Blog;
import au.com.emberspring.domain.Category;
import au.com.emberspring.domain.Post;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

	private final FixtureDataDao fixtureDataDao;
	
	@Autowired
	public BlogServiceImpl(final FixtureDataDao fixtureDataDao) {
		this.fixtureDataDao = fixtureDataDao;
	}
	
	@Override
	public Blog getBlog(Long blogId) {
		return fixtureDataDao.getBlog(blogId);
	}

	@Override
	public List<Blog> getBlogs() {
		return fixtureDataDao.getAllBlogs();
	}

	@Override
	public List<Post> getPosts(long blogId) {
		return fixtureDataDao.getPostsForBlog(blogId);
	}

}
