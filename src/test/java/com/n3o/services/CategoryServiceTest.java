package com.n3o.services;

import com.n3o.api.v1.mapper.CategoryMapper;
import com.n3o.api.v1.model.CategoryDTO;
import com.n3o.domain.Category;
import com.n3o.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class CategoryServiceTest {

    public static final long ID = 2L;
    public static final String NAME = "Nilesh";
    CategoryService categoryService;
    @Mock
    CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        categoryService = new CategoryServiceImpl(CategoryMapper.INSTANCE, categoryRepository);
    }

    @Test
    void getAllCategories() {
        //given
        List<Category> categories = Arrays.asList(new Category(), new Category(), new Category());
        when(categoryRepository.findAll()).thenReturn(categories);
        //when
        List<CategoryDTO> categoryDTOS = categoryService.getAllCategories();
        //then
        assertEquals(3,categoryDTOS.size());
    }

    @Test
    void getCategoryByName() {
        //given
        Category category = new Category();
        category.setId(ID);
        category.setName(NAME);

        when(categoryRepository.findByName(anyString())).thenReturn(category);
        //when
        CategoryDTO categoryDTO = categoryService.getCategoryByName(NAME);
        //then
        assertEquals(ID,categoryDTO.getId());
        assertEquals(NAME,categoryDTO.getName());
    }
}