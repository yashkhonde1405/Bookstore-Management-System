package com.jsp.BookstoreManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.BookstoreManagementSystem.dto.Book;
import com.jsp.BookstoreManagementSystem.repository.BookRepository;
import com.jsp.BookstoreManagementSystem.repository.BookRepository;

@Service
public class BookService {
        
	 @Autowired
	 BookRepository repository;
	 
	// TO INSERT Bookstore OBJECT INTO DB
	 public String insertBook(Book book) 
	 {
		 repository.save(book);
		return "Book details stored succesfully";
	 }
	 
	 // To retrieve all the book object from db
	 public List<Book> fetchAllBookDetails()
	 {
		 return repository.findAll();
	 }
	 
	 // To search & fetch an object based on Id (primary key)
	 
	 public Book findBookById(int id)
	 {
		 Optional<Book> opt = repository.findById(id);
		 
		 if(opt.isPresent())
		 {
			 return opt.get();
		 }
		 else
		 {
			 return null;
		 }
	 }
	 
	 // To delete book object from db
	 
	 public String deleteBookById(int id) 
	 {
		 Book book = findBookById(id);
		 
		 if(book != null)
		 {
			repository.delete(book);
			return "Book details with ID " + id + " have been deleted successfully.";
         }
		 else
		 {
			return "Book details of id:"+id +" doesn't exists";
		 }
	 }
	 
	 // to update book details (title, publisher, price, quantity) in db based in ID
	 
	 public Book updateBook(int id,String newtitle, String newpublisher, Double newprice, int newquantity)
	 {
		  Book book = findBookById(id);
		  
		  if(book != null)
		  {
			  book.setTitle(newtitle);
			  book.setPublisher(newpublisher);
			  book.setPrice(newprice);
			  book.setQuantity(newquantity);
			  repository.save(book);
			  return book;
		  }
		  else
			  return null;
	 }
	 
	 // To search & fetch an object based on title 
	 
	 public Book findBookByTitle(String title)
	 {
		 Optional<Book> opt = repository.findByTitle(title);
		 
		 if(opt.isPresent())
		 {
			 return opt.get();
		 }
		 else
		 {
			 return null;
		 }
	 }
	 
	// To retrieve all the book whose price is > 150
	 
	 public List<Book> findBooksByPrice(double price) {
	        
		 return repository.findByPriceGreaterThan(price);
	  }
}
