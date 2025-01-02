package com.jackmouse.article.service;

import com.mybatisflex.core.service.IService;
import com.jackmouse.article.entity.Category;

import java.util.List;

/**
 *  服务层。
 *
 * @author zhoujiaangyao
 * @since 2024-12-30
 */
public interface CategoryService extends IService<Category> {

    List<Category> querySortInfo();
}
