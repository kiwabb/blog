package com.jackmouse.article.mapper;

import com.jackmouse.article.dto.ArticlePreviewDTO;
import com.mybatisflex.core.BaseMapper;
import com.jackmouse.article.entity.Article;

import java.util.List;

/**
 *  映射层。
 *
 * @author zhoujiaangyao
 * @since 2024-12-30
 */
public interface ArticleMapper extends BaseMapper<Article> {

    List<ArticlePreviewDTO> querySortCategoryArticles();

    List<ArticlePreviewDTO> queryRecommendArticles();
}
