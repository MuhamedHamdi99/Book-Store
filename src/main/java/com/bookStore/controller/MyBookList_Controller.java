package com.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookStore.services.MyBookService;

@Controller
public class MyBookList_Controller {

	@Autowired
	private MyBookService myBookListService;
	
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteById(@PathVariable("id")  int id) {
		myBookListService.deleteById(id);
		return "redirect:/my_books";
	}
	
}
