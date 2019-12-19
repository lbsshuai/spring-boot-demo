package com.example.demo.dao.cpts;

import com.example.demo.dao.mapper.ShoeInfoMapper;
import com.example.demo.dao.model.ShoeInfo;
import com.example.demo.dao.util.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lbs
 * @dete
 */
@Repository
public class CptsIndexDao {

    @Autowired
    private ShoeInfoMapper shoeInfoMapper;

    public List<ShoeInfo> queryAll(){
        return shoeInfoMapper.queryAll();
    }

    public List<ShoeInfo> queryShoeByPagination(PaginationUtil paginationUtil){
        return shoeInfoMapper.queryShoeByPagination(paginationUtil);
    }

}