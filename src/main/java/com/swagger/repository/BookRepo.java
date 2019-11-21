package com.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swagger.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
