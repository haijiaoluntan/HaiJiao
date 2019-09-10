package com.haijiao.utils;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 分页工具类
 *
 * @param <T>
 */
@Component
public class Pager<T> {
    
    public static int pageSize = 8;    //页大小：每页最大的记录数量
    private List<T> result;             //当前页的结果集
    private int totalPage;              //总页数
    
    public Pager() {
    }
    
    public Pager(List<T> result, int totalPage) {
        this.result = result;
        this.totalPage = totalPage;
    }
    
    public static void setPageSize(int pageSize) {
        Pager.pageSize = pageSize;
    }
    
    public List<T> getResult() {
        return result;
    }
    
    public void setResult(List<T> result) {
        this.result = result;
    }
    
    public int getTotalPage() {
        return totalPage;
    }
    
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    
}
