package com.example.demo.book;

import com.example.demo.book.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface BookRepository extends CrudRepository<Book, Integer>{

}
