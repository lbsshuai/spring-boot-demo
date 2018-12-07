package com.example.demo.service.impl;

import com.example.demo.dao.cpts.CptsSingleDao;
import com.example.demo.dao.model.SingleInfo;
import com.example.demo.service.ICptsSingleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lbs
 * @dete
 */
@Service
public class CptsSingleService implements ICptsSingleService{

    @Autowired
    private CptsSingleDao cptsSingleDao;

    @Override
    public List<SingleInfo> queryById(Integer id) {
        return  cptsSingleDao.queryById(id);
    }
}
