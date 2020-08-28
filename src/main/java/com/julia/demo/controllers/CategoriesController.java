package com.julia.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.julia.demo.models.Category;
import com.julia.demo.services.CategoryService;
import com.julia.demo.models.*;

@Controller 
@RequestMapping ("/categories")
public class CategoriesController {
	
	@Autowired
	CategoryService svc;
	
	
	
	@RequestMapping("")
	public String list(Model model) {
		List<Category> names = svc.getAllCategories();
		
		model.addAttribute("names", names);
		
		return "categories";
	}
	
	@RequestMapping("/{id}")
	public String addEditCat(Model model,@PathVariable Long id) {
		
		//add
		if(id==0) {
			model.addAttribute("category", new Category());
		}
		//edit
		else {
			Category cat = svc.find(id);
			model.addAttribute("category", cat);
		}
	
		
		return "addEdit";	
	}
	
	@RequestMapping("/save")
	public String save(Model model, @ModelAttribute Category category) {
		
		if(category.getId()==null) {
			svc.save(category);
		}
		else {		
			 svc.update(category);
		}
		return "redirect:/categories";
		//return "save";		
	}
	
	@RequestMapping("/{id}/delete")
	public String delete(Model model, @PathVariable Long id) {
		svc.delete(id);
		return "redirect:/categories";
	}



}
