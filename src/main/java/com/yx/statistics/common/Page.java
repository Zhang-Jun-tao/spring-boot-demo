package com.yx.statistics.common;

import java.util.Map;

/**
 * Created by zhang on 2016/12/9.
 */
public class Page {

    private int currentPage;
    private int pageSize;
    private String url;
    private Map<String,Object> params;
    private int offset;



    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.offset=(currentPage-1)*pageSize;
        this.currentPage = currentPage;
    }

    public int getOffset() {
        return offset;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Page(int currentPage, int pageSize, String url, Map<String, Object> params) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.url = url;
        this.params = params;
    }
}
