package com.bing.lan.mainLib.comm.bean;

import java.util.List;

/**
 * Created by 蓝兵 on 2018/6/27.
 */
public class QueryDomain<T> {

    private int totalSize;
    private int pageSize = 10;//每页数量
    private int currentPage = 1;
    private int totalPages = 0;
    private List<T> list;

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
