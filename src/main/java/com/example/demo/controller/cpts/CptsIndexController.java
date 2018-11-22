package com.example.demo.controller.cpts;

import com.example.demo.dao.model.ShoeInfo;
import com.example.demo.dao.util.JsonResult;
import com.example.demo.service.impl.CptsIndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * cpts 首页controller
 * @author lbs
 * @dete
 */
@Controller
public class CptsIndexController {

    //日志
    public static final Logger logger = LoggerFactory.getLogger(CptsIndexController.class);

    @Autowired
    private CptsIndexService cptsIndexService;

    /**
     * 获取鞋子信息
     * @return
     */
    @RequestMapping(value = "/cpts/shoeInfo", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult shoeInfo(){

        logger.info("进入获取鞋子信息Controller层");
        JsonResult jsonResult = new JsonResult();
        List<ShoeInfo> shoeInfos = cptsIndexService.queryAll();

        jsonResult.setFlag("success");
        jsonResult.setObject(shoeInfos);
        return jsonResult;
    }
}
