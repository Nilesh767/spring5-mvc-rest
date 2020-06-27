package com.n3o.api.v1.mapper;

import com.n3o.api.v1.model.CategoryDTO;
import com.n3o.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    //@Mapping(source = "getID",target = "id")
    CategoryDTO categoryToCategoryDTO(Category category);
}
