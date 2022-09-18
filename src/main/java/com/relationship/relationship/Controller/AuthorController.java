package com.relationship.relationship.Controller;

import com.relationship.relationship.Model.Author;
import com.relationship.relationship.Model.Photo;
import com.relationship.relationship.Service.AuthorService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAuthors() {
        return ResponseEntity.ok().body(authorService.getAuthors());
    }

    @PostMapping("/author/save")
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/author/save").toUriString());
        return ResponseEntity.created(uri).body(authorService.saveAuthor(author));
    }

    @PostMapping("/author/save/book")
    public ResponseEntity<?> saveAuthorBook(@RequestBody formBookAuthor formBookAuthor) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/author/save").toUriString());
        authorService.saveAuthorToBook(formBookAuthor.getAuthor_id(),formBookAuthor.getBook_id());
        return ResponseEntity.ok().build();
    }


}

@Data
class formBookAuthor {
    private Long author_id;
    private Long book_id;
}
