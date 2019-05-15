package com.example.demo.controller.cpts;

import com.example.demo.dao.exception.MyException;
import com.example.demo.dao.util.JsonResult;
import com.example.demo.dao.vo.CartInfoVo;
import com.example.demo.dao.vo.CartInfoVoList;
import com.example.demo.service.impl.CptsCheckoutService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(tags = "Shopping cart page interface", position = 4)/*position 现在不起作用  原用来排版 页面展示先后顺序 */
@Controller
public class CptsCheckoutController {

    @Autowired
    private CptsCheckoutService cptsCheckoutService;

    /**
     * 获取购物车中信息
     * @param userName
     * @return
     */

    @ApiOperation(value = "获取购物车中的信息", notes = "获取")
    @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String", paramType = "query", defaultValue = "qqq")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或者跳转路径不正确")
    })
    @RequestMapping(value = "cpts/getCartInfo", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getCartInfo(@RequestParam(value = "userName") String userName) throws MyException {
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
    @ApiOperation(value = "删除购物车中商品信息",notes = "删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String", paramType = "query", defaultValue = "qqq"),
            @ApiImplicitParam(name = "color", value = "商品颜色", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "商品大小", required = true, dataType = "String", paramType = "query")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或者跳转路径不正确")
    })
    @RequestMapping(value = "cpts/delectCartInfo", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delectCartInfo(@RequestParam(value = "id") String id,
                               @RequestParam(value = "userName") String userName,
                                     @RequestParam(value = "color") String color,
                                     @RequestParam(value = "size") String size){
        cptsCheckoutService.deleteCartInfo(id, userName, color, size);
        System.out.println(id+userName);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setFlag("true");
        return jsonResult;
    }

    /**
     * 提交订单
     * @param userName
     */
    @ApiOperation(value = "提交订单", notes = "提交")
    @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String", paramType = "query", defaultValue = "qqq")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或者跳转路径不正确")
    })
    @RequestMapping(value = "cpts/storageCartInfo", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult storageCartInfo(@RequestParam(value = "userName") String userName) throws MyException {
        cptsCheckoutService.storageCartInfo(userName);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setFlag("true");
        return jsonResult;
    }
}
