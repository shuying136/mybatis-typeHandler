package com.sheyu.mybatis.mybatisdemo;

import com.sheyu.mybatis.mybatisdemo.beans.Businesses;
import com.sheyu.mybatis.mybatisdemo.mapper.BusinessesMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisDemoApplication.class)
public class MybatisDemoApplicationTests {

    @Autowired
    BusinessesMapper businessesMapper;

    @Test
    public void contextLoads() {
        Businesses businesses = businessesMapper.findById(1);
        System.out.println(businesses);
    }

}
