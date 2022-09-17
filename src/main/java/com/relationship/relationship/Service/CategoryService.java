package com.relationship.relationship.Service;

import com.relationship.relationship.Model.Book;
import com.relationship.relationship.Model.Category;
import com.relationship.relationship.Model.Photo;
import com.relationship.relationship.Repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CategoryService implements Serializable {

    private final CategoryRepo categoryRepo;

    public List<Category> getCategories() {
        log.info("Fetching all categories");
        return categoryRepo.findAll();
    }

    public Category saveCategory(Category category){
        categoryRepo.save(category);
        return category;
    }

    public void CategoryEnrollCategory(Long parent_id, Long children_id) {

        Category parent = categoryRepo.findById(parent_id).orElseThrow(() -> {
            throw new EntityNotFoundException("Book with this id was not in the db");
        });
        Category children = categoryRepo.findById(children_id).orElseThrow(() -> {
            throw new EntityNotFoundException("Book with this id was not in the db");
        });

        Collection<Category> childrenAdd = new ArrayList<>();
        childrenAdd.add(children);

        parent.setChildren(childrenAdd);
//        children.setParent(parent);

        categoryRepo.save(parent);
//        categoryRepo.save(children);

//        book.setPhoto(photo);
//        bookRepo.save(book);
    }
}
