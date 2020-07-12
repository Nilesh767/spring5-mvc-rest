package com.n3o.api.v1.model;

import com.n3o.api.v1.model.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryListDTO {
    List<CategoryDTO> categories;
}
