package com.example.demo.service.impl;

import com.example.demo.dao.cpts.CptsIndexDao;
import com.example.demo.dao.model.ShoeInfo;
import com.example.demo.service.ICptsIndexService;
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
    public List<ShoeInfo> queryAll() {
        return cptsIndexDao.queryAll();
    }
}
