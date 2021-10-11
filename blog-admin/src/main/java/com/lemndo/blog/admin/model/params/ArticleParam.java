package com.lemndo.blog.admin.model.params;

import com.lemndo.blog.admin.entity.Category;
import com.lemndo.blog.admin.entity.Tag;
import lombok.Data;

import java.util.List;

@Data
public class ArticleParam {

    private Long id;

    private ArticleBodyParam body;

    private Category category;

    private String summary;

    private List<Tag> tags;

    private String title;

    private Integer currentPage;

    private Integer pageSize;

    private String queryString;
}