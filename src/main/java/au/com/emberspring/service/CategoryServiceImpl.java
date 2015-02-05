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
public class CategoryServiceImpl implements CategoryService {

	private final FixtureDataDao fixtureDataDao;
	
	@Autowired
	public CategoryServiceImpl(final FixtureDataDao fixtureDataDao) {
		this.fixtureDataDao = fixtureDataDao;
	}

	@Override
	public Category getCategory(Long categoryId) {
		return fixtureDataDao.getCategory(categoryId);
	}

}
