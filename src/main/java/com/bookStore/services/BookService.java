package com.bookStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.Book;
import com.bookStore.reposetory.BookReposetory;

@Service
public class BookService {

	@Autowired
	private BookReposetory bookReposetory;
	
	public void save(Book book) {
		bookReposetory.save(book);
	}
	
	public List<Book> get_allBooks(){
		return bookReposetory.findAll();
	}
	
	public Book getBookById(int id) {
		return bookReposetory.findById(id).get();
	}
	
	public void deletBookById(int id) {
		bookReposetory.deleteById(id);
	}
	
}
