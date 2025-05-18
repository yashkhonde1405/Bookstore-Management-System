package com.jsp.BookstoreManagementSystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.BookstoreManagementSystem.dto.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	Optional<Book> findByTitle(String title);
	
	List<Book> findByPriceGreaterThan(double price); // Custom name (but still follows Spring Data JPA's conventions)
                                                    /*Spring Data JPA follow the naming convention
                                                       to understands and can translate into 
                                                       an SQL query.*/
                                                     
}
