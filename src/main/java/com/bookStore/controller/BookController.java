package com.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.entity.Book;
import com.bookStore.entity.MyBook_List;
import com.bookStore.services.BookService;
import com.bookStore.services.MyBookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private MyBookService myBookListService;
	
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String regesterBook() {
		return "Book_Register";
	}
	
	@GetMapping("/available_books")
	public ModelAndView Book_available() {
		
		List<Book> list = bookService.get_allBooks();
		ModelAndView mv= new ModelAndView();
		mv.setViewName("books_available");
		mv.addObject("book",list); // book >> key
		// another method >> return new ModelAndView("books_available","book",list);
		return mv;
	}

	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book book) {
		bookService.save(book);
		
		return "redirect:/books_available";
	}
	
	
	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBook_List> myBooklist = myBookListService.get_allMyBooks();
		model.addAttribute("book",myBooklist);
		return "MyBooks";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyListBooks(@PathVariable("id") int id  )
	{
		Book book = bookService.getBookById(id);
		MyBook_List book_List  = new MyBook_List(book.getId(),book.getName(),book.getAuther(),book.getPrice());
		
		myBookListService.saveMyBook(book_List);
	    return "redirect:/my_books";	
	}
	
	
	@RequestMapping("/editBook/{id}")
	public String EditBook(@PathVariable("id") int id,Model model) {
		Book bookk = bookService.getBookById(id);
		model.addAttribute("book", bookk);
		return "BookEdit";
	}
	
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		bookService.deletBookById(id);
		return "redirect:/available_books";
	}
 	
	
	
	
	
	
	
	
	
}
