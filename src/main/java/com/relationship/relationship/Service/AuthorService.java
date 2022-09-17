package com.relationship.relationship.Service;

import com.relationship.relationship.Model.Author;
import com.relationship.relationship.Model.Book;
import com.relationship.relationship.Repository.AuthorRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AuthorService {

    private final AuthorRepo authorRepo;

    public List<Author> getAuthors() {
        log.info("Fetching all authors");
        return authorRepo.findAll();
    }

    public Author saveAuthor(Author author){
        authorRepo.save(author);
        return author;
    }
}
