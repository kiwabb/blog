package com.jackmouse.article.service.impl;

import com.jackmouse.article.dto.ArticlePreviewDTO;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.jackmouse.article.entity.Article;
import com.jackmouse.article.mapper.ArticleMapper;
import com.jackmouse.article.service.ArticleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *  服务层实现。
 *
 * @author zhoujiaangyao
 * @since 2024-12-30
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>  implements ArticleService{

    @Resource
    ArticleMapper articleMapper;

    @Override
    public Map<String, List<ArticlePreviewDTO>> querySortArticles() {
        // 查询推荐分类文章
        List<ArticlePreviewDTO> sortCategoryArticles = articleMapper.querySortCategoryArticles();
        Map<String, List<ArticlePreviewDTO>> result = sortCategoryArticles
                .stream()
                .collect(
                        Collectors.groupingBy(articlePreviewDTO ->
                                articlePreviewDTO.getCategoryEntity().getId().toString()
                        ));
        // 查询推荐文章
        List<ArticlePreviewDTO> articleRecommendDTOS = articleMapper.queryRecommendArticles();
        result.put("0", articleRecommendDTOS);
        return result;
    }
}
