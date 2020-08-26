package com.julia.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping ("/categories")
public class CategoriesController {
	
	@RequestMapping("")
	public String list(Model model) {
		model.addAttribute("name", "Julia Singh");
		List<String> names=new ArrayList();
		names.add("dennis");
		names.add("puru");
		names.add("olga");
		model.addAttribute("names", names);
		
		return "categories";
	}
	

}
