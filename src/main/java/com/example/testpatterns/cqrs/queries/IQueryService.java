package com.example.testpatterns.cqrs.queries;

import com.example.testpatterns.cqrs.dto.Author;
import com.example.testpatterns.cqrs.dto.Book;

import java.math.BigInteger;
import java.util.List;


/**
 * 
 * This interface represents the query methods of the CQRS pattern
 *
 */
public interface IQueryService {

  Author getAuthorByUsername(String username);

  Book getBook(String title);

  List<Book> getAuthorBooks(String username);

  BigInteger getAuthorBooksCount(String username);

  BigInteger getAuthorsCount();

}
