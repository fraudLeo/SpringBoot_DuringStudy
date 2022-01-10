package com.leo.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("movie")
public class Movie {

    private Integer id;
    private String name;
    private String type;
    private double score;
    private String img;
    private String url;
    private String actor;
    private Date time;


}
