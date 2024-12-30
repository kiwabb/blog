package com.jackmouse.article.controller;

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
import com.jackmouse.article.entity.Category;
import com.jackmouse.article.service.CategoryService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 *  控制层。
 *
 * @author zhoujiaangyao
 * @since 2024-12-30
 */
@RestController
@RequestMapping("/public/v1/article/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 添加。
     *
     * @param category 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public Result<Boolean> save(@RequestBody Category category) {
        return Result.succeed(categoryService.save(category));
    }

    /**
     * 根据主键删除。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    public Result<Boolean> remove(@PathVariable Long id) {
        return Result.succeed(categoryService.removeById(id));
    }

    /**
     * 根据主键更新。
     *
     * @param category 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    public Result<Boolean> update(@RequestBody Category category) {
        return Result.succeed(categoryService.updateById(category));
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public Result<List<Category>> list() {
        return Result.succeed(categoryService.list());
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public Result<Category> getInfo(@PathVariable Long id) {
        return Result.succeed(categoryService.getById(id));
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public Result<Page<Category>> page(Page<Category> page) {
        return Result.succeed(categoryService.page(page));
    }

}
