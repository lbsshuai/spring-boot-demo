package com.example.demo.controller.cpts;

import com.example.demo.dao.exception.MyException;
import com.example.demo.dao.model.ConsigneeInfo;
import com.example.demo.dao.util.JsonResult;
import com.example.demo.service.impl.CptsSubmitOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单提交
 * @author lbs
 * @dete
 */
@RestController
@RequestMapping(value = "/cpts/")
public class CptsSubmitOrderController {

    @Autowired
    private CptsSubmitOrderService cptsSubmitOrderService;

    @PostMapping(value = "submit")
    public JsonResult submitOrder(@ModelAttribute ConsigneeInfo consigneeInfo){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setFlag("true");
        try {
            cptsSubmitOrderService.submitOrder(consigneeInfo);
        } catch (Exception e) {
            jsonResult.setFlag("false");
            if(e instanceof MyException){
                jsonResult.setMessage(e.getMessage());
            }
            jsonResult.setMessage(e.getMessage());
            return jsonResult;
        }
        return jsonResult;
    }

}
