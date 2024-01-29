package com.example.category.mapper;

import com.example.category.domain.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CategoryMapper {
    List<CategoryDTO> getAllCategories();
    List<CategoryDTO> getAllSubCategoriesByParentId(Long parentId);
    Integer updateOrders(List<Integer> newOrders);
    Integer createCategory(CategoryDTO categoryDTO);

    Map<String, Long> selectParentIdAndOrders(Long id);

    Integer updateCategoryContents(CategoryDTO categoryDTO);
}
