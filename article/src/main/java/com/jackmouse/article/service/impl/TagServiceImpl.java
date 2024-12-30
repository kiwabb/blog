package com.jackmouse.article.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.jackmouse.article.entity.Tag;
import com.jackmouse.article.mapper.TagMapper;
import com.jackmouse.article.service.TagService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author zhoujiaangyao
 * @since 2024-12-30
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>  implements TagService{

}
