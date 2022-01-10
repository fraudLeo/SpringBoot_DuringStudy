package com.leo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leo.domain.Movie;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MovieDao extends BaseMapper<Movie> {
}
