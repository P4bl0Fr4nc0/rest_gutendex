package com.example.restgutendex.repository;

import com.example.restgutendex.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
