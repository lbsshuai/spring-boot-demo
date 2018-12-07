package com.example.demo.controller.cpts;

import com.example.demo.dao.model.SingleInfo;
import com.example.demo.service.impl.CptsSingleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 商品详情页
 * @author lbs
 * @dete
 */
@Controller
public class CptsSingleController {

    @Autowired
    private CptsSingleService cptsSingleService;

    //日志
    public static final Logger logger = LoggerFactory.getLogger(CptsSingleController.class);

    /**
     * 单品详情页
     * @return
     */
    @RequestMapping(value = "/cpts/single.html", method = RequestMethod.GET)
    public ModelAndView cptsSingle(@RequestParam Integer id) {
        logger.info("进入首页");
        ModelAndView mav = new ModelAndView();
        List<SingleInfo> singleInfos = cptsSingleService.queryById(id);
        mav.addObject("singleInfo", singleInfos);
        mav.setViewName("cpts/single");
        return mav;
    }
}
