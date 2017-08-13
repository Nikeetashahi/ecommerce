package com.ecommerce.service;

import java.util.List;

import com.ecommerce.model.Category;
import com.ecommerce.model.Product;

public interface CategoryService {

	void addCategory(Category ctry);
	String retrieveCategory();
	void deleteCategory(int id);
	Category fetchCategory(int id);
	void updateCategory(Category ctry);
	void setCategoryStatus(int id, String status);

}
