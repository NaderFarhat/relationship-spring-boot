package com.relationship.relationship.Controller;

import com.relationship.relationship.Model.Author;
import com.relationship.relationship.Service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
