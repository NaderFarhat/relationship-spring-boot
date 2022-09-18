package com.relationship.relationship.Service;

import com.relationship.relationship.Model.Author;
import com.relationship.relationship.Model.Book;
import com.relationship.relationship.Repository.AuthorRepo;
import com.relationship.relationship.Repository.BookRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AuthorService {

    private final AuthorRepo authorRepo;

    private final BookRepo bookRepo;

    public List<Author> getAuthors() {
        log.info("Fetching all authors");
        return authorRepo.findAll();
    }

    public Author saveAuthor(Author author){
        authorRepo.save(author);
        return author;
    }

    public void saveAuthorToBook (Long author_id, Long book_id) {
        Author author = authorRepo.findById(book_id).orElseThrow(() -> {
            throw new EntityNotFoundException("Author with this id was not in the db");
        });
        Book book = bookRepo.findById(book_id).orElseThrow(() -> {
            throw new EntityNotFoundException("Book with this id was not in the db");
        });

        author.getBooks().add(book);
        book.getAuthors().add(author);

        authorRepo.save(author);
        bookRepo.save(book);


    }
}
