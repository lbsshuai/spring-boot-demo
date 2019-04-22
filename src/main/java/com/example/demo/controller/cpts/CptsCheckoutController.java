package com.example.demo.controller.cpts;

import com.example.demo.dao.exception.MyException;
import com.example.demo.dao.util.JsonResult;
import com.example.demo.dao.vo.CartInfoVo;
import com.example.demo.dao.vo.CartInfoVoList;
import com.example.demo.service.impl.CptsCheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.spring.web.json.Json;

import java.lang.annotation.Retention;
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
    public JsonResult getCartInfo(@RequestParam(value = "userName") String userName) throws MyException {
        JsonResult jsonResult = new JsonResult();
        List<CartInfoVo> cartInfo = cptsCheckoutService.getCartInfo(userName);
        jsonResult.setObject(cartInfo);
        return jsonResult;
    }

    /**
     * 删除购物车中商品信息
     * @param id
     * @param userName
     * @return
     */
    @RequestMapping(value = "cpts/delectCartInfo", method = RequestMethod.GET)
    public void delectCartInfo(@RequestParam(value = "id") String id,
                               @RequestParam(value = "userName") String userName){
        cptsCheckoutService.deleteCartInfo(id, userName);
    }

    /**
     * 提交订单
     * @param userName
     */
    @RequestMapping(value = "cpts/storageCartInfo", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult storageCartInfo(@RequestParam(value = "userName") String userName) throws MyException {
        cptsCheckoutService.storageCartInfo(userName);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setFlag("true");
        return jsonResult;
    }
}
