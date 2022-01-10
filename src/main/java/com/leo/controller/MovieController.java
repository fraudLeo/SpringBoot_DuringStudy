package com.leo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.leo.controller.utils.R;
import com.leo.domain.Movie;
import com.leo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    @Autowired
    private MovieService movieService;


    /**
     * 查询全部列表
     * @return new R(true,movieService.list())
     */
    @GetMapping
    public R getAll() {
        return new R(true,movieService.list());
    }

    /**
     * 保存数据，并检查，如果符合equal里面的条件，那么就会抛出异常。这个异常会被捕捉，并抛出，相应地会返回的flag
     * @param movie
     * @return
     * @throws IOException
     */

    @PostMapping
    public R save(@RequestBody Movie movie) throws IOException {

        if (movie.getName().equals("123")) throw new IOException();

        boolean flag = movieService.save(movie);

        return new R(flag,flag?"\"添加成功^_^\"" : "\"添加失败-_-!\"");
    }

    @PutMapping
    public R update(@RequestBody Movie movie) {
        return new R(movieService.updateById(movie));
    }

    @DeleteMapping("{id}")
    public R delete(@RequestBody Integer id) {
        return new R(movieService.removeById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, movieService.getById(id));
    }

    @GetMapping("currentPage/{currentPage}/pageSize/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize, Movie movie) {

        IPage<Movie> page = movieService.getPage(currentPage, pageSize, movie);

        if(currentPage>page.getPages()) {
            page = movieService.getPage((int)page.getPages(), pageSize, movie);
        }

        return new R(true,page);
    }

}
































