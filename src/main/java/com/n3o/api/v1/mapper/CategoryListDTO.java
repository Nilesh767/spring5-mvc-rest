package com.n3o.api.v1.mapper;

import com.n3o.api.v1.model.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CategoryListDTO {
    List<CategoryDTO> categories;
}
