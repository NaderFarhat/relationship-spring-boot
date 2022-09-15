package com.relationship.relationship.Controller;

import com.relationship.relationship.Model.Book;
import com.relationship.relationship.Model.Photo;
import com.relationship.relationship.Service.BookService;
import com.relationship.relationship.Service.PhotoService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class BookController {
    private final BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.ok().body(bookService.getBooks());
    }

    @PostMapping("/book/save")
    public ResponseEntity<Book> saveUser(@RequestBody Book book) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/book/save").toUriString());
        return ResponseEntity.created(uri).body(bookService.saveBook(book));
    }

    @PostMapping("/book/addtobook")
    public ResponseEntity<?> addPhotoToBook(@RequestBody PhotoToBookForm form ) {
//        log.info("Saving photo {} to book {}", photo_id, book_id);
        log.info("Saving photo {} to book {}", form.getBook_id(), form.getPhoto_id());
        bookService.addPhotoToBook(form.getPhoto_id(),  form.getBook_id());
        return ResponseEntity.ok().build();
    }

}

@Data
class PhotoToBookForm {
    private Long photo_id;
    private Long book_id;
}
