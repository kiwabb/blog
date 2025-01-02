package com.jackmouse.article.service;

import com.jackmouse.article.dto.ArticlePreviewDTO;
import com.jackmouse.article.vo.ArticleSaveVO;
import com.mybatisflex.core.service.IService;
import com.jackmouse.article.entity.Article;

import java.util.List;
import java.util.Map;

/**
 *  服务层。
 *
 * @author zhoujiaangyao
 * @since 2024-12-30
 */
public interface ArticleService extends IService<Article> {

    Map<String, List<ArticlePreviewDTO>> querySortArticles();

    Boolean saveArticle(ArticleSaveVO article);
}
