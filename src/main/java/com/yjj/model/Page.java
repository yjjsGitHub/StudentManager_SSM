package com.yjj.model;

public class Page {

    public Page(int current, int count) {
        this.current = current;
        this.count = count;
        this.startIdx = (this.current-1)*pageSize;
        this.pages = (int)Math.ceil(count * 1.0 / pageSize);
    }

    public Page(int count) {
        this.count = count;
        this.startIdx = (this.current-1)*pageSize;
        this.pages = (int)Math.ceil(count * 1.0 / pageSize);
    }

    private Integer current = 1;    //当前页
    private Integer pageSize = 30;  //每页显示条数

    private Integer startIdx = 0;   //SQL分页查询开始下标
    private Integer pages;  //数据总页数（需要计算）
    private Integer count;  //数据总条数

    public Integer getCurrent() {
        return current;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStartIdx() {
        return startIdx;
    }

    public Integer getPages() {
        return pages;
    }

    public Integer getCount() {
        return count;
    }
}
