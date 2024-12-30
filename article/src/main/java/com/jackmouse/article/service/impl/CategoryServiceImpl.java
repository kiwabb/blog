package com.jackmouse.article.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.jackmouse.article.entity.Category;
import com.jackmouse.article.mapper.CategoryMapper;
import com.jackmouse.article.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author zhoujiaangyao
 * @since 2024-12-30
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>  implements CategoryService{

}
