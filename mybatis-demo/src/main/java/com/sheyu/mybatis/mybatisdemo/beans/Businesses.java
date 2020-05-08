package com.sheyu.mybatis.mybatisdemo.beans;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Businesses {
    private Integer id;
    private String name;
    private List<Integer> accessIds;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getAccessIds() {
        return accessIds;
    }

    public void setAccessIds(List<Integer> accessIds) {
        this.accessIds = accessIds;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Businesses{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accessIds=" + accessIds +
                ", createTime=" + createTime +
                '}';
    }
}
