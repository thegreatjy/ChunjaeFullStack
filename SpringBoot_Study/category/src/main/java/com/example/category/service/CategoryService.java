package com.example.category.service;

import com.example.category.domain.CategoryDTO;
import com.example.category.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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
    public boolean modifyOrders(List<Integer> newOrders) {
        Integer result = categoryMapper.updateOrders(newOrders);

        if(result > 0)  return true;
        else            return false;
    }

    // 카테고리 생성
    @Transactional  // [*****]
    public boolean createCategory(CategoryDTO categoryDTO) {
        Integer result = categoryMapper.createCategory(categoryDTO);

        // [*****]
        categoryDTO.setParentId(2L);
        categoryDTO.setShowFlag(1);
        categoryDTO.setUserId(1);
        categoryDTO.setName("node 12");


        if(result > 0)  return true;
        else            return false;
    }

    // 카테고리 수정
    @Transactional  // [*****]
    public void modifyCategory(CategoryDTO categoryDTO) {
        // 카테고리의 기존 상위 카테고리 id와 순서를 조회
        Map<String, Long> map = selectParentIdAndOrders(categoryDTO);

        // 상위 카테고리를 변경한 경우, 기존 상위 카테고리의 하위 카테고리들의 순서를 앞당겨준다.
        if(map.get("parentId") != categoryDTO.getParentId()){

        }else{  // 싱위 카테고리를 변경하지 않은 경우, 순서를 유지한다.
            categoryDTO.setOrders(Integer.parseInt(String.valueOf(map.get("orders"))));
        }
        updateCategoryContents(categoryDTO);

    }

    // 카테고리 부모 id, 이름, 사용 여부, 순서 수정
    private boolean updateCategoryContents(CategoryDTO categoryDTO){
        Integer result = categoryMapper.updateCategoryContents(categoryDTO);

        if(result > 0)  return true;
        else            return false;
    }

    // 카테고리의 부모 id와 순서를 조회
    private Map<String, Long> selectParentIdAndOrders(CategoryDTO categoryDTO){
        Map<String, Long> map = categoryMapper.selectParentIdAndOrders(categoryDTO.getId());
        return map;
    }

    // 순서 앞당기기
    //private void shiftCategories()
}
