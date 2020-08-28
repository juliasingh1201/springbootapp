package com.julia.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.julia.demo.models.Category;

@Service
public class CategoryService {
	
	List<Category> names=new ArrayList<Category>();
	
	public List<Category> getAllCategories() {
		
		return names;
	}
	
	public void save(Category category){
		category.setId(Long.valueOf(names.size()+1));
	
		names.add(category);
	}
	
	public void update(Category category) {
		for(int i=0;i< names.size();i++) {
			if(category.getId()==names.get(i).getId()) {
				names.get(i).setName(category.getName());
			}
		}
	}
	
	public Category find(Long id) {
		
		for(int i=0;i<names.size();i++) {
			if(names.get(i).getId()==id) {
				return names.get(i);
			}
		}
		return null;
	}
	
	public void delete(Long id) {
		Category cat= find(id);
		names.remove(cat);
	}

}
