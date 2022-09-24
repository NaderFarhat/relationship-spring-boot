package com.relationship.relationship.Repository;

import com.relationship.relationship.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Long> {

}