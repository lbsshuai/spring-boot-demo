package com.example.demo.controller.cpts;

import com.example.demo.dao.model.ShoeInfo;
import com.example.demo.dao.util.JsonResult;
import com.example.demo.dao.util.PaginationUtil;
import com.example.demo.service.impl.CptsIndexService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * cpts 首页controller
 * @author lbs
 * @dete
 */
@Controller
@RequestMapping("/cpts/")
public class CptsIndexController {

    //日志
    public static final Logger logger = LoggerFactory.getLogger(CptsIndexController.class);

    @Autowired
    private CptsIndexService cptsIndexService;

    /**
     * 获取鞋子信息
     * @return
     */
    @RequestMapping(value = "shoeInfo", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult shoeInfo(HttpServletRequest request,
            @RequestParam(value = "pageNum")String pageNum, @RequestParam("pageSize") String pageSize){

        logger.info("进入获取鞋子信息Controller层");
        JsonResult jsonResult = new JsonResult();
        PaginationUtil paginationUtil = new PaginationUtil();
        paginationUtil.setPageNum(Integer.parseInt(pageNum));
        paginationUtil.setPageSize(Integer.parseInt(pageSize));
        PageInfo<ShoeInfo> pageInfo = cptsIndexService.queryShoeByPagination(paginationUtil);

        jsonResult.setFlag("success");
        jsonResult.setObject(pageInfo);
        return jsonResult;
    }
}
