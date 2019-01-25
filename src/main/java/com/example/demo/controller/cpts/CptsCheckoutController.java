package com.example.demo.controller.cpts;

import com.example.demo.dao.util.JsonResult;
import com.example.demo.dao.vo.CartInfoVo;
import com.example.demo.service.ICptsCheckoutService;
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

    @RequestMapping(value = "cpts/getCartInfo", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getCartInfo(@RequestParam(value = "userName") String userName){
        JsonResult jsonResult = new JsonResult();
        List<CartInfoVo> cartInfo = cptsCheckoutService.getCartInfo(userName);
        jsonResult.setObject(cartInfo);
        return jsonResult;
    }

}
