package com.jackmouse.article.vo;

import com.jackmouse.article.entity.Tag;
import lombok.Data;

import java.util.List;

/**
 * @ClassName ArticleSaveVO
 * @Description 创建文章请求参数
 * @Author zhoujiaangyao
 * @Date 2025/1/2 09:05
 * @Version 1.0
 **/
@Data
public class ArticleSaveVO {
    /**
     * 文章分类
     */
    private Long categoryId;

    /**
     * 文章图片
     */
    private String articleCover;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章内容
     */
    private String articleContent;

    private Integer isDraft;

    private List<Tag> tagIdList;
}
