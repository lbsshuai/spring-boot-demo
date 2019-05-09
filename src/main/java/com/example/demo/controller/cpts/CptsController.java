package com.example.demo.controller.cpts;

import com.example.demo.controller.aspect.Log;
import com.example.demo.controller.aspect.OperationType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author lbs
 * @dete
 */
@Controller
@Api(tags = "Page jump interface also",position = 0)
public class CptsController {

    //日志
    public static final Logger logger = LoggerFactory.getLogger(CptsController.class);

    /**
     * 鞋城页面
     * @return
     */
    @ApiOperation(value = "跳转到首页", notes = "跳转")
    @ApiResponses({
            @ApiResponse(code = 404, message = "请求路径没有或者跳转路径不正确"),
            @ApiResponse(code = 500, message = "系统异常")
    })
    @RequestMapping(value = "/cpts/index.html", method = RequestMethod.GET)
    @Log(operationType = OperationType.UNKNOW, operationName = "进入鞋城首页controller1111111111111111111111111111111111")
    public ModelAndView cptsIndex() {
        logger.info("进入首页");
        ModelAndView mav = new ModelAndView();

        mav.setViewName("cpts/index");
        return mav;
    }

    /**
     * 购物车页面
     * @return
     */
    @ApiOperation(value = "跳转购物车页面", notes = "跳转")
    @ApiResponses({
            @ApiResponse(code = 404, message = "请求路径不存在或者跳转路径不正确"),
            @ApiResponse(code = 500, message = "系统异常，嘿嘿！")
    })
    @RequestMapping(value = "/cpts/checkout.html", method = RequestMethod.GET)
    public ModelAndView cptsCheckout() {
        logger.info("进入购物车页面");
        ModelAndView mav = new ModelAndView();

        mav.setViewName("cpts/checkout");
        return mav;
    }

    /**
     * 用户信息补全页面
     * @return
     */
    @ApiOperation(value = "跳转到首页", notes = "跳转")
    @ApiResponses({
            @ApiResponse(code = 404, message = "请求路径不存在或者跳转地址不正确！"),
            @ApiResponse(code = 500, message = "系统很忙，请稍后访问")
    })
    @RequestMapping(value = "/cpts/contact.html", method = RequestMethod.GET)
    public ModelAndView cptsContact() {
        logger.info("进入用户信息补全页面");
        ModelAndView mav = new ModelAndView();

        mav.setViewName("cpts/contact");
        return mav;
    }

    /**
     * 产品展示页面（已不用）
     * @return
     */
    @ApiOperation(value = "跳转产品展示页面", notes = "跳转")
    @ApiResponses({
            @ApiResponse(code = 404, message = "请求路径不存在或者跳转地址不正确"),
            @ApiResponse(code = 500, message = "系统走神了！")
    })
    @RequestMapping(value = "/cpts/products.html", method = RequestMethod.GET)
    public ModelAndView cptsProducts() {
        logger.info("进入产品展示页面");
        ModelAndView mav = new ModelAndView();

        mav.setViewName("cpts/products");
        return mav;
    }

    /**
     * 原 注册页面（已不用）
     * @return
     */
    @ApiOperation(value = "跳转注册页面", notes = "跳转")
    @ApiResponses({
            @ApiResponse(code = 403, message = "该资源信息不存在"),
            @ApiResponse(code = 500, message = "系统开小差！")
    })
    @RequestMapping(value = "/cpts/account.html", method = RequestMethod.GET)
    public ModelAndView cptsAccount() {
        logger.info("进入注册页面");
        ModelAndView mav = new ModelAndView();

        mav.setViewName("cpts/account");
        return mav;
    }

    /**
     * 单品详情页
     * @return
     */
    @ApiOperation(value = "跳转单品详情页", notes = "跳转")
    @ApiResponses({
            @ApiResponse(code = 404, message = "请求路径不正确或者跳转路径不正确"),
            @ApiResponse(code = 500, message = "系统刚才困了！")
    })
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
    @ApiOperation(value = "跳转订单页面", notes = "跳转")
    @ApiResponses({
            @ApiResponse(code = 401, message = "请检查用户是否拥有此功能权限"),
            @ApiResponse(code = 500, message = "系统离家出走了！")
    })
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
    @ApiOperation(value = "跳转支付页面", notes = "跳转")
    @ApiResponses({
            @ApiResponse(code = 402, message = "未经授权，访问被服务器拒绝")
    })
    @RequestMapping(value = "cpts/pay.html", method = RequestMethod.GET)
    public String pay(){
        return "/cpts/pay";
    }

}
