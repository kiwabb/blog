package com.jackmouse.article.controller;

import com.jackmouse.article.dto.ArticlePreviewDTO;
import com.jackmouse.article.vo.ArticleSaveVO;
import com.jackmouse.common.model.Result;
import com.mybatisflex.core.paginate.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.jackmouse.article.entity.Article;
import com.jackmouse.article.service.ArticleService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 *  控制层。
 *
 * @author zhoujiaangyao
 * @since 2024-12-30
 */
@RestController
@RequestMapping("/v1/article/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 查询首页显示文章
     * @return 首页显示文章
     */
    @GetMapping("/sortArticles")
    public Result<Map<String, List<ArticlePreviewDTO>>> querySortArticles() {
        return Result.succeed(articleService.querySortArticles());
    }

    /**
     * 添加。
     *
     * @param article 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public Result<Boolean> save(@RequestBody ArticleSaveVO article) {
        return Result.succeed(articleService.saveArticle(article));
    }

    /**
     * 根据主键删除。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    public Result<Boolean> remove(@PathVariable Long id) {
        return Result.succeed(articleService.removeById(id));
    }

    /**
     * 根据主键更新。
     *
     * @param article 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    public Result<Boolean> update(@RequestBody Article article) {
        return Result.succeed(articleService.updateById(article));
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public Result<List<Article>> list() {
        return Result.succeed(articleService.list());
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public Result<Article> getInfo(@PathVariable Long id) {
        return Result.succeed(articleService.getById(id));
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public Result<Page<Article>> page(Page<Article> page) {
        return Result.succeed(articleService.page(page));
    }

}
