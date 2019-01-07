package com.example.demo.dao.util;

import lombok.Data;

/**
 * @author lbs
 * @dete
 */
public class PaginationUtil {

    // 每页条数
    private Integer pageSize;
    // 页码
    private Integer pageNum;
    // 数据从第几条开始
    private Integer pageSizeStart;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSizeStart() {
        return pageSizeStart;
    }

    public void setPageSizeStart(Integer pageSizeStart) {
        this.pageSizeStart = pageSizeStart;
    }
}
