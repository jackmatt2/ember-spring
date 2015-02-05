package au.com.emberspring.service;

import java.util.List;

import au.com.emberspring.domain.Blog;
import au.com.emberspring.domain.Category;
import au.com.emberspring.domain.Post;

public interface CategoryService {

	Category  getCategory(Long blogId);

}
