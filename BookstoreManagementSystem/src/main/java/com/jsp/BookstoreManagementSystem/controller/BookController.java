package com.jsp.BookstoreManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.BookstoreManagementSystem.dto.Book;
import com.jsp.BookstoreManagementSystem.service.BookService;

@RestController
public class BookController {

       @Autowired
       BookService service;
       
       // Rest API to stored Book object into db
       @PostMapping("/books")
       public String addBook(@RequestBody Book bookstore)
       {
    	   return service.insertBook(bookstore);
       }
       
       //Rest API to retrieve All the book object from the db
       @GetMapping("/allbooks")
       public List<Book> getBookDetails()
       {
    	   return service.fetchAllBookDetails();
       }
       
       //Rest API to retrieve(Book by Id) a specific Book Object from db
       @GetMapping("/getbook")
       public Book getBookDetailsById(@RequestParam int id)
       {
    	   return service.findBookById(id);
       }
       
      // Rest API to Delete a Employee object from DB 
       @DeleteMapping("/books")
       public String deleteBookDetailsById(@RequestParam int id)
       {
    	   return service.deleteBookById(id);
       }
       
      // Rest API to Update a Book object from db
       @PutMapping("/books")
       public Book updateBookDetails(@RequestParam int id,@RequestParam String title,
    		            @RequestParam String publisher, @RequestParam double price, @RequestParam int quantity)
       {
    	   return service.updateBook(id, title, publisher, price, quantity);
       }
       
      //Rest API to retrieve(Book by title) a specific Book Object from db
       @GetMapping("/booktitle")
       public Book getBookDetailsByTitle(@RequestParam String title)
       {
    	   return service.findBookByTitle(title);
       }
       
     //Rest API to retrieve all the book whose price is > 150
       @GetMapping("/bookprice")
       public List<Book> getBookDetailsByprice(@RequestParam double price)
       {
    	   return service.findBooksByPrice(price);
       }
}
