package com.relationship.relationship.Repository;

import com.relationship.relationship.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {

}