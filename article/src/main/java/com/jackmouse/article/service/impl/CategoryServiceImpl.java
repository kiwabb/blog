package com.jackmouse.article.service.impl;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.jackmouse.article.entity.Category;
import com.jackmouse.article.mapper.CategoryMapper;
import com.jackmouse.article.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.jackmouse.article.entity.table.CategoryTableDef.CATEGORY;


/**
 *  服务层实现。
 *
 * @author zhoujiaangyao
 * @since 2024-12-30
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>  implements CategoryService{

    @Resource
    CategoryMapper categoryMapper;

    @Override
    public List<Category> querySortInfo() {
        QueryWrapper wrapper = QueryWrapper.create()
                .select(CATEGORY.ID, CATEGORY.CATEGORY_NAME)
                .orderBy(CATEGORY.SORT.asc())
                .limit(2);
        List<Category> categoryList = categoryMapper.selectListByQuery(wrapper);
        Category first = new Category();
        first.setId(0L);
        first.setCategoryName("推荐文章");
        categoryList.add(0, first);
        return categoryList;
    }
}
