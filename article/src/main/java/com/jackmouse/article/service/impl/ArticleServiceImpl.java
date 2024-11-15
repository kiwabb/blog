package com.jackmouse.article.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.jackmouse.article.entity.Article;
import com.jackmouse.article.mapper.ArticleMapper;
import com.jackmouse.article.service.ArticleService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author zhoujiaangyao
 * @since 2024-11-15
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>  implements ArticleService{

}
