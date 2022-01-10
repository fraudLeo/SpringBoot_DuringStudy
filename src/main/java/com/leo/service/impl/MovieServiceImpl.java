package com.leo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leo.dao.MovieDao;
import com.leo.domain.Movie;
import com.leo.service.MovieService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MovieServiceImpl extends ServiceImpl<MovieDao, Movie> implements MovieService{

    @Autowired
    private MovieDao movieDao;


    @Override
    public IPage<Movie> getPage(int currentPage, int pageSize) {
        IPage<Movie> page = new Page(currentPage, pageSize);
        movieDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Movie> getPage(int currentPage, int pageSize, Movie movie) {

        LambdaQueryWrapper<Movie> lqw = new LambdaQueryWrapper<Movie>();

        lqw.like(Strings.isNotEmpty(movie.getName()),Movie::getName,movie.getName());
        lqw.like(Strings.isNotEmpty(movie.getType()),Movie::getType,movie.getType());
//        lqw.like(double.isNotEmpty(movie.getScore()),Movie:,movie);
        lqw.like(Strings.isNotEmpty(movie.getActor()),Movie::getActor,movie.getName());


        IPage page = new Page(currentPage,pageSize);

        return movieDao.selectPage(page,lqw);
    }
}
