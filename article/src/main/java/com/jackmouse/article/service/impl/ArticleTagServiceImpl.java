package com.jackmouse.article.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.jackmouse.article.entity.ArticleTag;
import com.jackmouse.article.mapper.ArticleTagMapper;
import com.jackmouse.article.service.ArticleTagService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author zhoujiaangyao
 * @since 2025-01-02
 */
@Service
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag>  implements ArticleTagService{

}
