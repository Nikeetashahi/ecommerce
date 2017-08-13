package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import com.ecommerce.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService cservice;

	@RequestMapping("/Category")
	public ModelAndView category() {
		ModelAndView mvc = new ModelAndView("Category", "c", new Category());
		String Categorylist = cservice.retrieveCategory();
		mvc.addObject("Catlist", Categorylist);

		return mvc;
	}

	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public ModelAndView addcategory(Category cty) {
		cservice.addCategory(cty);
		ModelAndView mvc = new ModelAndView("Category", "c", new Category());
		String Categorylist = cservice.retrieveCategory();
		mvc.addObject("Catlist", Categorylist);
		return mvc;

	}

	@RequestMapping(value = "/deleteCategory", method = RequestMethod.GET)
	public ModelAndView deletecategory(@RequestParam("id") int id) {
		cservice.deleteCategory(id);
		ModelAndView mvc = new ModelAndView("Category", "c", new Category());
		String Categorylist = cservice.retrieveCategory();
		mvc.addObject("Catlist", Categorylist);
		return mvc;

	}

	@RequestMapping(value = "/fetchCategory", method = RequestMethod.GET)
	public ModelAndView fetchcategory(@RequestParam("id") int id) {
		Category c = cservice.fetchCategory(id);
		ModelAndView mvc = new ModelAndView("Category", "c", c);
		String Categorylist = cservice.retrieveCategory();
		mvc.addObject("Catlist", Categorylist);
		mvc.addObject("ClickedUpdateProduct", "true");
		return mvc;
	}

	@RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
	public ModelAndView updatecategory(Category ctry) {
		cservice.updateCategory(ctry);
		ModelAndView mvc = new ModelAndView("Category", "c", new Category());
		String Categorylist = cservice.retrieveCategory();
		mvc.addObject("Catlist", Categorylist);
		return mvc;
	}

	@RequestMapping(value = "/daiablecategory", method = RequestMethod.GET)
	public ModelAndView disableCategory(@RequestParam("cid") int id) {
		String status = "Disable";
		cservice.setCategoryStatus(id, status);
		ModelAndView mvc = new ModelAndView("Category", "c", new Category());
		String Categorylist = cservice.retrieveCategory();
		mvc.addObject("Catlist", Categorylist);
		return mvc;

	}

	@RequestMapping(value = "/enablecategory", method = RequestMethod.GET)
	public ModelAndView enableCategory(@RequestParam("cid") int id)

	{
		String status = "Enable";
		cservice.setCategoryStatus(id, status);
		ModelAndView mvc = new ModelAndView("Category", "c", new Category());
		String Categorylist = cservice.retrieveCategory();
		mvc.addObject("Catlist", Categorylist);
		return mvc;

	}

}
