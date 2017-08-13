package com.ecommerce.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.CategoryDao;
import com.ecommerce.model.Category;
import com.ecommerce.service.CategoryService;
@Service
public class CategoryServiceimpl implements CategoryService{
	
	@Autowired
	CategoryDao cdao;

	public void addCategory(Category ctry) {

		cdao.addCategory(ctry);
	}

	public String retrieveCategory() {

		return cdao.retrieveCategory();
	}

	public void deleteCategory(int id) {

		cdao.deleteCategory(id);
	}

	public Category fetchCategory(int id) {

		return cdao.fetchCategory(id);
	}

	public void updateCategory(Category ctry) {

		cdao.updateCategory(ctry);
	}

	public void setCategoryStatus(int id, String status) {
          cdao.setCategoryStatus(id, status);
		
	}
}
