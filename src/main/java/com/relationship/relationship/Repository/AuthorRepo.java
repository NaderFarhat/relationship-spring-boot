package com.relationship.relationship.Repository;

import com.relationship.relationship.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Long> {

}