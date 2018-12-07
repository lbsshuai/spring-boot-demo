package com.example.demo.dao.cpts;

import com.example.demo.dao.mapper.SingleInfoMapper;
import com.example.demo.dao.model.SingleInfo;
import com.example.demo.dao.model.SingleInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lbs
 * @dete
 */
@Repository
public class CptsSingleDao {

    @Autowired
    private SingleInfoMapper singleInfoMapper;

    public List<SingleInfo> queryById(Integer id){
        SingleInfoExample example = new SingleInfoExample();
        example.createCriteria().andIdEqualTo(id);

        List<SingleInfo> singleInfos = singleInfoMapper.selectByExample(example);
        return singleInfos;
    }
}
