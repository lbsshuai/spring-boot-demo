package com.example.demo.controller.cpts;

import com.example.demo.dao.exception.MyException;
import com.example.demo.service.impl.CptsExportDataService;
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

/**
 * @author lbs
 * @dete
 */
@Controller
@RequestMapping(value = "cpts/")
public class CptsExportDataController {

    @Autowired
    private CptsExportDataService cptsExportDataService;

    private final static Logger logger = LoggerFactory.getLogger(CptsExportDataController.class);

    /**
     * 数据导出页面
     */
    @RequestMapping(value = "export.html", method = RequestMethod.GET)
    public String export(){
        return "cpts/export";
    }

    /**
     * 导出excel 数据文件
     * @param response
     * @throws MyException
     */
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
     * 导出excel 数据文件
     * @param response
     * @throws MyException
     */
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
     * 读取Excel文件
     * @param file
     * @return
     */
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
