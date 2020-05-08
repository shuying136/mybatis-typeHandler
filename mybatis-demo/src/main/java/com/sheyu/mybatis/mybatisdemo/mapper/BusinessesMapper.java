package com.sheyu.mybatis.mybatisdemo.mapper;

import com.sheyu.mybatis.mybatisdemo.beans.Businesses;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;


@Service
@Mapper
public interface BusinessesMapper {

    Businesses findById(Integer id);
}
