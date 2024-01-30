package com.example.category.service;

import com.example.category.domain.CategoryDTO;
import com.example.category.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.function.LongToIntFunction;

@Log4j2
@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryMapper categoryMapper;

    public List<CategoryDTO> getAllCategories() {
        return categoryMapper.getAllCategories();
    }

    // 하위 카테고리 조회
    public List<CategoryDTO> getAllSubCategoriesByParentId(Long parentId){
        return categoryMapper.getAllSubCategoriesByParentId(parentId);
    }

    // 키테고리 순서 수정
    @Transactional  // [*****]
    public boolean modifyOrders(List<Integer> newOrders, Long userId) {
        Integer result = categoryMapper.updateOrders(newOrders, userId);

        if(result > 0)  return true;
        else            return false;
    }

    // 카테고리 생성
    @Transactional  // [*****]
    public boolean createCategory(CategoryDTO categoryDTO) {
        Integer result = categoryMapper.createCategory(categoryDTO);

        if(result > 0)  return true;
        else            return false;
    }

    // 카테고리 수정
    @Transactional  // [*****]
    public void modifyCategory(CategoryDTO categoryDTO) {
        // 카테고리의 기존 상위 카테고리 id와 기존 순서를 조회
        Map<String, Object> map = categoryMapper.selectParentIdAndOrders(categoryDTO.getId());
        Integer originalOrders = ObjectToInteger(map.get("orders"));
        Long originalParentId = ObjectToLong(map.get("parentId"));

        // 상위 카테고리를 변경한 경우
        if(originalParentId != categoryDTO.getParentId()){
            // 기존 상위 카테고리의 하위 카테고리들의 순서를 앞당겨준다.
            categoryMapper.shiftOrders(originalParentId, originalOrders);
            // 새로운 상위 카테고리의 하위 카테고리들의 마지막 순서를 조회한다.
            Integer maxOrders = categoryMapper.getLastOrders(categoryDTO.getParentId());
            // 새로운 상위 카테고리의 마지막에 위치시킨다.
            categoryDTO.setOrders(maxOrders + 1);
        }else{  // 싱위 카테고리를 변경하지 않은 경우, 순서를 유지한다.
            categoryDTO.setOrders(originalOrders);
        }
        categoryMapper.updateCategoryContents(categoryDTO);
    }

    // Object -> Integer
    private Integer ObjectToInteger(Object object){
        return Integer.parseInt(String.valueOf(object));
    }

    // Object -> Long
    private Long ObjectToLong(Object object){
        return Long.valueOf(String.valueOf(object));
    }
}
