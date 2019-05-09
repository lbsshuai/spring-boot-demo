package com.example.demo.controller.cpts;

import com.example.demo.dao.exception.MyException;
import com.example.demo.dao.test.thread.ThreadCallable;
import com.example.demo.service.impl.CptsExportDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author lbs
 * @dete
 */
@Api(tags = "Data export interface", position = 6)
@Controller
@RequestMapping(value = "cpts/")
public class CptsExportDataController {

    @Autowired
    private CptsExportDataService cptsExportDataService;


  /*  @Autowired
    private ThreadPoolExecutor threadPoolTaskExecutor;

    @RequestMapping(value = "/thread/aaa", method = RequestMethod.GET)
    public void aaa(){
        ThreadCallable threadCallable = new ThreadCallable();
        Future submit = threadPoolTaskExecutor.submit(threadCallable);
        System.out.println(submit);
    }*/


    private final static Logger logger = LoggerFactory.getLogger(CptsExportDataController.class);

    /**
     * 数据导出页面
     */
    @ApiOperation(value = "跳转数据导出页面", notes = "跳转")
    @ApiResponses({
            @ApiResponse(code = 401, message = "未经授权，缺少此功能权限"),
            @ApiResponse(code = 500, message = "服务开小差！")
    })
    @RequestMapping(value = "export.html", method = RequestMethod.GET)
    public String export(){
        return "cpts/export";
    }

    /**
     * 导出excel 数据文件1
     * @param response
     * @throws MyException
     */
    @ApiOperation(value = "导出5万条数据", notes = "HSSFWorkbook")
    @RequestMapping(value = "exportData5", method = RequestMethod.GET)
    public void exportData5(HttpServletResponse response) throws MyException{
        try {
            //开始时间
            Date date = new Date();
            long startTime = date.getTime();
            logger.info(startTime + "");
            cptsExportDataService.exportData5(response);
            Date date1 = new Date();
            long endTime = date1.getTime();
            logger.info(endTime + "");
            logger.info((endTime - startTime) + "");
        } catch (Exception e) {
            if (e instanceof IOException){
                logger.error(e.getMessage());
                throw new MyException(e.getMessage(),"50000000");
            }
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }
    /**
     * 导出excel 数据文件2
     * @param response
     * @throws MyException
     */
    @ApiOperation(value = "导出100万条数据", notes = "XSSFWorkbook")
    @RequestMapping(value = "exportData10", method = RequestMethod.GET)
    public void exportData10(HttpServletResponse response) throws MyException{
        try {
            //开始时间
            Date date = new Date();
            long startTime = date.getTime();
            logger.info(startTime + "");
            cptsExportDataService.exportData10(response);
            Date date1 = new Date();
            long endTime = date1.getTime();
            logger.info(endTime + "");
            logger.info((endTime - startTime) + "");
        } catch (Exception e) {
            if (e instanceof IOException){
                logger.error(e.getMessage());
                throw new MyException(e.getMessage(),"50000000");
            }
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 导出excel 数据文件3
     * @param response
     * @throws MyException
     */
    @ApiOperation(value = "导出100万条数据", notes = "SXSSFWorkbook")
    @RequestMapping(value = "exportData100", method = RequestMethod.GET)
    public void exportData100(HttpServletResponse response) throws MyException{
        try {
            //开始时间
            Date date = new Date();
            long startTime = date.getTime();
            logger.info(startTime + "");
            cptsExportDataService.exportData100(response);
            Date date1 = new Date();
            long endTime = date1.getTime();
            logger.info(endTime + "");
            logger.info((endTime - startTime) + "");
        } catch (Exception e) {
            if (e instanceof IOException){
                logger.error(e.getMessage());
                throw new MyException(e.getMessage(),"50000000");
            }
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 读取Excel文件
     * @param file
     * @return
     */
    @ApiOperation(value = "读取Excel文件", notes = "读取")
    @RequestMapping(value = "readData", method = RequestMethod.POST)
    @ResponseBody
    public List<String[]> readData(@RequestPart("file")MultipartFile file){

        try {
            return cptsExportDataService.readData(file);
        } catch (MyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
