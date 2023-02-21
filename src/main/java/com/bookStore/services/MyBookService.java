package com.bookStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.MyBook_List;
import com.bookStore.reposetory.MyBookReposetory;

@Service
public class MyBookService {

	@Autowired
	private MyBookReposetory myBookReposetory;
	
	public void saveMyBook(MyBook_List book) {
		myBookReposetory.save(book);
	}
	
	public List<MyBook_List> get_allMyBooks(){
		return myBookReposetory.findAll();
	}
	
	public void deleteById(int id) {
		myBookReposetory.deleteById(id);
	}
	
	
	
	
	
	
}
