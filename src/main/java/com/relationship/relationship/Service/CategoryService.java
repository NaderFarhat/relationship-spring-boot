package com.relationship.relationship.Service;

import com.relationship.relationship.Model.Book;
import com.relationship.relationship.Model.Category;
import com.relationship.relationship.Repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public List<Category> getCategories() {
        log.info("Fetching all categories");
        return categoryRepo.findAll();
    }
}
