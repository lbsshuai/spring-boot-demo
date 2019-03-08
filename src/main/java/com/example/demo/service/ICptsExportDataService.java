package com.example.demo.service;

import com.example.demo.dao.exception.MyException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author lbs
 * @dete
 */
public interface ICptsExportDataService {

    /**
     * 导出数据
     * @return
     */
    void exportData5(HttpServletResponse response)throws IOException;
    void exportData10(HttpServletResponse response)throws IOException;
    void exportData100(HttpServletResponse response)throws IOException;

    List<String[]> readData(MultipartFile file) throws MyException, IOException;
}
