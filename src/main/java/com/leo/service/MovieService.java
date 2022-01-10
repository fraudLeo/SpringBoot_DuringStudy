package com.leo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leo.domain.Movie;

public interface MovieService extends IService<Movie> {

    IPage<Movie> getPage(int currentPage , int pageSize);

//  方法重载
    IPage<Movie> getPage(int currentPage , int pageSize, Movie movie);
}
