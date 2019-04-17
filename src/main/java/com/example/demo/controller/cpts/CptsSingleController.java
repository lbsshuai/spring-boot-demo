package com.example.demo.controller.cpts;

import com.example.demo.dao.common.CommonConstant;
import com.example.demo.dao.model.ShoeInfo;
import com.example.demo.dao.util.JsonResult;
import com.example.demo.dao.util.StringUtils;
import com.example.demo.service.impl.CptsSingleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
     * 通过鞋子Id 获取鞋子信息
     * @param shoeId
     * @return
     */
    @RequestMapping(value = "/cpts/getImgById", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getImgById(@RequestParam("shoeId") Integer shoeId){
        JsonResult jsonResult = new JsonResult();
        ShoeInfo imgByShoeId = cptsSingleService.getImgByShoeId(shoeId);
        jsonResult.setObject(imgByShoeId);
        return jsonResult;
    }

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
    @RequestMapping(value = "/cpts/verifyLoginToCart", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult verifyLoginToCart(HttpServletRequest request, HttpServletResponse response,
                                  @RequestParam(value = "id") String id , @RequestParam(value = "num") String num){
        logger.info("加入购物车 前提验证登录");
        JsonResult jsonResult = new JsonResult();
        //获取session
        HttpSession session = request.getSession();
        String attribute = (String) session.getAttribute(CommonConstant.USER_NAME);
        if(StringUtils.isNotBlank(attribute)){
            cptsSingleService.addToCart(id, attribute, num);
        }

        jsonResult.setObject(attribute);
        return jsonResult;
    }
}
