package com.jackmouse.article.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jackmouse.article.entity.Category;
import com.jackmouse.article.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 预览文章
 *
 * @author yezhiqiu
 * @date 2021/08/10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticlePreviewDTO {

    /**
     * 文章id
     */
    private String id;

    /**
     * 作者
     */
    private String nickname;

    /**
     * 文章缩略图
     */
    private String articleCover;

    /**
     * 标题
     */
    private String articleTitle;

    /**
     * 发表时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime createTime;

    private Category categoryEntity;

    /**
     * 文章标签
     */
    private List<Tag> tagDTOList;


}

