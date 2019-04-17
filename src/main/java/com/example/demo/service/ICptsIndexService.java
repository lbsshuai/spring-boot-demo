package com.example.demo.service;

import com.example.demo.dao.model.ShoeInfo;
import com.example.demo.dao.util.PaginationUtil;
import com.github.pagehelper.PageInfo;

/**
 * 鞋子信息Service
 * @author lbs
 * @dete
 */
public interface ICptsIndexService {

    PageInfo<ShoeInfo> queryAll(String pageNum, String pageSize);

    PageInfo<ShoeInfo>  queryShoeByPagination(PaginationUtil paginationUtil);
}
