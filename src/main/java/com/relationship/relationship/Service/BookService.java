package com.relationship.relationship.Service;

import com.relationship.relationship.Model.Book;
import com.relationship.relationship.Model.Photo;
import com.relationship.relationship.Repository.BookRepo;
import com.relationship.relationship.Repository.PhotoRepo;
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
public class BookService {
    private final PhotoRepo photoRepo;
    private final BookRepo bookRepo;

    public Book getBook(Long book_id) {
        log.info("Fetching book {}", book_id);
        return bookRepo.getById(book_id);
    }

    public List<Book> getBooks() {
        log.info("Fetching all books");
        return bookRepo.findAll();
    }

    public Book saveBook(Book book) {
        log.info("Saving book {}", book.getTitle());
        return bookRepo.save(book);
    }

    public void addPhotoToBook(Long photo_id, Long book_id) {
        log.info("Saving photo {} to book {}", photo_id, book_id);
        Book book = bookRepo.findById(book_id).orElseThrow(() -> {
                throw new EntityNotFoundException("Book with this id was not in the db");
            });
        Photo photo = photoRepo.findById(photo_id).orElseThrow(() -> {
                throw new EntityNotFoundException("Book with this id was not in the db");
            });;

        book.setPhoto(photo);
        bookRepo.save(book);
    }

}
