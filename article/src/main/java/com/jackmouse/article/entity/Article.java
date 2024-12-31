package com.jackmouse.article.entity;

import com.jackmouse.common.entity.BaseEntity;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;

import java.io.Serial;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

/**
 *  实体类。
 *
 * @author zhoujiaangyao
 * @since 2024-12-30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table("tb_article")
public class Article extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 文章表唯一主键
     */
    @Id(keyType = KeyType.Auto)
    private Long id;

    /**
     * 发表文章的用户
     */
    private Long userId;

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
    private byte[] articleContent;

    /**
     * 是否置顶（0否，1是）
     */
    private Boolean isTop;

    /**
     * 是否发布（0否，1是）
     */
    private Boolean isDraft;

    /**
     * 状态
     */
    private String status;

}
