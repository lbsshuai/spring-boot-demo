package com.example.demo.controller.cpts;

import com.example.demo.dao.model.SingleInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Name;
import java.util.List;

/**
 * @author lbs
 * @dete
 */
@Controller
public class CptsController {

    //日志
    public static final Logger logger = LoggerFactory.getLogger(CptsController.class);

    /**
     * 鞋城页面
     * @return
     */
    @RequestMapping(value = "/cpts/index.html", method = RequestMethod.GET)
    public ModelAndView cptsIndex() {
        logger.info("进入首页");
        ModelAndView mav = new ModelAndView();

        mav.setViewName("cpts/index");
        return mav;
    }

    @RequestMapping(value = "/cpts/checkout.html", method = RequestMethod.GET)
    public ModelAndView cptsCheckout() {
        logger.info("进入购物车页面");
        ModelAndView mav = new ModelAndView();

        mav.setViewName("cpts/checkout");
        return mav;
    }

    @RequestMapping(value = "/cpts/contact.html", method = RequestMethod.GET)
    public ModelAndView cptsContact() {
        logger.info("进入首页");
        ModelAndView mav = new ModelAndView();

        mav.setViewName("cpts/contact");
        return mav;
    }

    @RequestMapping(value = "/cpts/products.html", method = RequestMethod.GET)
    public ModelAndView cptsProducts() {
        logger.info("进入首页");
        ModelAndView mav = new ModelAndView();

        mav.setViewName("cpts/products");
        return mav;
    }

    @RequestMapping(value = "/cpts/account.html", method = RequestMethod.GET)
    public ModelAndView cptsAccount() {
        logger.info("进入首页");
        ModelAndView mav = new ModelAndView();

        mav.setViewName("cpts/account");
        return mav;
    }

    /**
     * 单品详情页
     * @return
     */
    @RequestMapping(value = "/cpts/single.html", method = RequestMethod.GET)
    public ModelAndView cptsSingle() {
        logger.info("进入详情页");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("cpts/single");
        mav.addObject("yu","1111111");
        return mav;
    }

    /**
     * 进入订单页面
     * @return
     */
    @RequestMapping(value = "cpts/submitOrder.html", method = RequestMethod.GET)
    public ModelAndView submitOrder(){
        logger.info("进入订单页面");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cpts/submitOrder");
        return modelAndView;
    }

    /**
     * 跳转支付页面
     * @return
     */
    @RequestMapping(value = "cpts/pay.html", method = RequestMethod.GET)
    public String pay(){
        return "/cpts/pay";
    }

}
