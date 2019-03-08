package com.example.demo.dao.cpts;

import com.example.demo.dao.mapper.ExportMapper;
import com.example.demo.dao.model.Export;
import com.example.demo.dao.model.ExportExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lbs
 * @dete
 */
@Repository
public class CptsExportDao {

    @Autowired
    private ExportMapper exportMapper;

    /**
     * 导出数据
     * @return
     */
    public List<Export> exportData(){
        ExportExample example = new ExportExample();
        ExportExample.Criteria criteria = example.createCriteria();
        criteria.andIdIsNotNull();
        List<Export> exports = exportMapper.selectByExample(example);
        return exports;
    }

    /**
     * 导出一定数量的数据
     */
    public List<Export> selectDifferentId(Integer id){
        List<Export> exports = exportMapper.selectDifferentId(id);
        return exports;
    }
}
