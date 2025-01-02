package com.jackmouse.article.service.impl;

import com.jackmouse.article.dto.ArticlePreviewDTO;
import com.jackmouse.article.entity.ArticleTag;
import com.jackmouse.article.service.ArticleTagService;
import com.jackmouse.article.vo.ArticleSaveVO;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.jackmouse.article.entity.Article;
import com.jackmouse.article.mapper.ArticleMapper;
import com.jackmouse.article.service.ArticleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Resource
    ArticleTagService articleTagService;

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

    @Transactional
    @Override
    public Boolean saveArticle(ArticleSaveVO article) {
        Article newArticle = Article.builder()
                .userId(1L)
                .categoryId(article.getCategoryId())
                .articleCover(article.getArticleCover())
                .articleTitle(article.getArticleTitle())
                .articleContent(article.getArticleContent())
                .isTop(0)
                .isDraft(article.getIsDraft())
                .status("0")
                .build();
        this.save(newArticle);
        List<ArticleTag> articleTags = article.getTagIdList().stream()
                .map(tag -> ArticleTag.builder()
                        .articleId(newArticle.getId())
                        .tagId(tag.getId())
                        .build()
                ).toList();
        articleTagService.saveBatch(articleTags);
        return true;
    }
}
