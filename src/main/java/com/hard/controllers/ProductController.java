package com.hard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hard.models.Product;
import com.hard.models.ProductCategory;
import com.hard.services.ProductCategoryService;
import com.hard.services.ProductService;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	@Autowired
	@Qualifier("productCategoryService")
	private ProductCategoryService productCategoryService;
	
	public ProductController() {
		
	}
	
	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("product/list");
		
		try {
			List<Product> products = productService.getAll();
			
			modelAndView.addObject("products", products);
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("redirect:/product/list?error");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView form(ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView("product/form");
		
		modelMap.addAttribute("action", "add");
		
		Product product = new Product();
		List<ProductCategory> productCategories = productCategoryService.getAll();
		
		modelAndView.addObject("product", product);
		modelAndView.addObject("productCategories", productCategories);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editForm(@PathVariable("id") int id, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView("product/form");
		
		modelMap.addAttribute("action", "update");
		
		Product product = productService.getById(id);
		List<ProductCategory> productCategories = productCategoryService.getAll();
		
		modelAndView.addObject("product", product);
		modelAndView.addObject("productCategories", productCategories);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("product") Product product) {
		try {
			productService.add(product);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/product/list?error=incorrectParams";
		}
		
		return "redirect:/product/list";
	}
	
	@RequestMapping(value = "/edit/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("product") Product product) {
		try {
			productService.update(product);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/product/list?error=incorrectParams";
		}
		
		return "redirect:/product/list";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		try {
			productService.delete(productService.getById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/product/list?error";
		}
		
		return "redirect:/product/list";
	}
}