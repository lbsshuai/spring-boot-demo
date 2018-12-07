package com.example.demo.service;

import com.example.demo.dao.model.SingleInfo;

import java.util.List;

/**
 * 单品信息
 * @author lbs
 * @dete
 */
public interface ICptsSingleService {
    List<SingleInfo> queryById(Integer id);
}
