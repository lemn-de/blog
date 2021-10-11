package com.lemndo.blog.admin.model.params;

import com.lemndo.blog.admin.entity.Category;
import com.lemndo.blog.admin.entity.Tag;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ArticleParam {

    private Long id;

    /**
     * 评论数量
     */
    private Integer commentCounts;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 简介
     */
    private String summary;

    /**
     * 浏览数量
     */
    private Integer viewCounts;

    /**
     * 是否置顶
     */
    private Integer weight;

    /**
     * 作者id
     */
    private Long authorId;

    /**
     * 内容id
     */
    private Long bodyId;

    /**
     * 类别id
     */
    private Integer categoryId;

    private ArticleBodyParam body;

    private String title;

    private Integer currentPage;

    private Integer pageSize;

    private String queryString;
}