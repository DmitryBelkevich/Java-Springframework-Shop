package com.hard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hard.models.ProductCategory;
import com.hard.services.ProductCategoryService;

@Controller
@RequestMapping(value = "/product_category")
public class ProductCategoryController {
	@Autowired
	@Qualifier("productCategoryService")
	private ProductCategoryService productCategoryService;
	
	public ProductCategoryController() {
		
	}
	
	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("product_category/list");
		
		try {
			List<ProductCategory> productCategories = productCategoryService.getAll();
			
			modelAndView.addObject("productCategories", productCategories);
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("product_category/list?error");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView form(ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView("product_category/form");
		
		modelMap.addAttribute("action", "add");
		
		ProductCategory productCategory = new ProductCategory();
		
		modelAndView.addObject("productCategory", productCategory);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editForm(@PathVariable("id") int id, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView("product_category/form");
		
		modelMap.addAttribute("action", "update");
		
		ProductCategory productCategory = productCategoryService.getById(id);
		
		modelAndView.addObject("productCategory", productCategory);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("productCategory") ProductCategory productCategory) {
		try {
			productCategoryService.add(productCategory);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/product_category/list?error=incorrectParams";
		}
		
		return "redirect:/product_category/list";
	}
	
	@RequestMapping(value = "/addAjax", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8")
	@ResponseBody
	public String addAjax(@RequestBody ProductCategory productCategory) {
		try {
			productCategoryService.add(productCategory);
		} catch (Exception e) {
			e.printStackTrace();
			//return "redirect:/product/list?error=incorrectParams";
		}
		
		return "Ok";
	}
	
	@RequestMapping(value = "/edit/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("productCategory") ProductCategory productCategory) {
		try {
			productCategoryService.update(productCategory);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/product_category/list?error=incorrectParams";
		}
		
		return "redirect:/product_category/list";
	}
	
	@RequestMapping(value = "/edit/updateAjax", method = RequestMethod.POST)
	@ResponseBody
	public String updateAjax(@RequestBody ProductCategory productCategory) {
		try {
			productCategoryService.update(productCategory);
		} catch (Exception e) {
			e.printStackTrace();
			//return "redirect:/product_category/list?error=incorrectParams";
		}
		
		return "Ok";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		try {
			productCategoryService.delete(productCategoryService.getById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/product_category/list?error";
		}
		
		return "redirect:/product_category/list";
	}
}