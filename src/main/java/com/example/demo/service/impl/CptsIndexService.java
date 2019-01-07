package com.example.demo.service.impl;

import com.example.demo.dao.cpts.CptsIndexDao;
import com.example.demo.dao.model.ShoeInfo;
import com.example.demo.dao.util.PaginationUtil;
import com.example.demo.service.ICptsIndexService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lbs
 * @dete
 */
@Service
public class CptsIndexService implements ICptsIndexService {

    @Autowired
    private CptsIndexDao cptsIndexDao;

    @Override
    public PageInfo<ShoeInfo> queryAll(String pageNum, String pageSize) {
        PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        List<ShoeInfo> shoeInfos = cptsIndexDao.queryAll();
        PageInfo<ShoeInfo> pageInfo = new PageInfo<>(shoeInfos);
        return pageInfo;
    }

    @Override
    public PageInfo<ShoeInfo> queryShoeByPagination(PaginationUtil paginationUtil) {
        //pageHelper
        PageHelper.startPage(paginationUtil.getPageNum(),paginationUtil.getPageSize());
        List<ShoeInfo> shoeInfos = cptsIndexDao.queryShoeByPagination(paginationUtil);
        PageInfo<ShoeInfo> pageInfo = new PageInfo<>(shoeInfos);

        return pageInfo;
    }

}
