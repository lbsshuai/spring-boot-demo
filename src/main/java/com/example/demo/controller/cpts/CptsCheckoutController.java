package com.example.demo.controller.cpts;

import com.example.demo.dao.util.JsonResult;
import com.example.demo.dao.vo.CartInfoVo;
import com.example.demo.service.impl.CptsCheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 购物车页面
 * @author lbs
 * @dete
 */
@Controller
public class CptsCheckoutController {

    @Autowired
    private CptsCheckoutService cptsCheckoutService;

    /**
     * 获取购物车中信息
     * @param userName
     * @return
     */
    @RequestMapping(value = "cpts/getCartInfo", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getCartInfo(@RequestParam(value = "userName") String userName){
        JsonResult jsonResult = new JsonResult();
        List<CartInfoVo> cartInfo = cptsCheckoutService.getCartInfo(userName);
        jsonResult.setObject(cartInfo);
        return jsonResult;
    }

    /**
     * 删除购物车中商品的信息呵呵
     * @param id
     * @param userName
     * @return
     */
    @RequestMapping(value = "cpts/delectCartInfo", method = RequestMethod.GET)
    @ResponseBody
    public void delectCartInfo(@RequestParam(value = "id") String id,
                               @RequestParam(value = "userName") String userName){
        cptsCheckoutService.deleteCartInfo(id, userName);
        System.out.println(id+userName);
    }
}
