package com.n3o.services;

import com.n3o.api.v1.model.CategoryDTO;
import com.n3o.domain.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String name);
}
