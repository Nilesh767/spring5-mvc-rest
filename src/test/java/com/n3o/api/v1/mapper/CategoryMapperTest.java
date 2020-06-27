package com.n3o.api.v1.mapper;

import com.n3o.api.v1.model.CategoryDTO;
import com.n3o.domain.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryMapperTest {

    public static final String NAME = "Nilesh";
    public static final long ID = 1L;
    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    void categoryToCategoryDTO() {
        //given
        Category category = new Category();
        category.setName(NAME);
        category.setId(ID);
        //when
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);
        //then
        assertEquals(Long.valueOf(ID),categoryDTO.getId());
        assertEquals(NAME,categoryDTO.getName());
    }
}