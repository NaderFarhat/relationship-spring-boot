package com.relationship.relationship.Controller;

import com.relationship.relationship.Model.Category;
import com.relationship.relationship.Model.Photo;
import com.relationship.relationship.Repository.CategoryRepo;
import com.relationship.relationship.Service.CategoryService;
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
public class CategoryController {

    private final CategoryService categoryService;

    private final CategoryRepo categoryRepo;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.ok().body(categoryService.getCategories());
    }

    @PostMapping("/category/save")
    public ResponseEntity<Category> saveUser(@RequestBody Category category) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/photo/save").toUriString());
        return ResponseEntity.created(uri).body(categoryService.saveCategory(category));
    }

    @PutMapping(value = "/category/enroll", consumes={"application/json"})
    public ResponseEntity<?> CategoryEnrollCategory(@RequestBody CategoryToCategory form) {
        categoryService.CategoryEnrollCategory(form.getCategory_parent_id(),form.getCategory_parent_id());
        return null;
    }
}

@Data
class CategoryToCategory {
    private Long category_parent_id;
    private Long category_children_id;
}
