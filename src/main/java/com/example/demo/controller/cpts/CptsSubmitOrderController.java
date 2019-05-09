package com.example.demo.controller.cpts;

import com.example.demo.dao.exception.MyException;
import com.example.demo.dao.model.ConsigneeInfo;
import com.example.demo.dao.util.JsonResult;
import com.example.demo.service.impl.CptsSubmitOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
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
@Api(tags = "Order page interface", position = 5)
@RestController
@RequestMapping(value = "/cpts/")
public class CptsSubmitOrderController {

    @Autowired
    private CptsSubmitOrderService cptsSubmitOrderService;

    /**
     * 地址信息提交
     * @param consigneeInfo
     * @return
     */
    @ApiOperation(value = "提交收件人地址信息", notes = "提交")
    @ApiResponse(code = 500, message = "系统异常！")
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
