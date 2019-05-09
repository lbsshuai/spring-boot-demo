package com.example.demo.controller.cpts;

import com.example.demo.dao.common.CommonConstant;
import com.example.demo.dao.model.ShoeInfo;
import com.example.demo.dao.util.JsonResult;
import com.example.demo.dao.util.StringUtils;
import com.example.demo.dao.vo.CartRequestParam;
import com.example.demo.service.impl.CptsSingleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 商品详情页
 * @author lbs
 * @dete
 */
@Api(tags = "Product details page interface", position = 3)
@Controller
public class CptsSingleController {

    @Autowired
    private CptsSingleService cptsSingleService;

    //日志
    public static final Logger logger = LoggerFactory.getLogger(CptsSingleController.class);

    /**
     * 通过鞋子Id 获取鞋子信息
     * @param shoeId
     * @return
     */
    @ApiOperation(value = "获取商品信息通过商品ID", notes = "获取")
    @ApiImplicitParam(name = "shoeId", value = "商品ID", required = true, paramType = "query", dataType = "Integer", defaultValue = "2")
    @ApiResponse(code = 500, message = "系统报错!")
    @RequestMapping(value = "/cpts/getImgById", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getImgById(@RequestParam("shoeId") Integer shoeId){
        JsonResult jsonResult = new JsonResult();
        ShoeInfo imgByShoeId = cptsSingleService.getImgByShoeId(shoeId);
        jsonResult.setObject(imgByShoeId);
        return jsonResult;
    }

    /**
     * 验证用户是否登录
     * @param request
     * @param response
     * @return
     */
    @ApiOperation(value = "验证用户是否登录", notes = "验证")
    @ApiResponse(code = 500, message = "系统错误")
    @RequestMapping(value = "/cpts/verifyLogin", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult verifyLogin(HttpServletRequest request, HttpServletResponse response){
        logger.info("验证登录");
        JsonResult jsonResult = new JsonResult();
        //获取session
        HttpSession session = request.getSession();
        String attribute = (String) session.getAttribute(CommonConstant.USER_NAME);
        if(StringUtils.isNotBlank(attribute)){
            jsonResult.setObject(attribute);
        }else {
            jsonResult.setObject(null);
        }
        return jsonResult;
    }

    /**
     * 验证用户是否登录后加入购物车
     * @param request
     * @param response
     * @return
     */
    @ApiOperation(value = "加入购物车", notes = "添加")
    @RequestMapping(value = "/cpts/verifyLoginToCart", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult verifyLoginToCart(HttpServletRequest request, HttpServletResponse response,
                                        @ModelAttribute CartRequestParam cartRequestParam){
        logger.info("加入购物车 前提验证登录");
        JsonResult jsonResult = new JsonResult();
        //获取session
        HttpSession session = request.getSession();
        String attribute = (String) session.getAttribute(CommonConstant.USER_NAME);
        cartRequestParam.setUserName(attribute);
        if(StringUtils.isNotBlank(attribute)){
            cptsSingleService.addToCart(cartRequestParam);
        }

        jsonResult.setObject(attribute);
        return jsonResult;
    }
}

