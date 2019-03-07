package com.example.demo.service.impl;

import com.example.demo.dao.cpts.CptsExportDao;
import com.example.demo.dao.exception.MyException;
import com.example.demo.dao.model.Export;
import com.example.demo.service.ICptsExportDataService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lbs
 * @dete
 */
@Service
public class CptsExportDataService implements ICptsExportDataService {

    private final static Logger logger = LoggerFactory.getLogger(CptsExportDataService.class);

    @Autowired
    private CptsExportDao cptsExportDao;

    /**
     * 导出数据 50000条
     */
    public void exportData5(HttpServletResponse response)throws IOException{
        List<Export> exports = cptsExportDao.exportData();
        //导出行数在65535条以内
        export1(exports, response);
        //导出行数在1048576以内
        //export2(exports, response);
    }
    /**
     * 导出数据 50000条
     */
    public void exportData10(HttpServletResponse response)throws IOException{
        List<Export> exports = cptsExportDao.exportData();
        //导出行数在65535条以内
        //export1(exports, response);
        //导出行数在1048576以内
        export2(exports, response);
    }

    /**
     * 导出方法 一
     * 详细配置请参考
     * https://blog.csdn.net/zhufei463738313/article/details/77426499
     * XSSFWorkbook 和HSSFWorkbook区别就是：
     * XSSFWorkbook只能操作excel2007以上版本，HSSFWorkbook只操作excel2003一下的版本
     */
    /**
     * 流程：
     * HSSFWorkbook     创建模板
     * HSSFSheet        创建表
     * HSSFRow          创建行
     * HSSFCell         创建列
     * respons          输出
     * 中间可以改变表格格式，样式，加上填充内容
     */
    private void export1(List<Export> exports, HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();

        //查看数据量多少
        int size = exports.size();
        int num = size/50000;
        //循环创建表 每张表最多放50000条数据
        for (int i = 0; i<= num; i++){
            HSSFSheet sheet = getSheet(workbook, i+1);

            int rowNum = 2;//从第二行开始添加数据，第一行是标题
            //在表中存放查询到的数据 放入对应的列
            //HSSFWorkbook最多导出65535条数据，所以要分多张表导出
            int endNum = (i+1) * 50000;
            if(endNum > size){
                endNum = size;
            }
            for (int startNum = i * 50000; startNum< endNum; startNum ++){
                HSSFRow row = sheet.createRow(rowNum);
                Export export = exports.get(startNum);
                //逐行加入cell
                insertCell(row,export);
                rowNum ++;
            }
        }

        //设置文件名字
        String fileName = "data" + ".xls";
        //（ 二进制流，不知道下载文件类型）
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" +fileName);
        //刷新缓冲区
        response.flushBuffer();
        //输出
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    /*
    获得Sheet
     */
    private HSSFSheet getSheet(HSSFWorkbook workbook, int num){
        HSSFSheet sheet = workbook.createSheet("数据信息表"+ num);

        //合并单元格
        CellRangeAddress region = new CellRangeAddress(0,0,0,3);
        sheet.addMergedRegion(region);

        //设置标题
        HSSFRow rowTitle = sheet.createRow(0);
        HSSFCell cellTitle = rowTitle.createCell(0);
        cellTitle.setCellValue("我的数据");

        //表头名称
        String[] headers = {"ID", "姓名", "性别", "身高","h1","h2","a3","a4","r5","t6","t7","u8","u9","010"};
        //在excel表中添加表头
        HSSFRow row = sheet.createRow(1);
        for (int i = 0; i < headers.length; i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        return sheet;
    }

    /*
    逐行加入
     */
    private void insertCell(HSSFRow row, Export export){
        row.createCell(0).setCellValue(export.getId());
        row.createCell(1).setCellValue(export.getName());
        row.createCell(2).setCellValue(export.getSex());
        row.createCell(3).setCellValue(export.getHigh());
        row.createCell(4).setCellValue(export.getH1());
        row.createCell(5).setCellValue(export.getH2());
        row.createCell(6).setCellValue(export.getA3());
        row.createCell(7).setCellValue(export.getA4());
        row.createCell(8).setCellValue(export.getR5());
        row.createCell(9).setCellValue(export.getT6());
        row.createCell(10).setCellValue(export.getT7());
        row.createCell(11).setCellValue(export.getU8());
        row.createCell(12).setCellValue(export.getU9());
        row.createCell(13).setCellValue(export.getO10());
    }

    /**
     * 导出方法2
     * @param exports
     * @param response
     * @throws IOException
     */
    private void export2(List<Export> exports, HttpServletResponse response) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("数据信息表");

        //合并单元格
        CellRangeAddress region = new CellRangeAddress(0,0,0,3);
        sheet.addMergedRegion(region);

        //设置标题
        XSSFRow rowTitle = sheet.createRow(0);
        XSSFCell cellTitle = rowTitle.createCell(0);
        cellTitle.setCellValue("我的数据");

        //设置样式  边框 左右居中
        XSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);

        //设置文件名字
        String fileName = "data" + ".xls";
        int rowNum = 2;
        //表头名称
        String[] headers = {"ID", "姓名", "性别", "身高","h1","h2","a3","a4","r5","t6","t7","u8","u9","010"};
        //在excel表中添加表头
        XSSFRow row = sheet.createRow(1);
        for (int i = 0; i < headers.length; i++){
            XSSFCell cell = row.createCell(i);
            XSSFRichTextString text = new XSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //在表中存放查询到的数据 放入对应的列
        for (Export export : exports){
            XSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(export.getId());
            row1.createCell(1).setCellValue(export.getName());
            row1.createCell(2).setCellValue(export.getSex());
            row1.createCell(3).setCellValue(export.getHigh());
            row1.createCell(4).setCellValue(export.getH1());
            row1.createCell(5).setCellValue(export.getH2());
            row1.createCell(6).setCellValue(export.getA3());
            row1.createCell(7).setCellValue(export.getA4());
            row1.createCell(8).setCellValue(export.getR5());
            row1.createCell(9).setCellValue(export.getT6());
            row1.createCell(10).setCellValue(export.getT7());
            row1.createCell(11).setCellValue(export.getU8());
            row1.createCell(12).setCellValue(export.getU9());
            row1.createCell(13).setCellValue(export.getO10());
            rowNum ++;
        }

        //（ 二进制流，不知道下载文件类型）
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" +fileName);
        //刷新缓冲区
        response.flushBuffer();
        //输出
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    /**
     * 读取数据
     * @param file
     */
    @Override
    public List<String[]> readData(MultipartFile file)  throws MyException, IOException{
        //检查文件
        checkFile(file);
        //获得Workbook工作簿对象
        Workbook workbook = getWorkbook(file);
        //创建返回对象 把每行中的值当做一个数组，所有行作为一个集合返回
        List<String[]> list = new ArrayList<>();
        if(workbook != null){
            for (int sheetNum = 0; sheetNum <workbook.getNumberOfSheets();sheetNum++){
                //获取当前Sheet工作表
                Sheet sheet = workbook.getSheetAt(sheetNum);
                if(sheet == null){
                    continue;
                }
                //获取当前Sheet的开始行
                int firstRowNum = sheet.getFirstRowNum();
                //获得当前sheet的结束行
                int lastRowNum = sheet.getLastRowNum();
                //循环除了第一行的所有行
                for(int rowNum = firstRowNum; rowNum <= lastRowNum; rowNum++){
                    //获得当前行
                    Row row = sheet.getRow(rowNum);
                    if(row == null){
                        continue;
                    }
                    //获得当前行开始列
                    int firstCellNum = row.getFirstCellNum();
                    //获得当前行的开始列
                    int lastCellNum = row.getPhysicalNumberOfCells();
                    String[] cells = new String[lastCellNum];
                    //循环当前行
                    for(int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++){
                        Cell cell = row.getCell(cellNum);
                        cells[cellNum] = getCellValue(cell);
                    }
                    list.add(cells);
                }
            }
            workbook.close();
        }
        return list;
    }

    /**
     * 获取工作簿对象
     * @param file
     * @return
     */
    public Workbook getWorkbook(MultipartFile file){
        String fileName = file.getOriginalFilename();
        //创建Workbook 工作簿对象，表示整个excel
        Workbook workbook = null;
        try {
            //获得excel文件的io流
            InputStream is = file.getInputStream();
            //根据文件后缀名不同（xls和xlsx）获得不停的Workbook实现类对象
            if(fileName.endsWith("xls")){
                //2003
                workbook = new HSSFWorkbook(is);
            }else if(fileName.endsWith("xlsx")){
                //2007
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e){
            logger.error(e.getMessage());
        }
        return workbook;
    }

    /**
     *  检查文件方法
     * @param file
     * @throws MyException
     */
    public void checkFile(MultipartFile file) throws MyException{
        //判断文件是否存在
        if(file == null){
            logger.error("文件不存在");
            throw new MyException("文件不存在");
        }
        //获取文件名
        String fileName = file.getOriginalFilename();
        //判断是否是excel文件
        if(!fileName.endsWith("xls") && !fileName.endsWith("xlsx")){
            logger.error("不是excel文件");
            throw new MyException("不是excel文件");
        }
    }

    public String getCellValue(Cell cell){
        String cellValue = "";
        if (cell == null){
            return cellValue;
        }
        //将数字当成String来读，避免出现1读成1.0情况
        if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        //判断数据的类型
        switch (cell.getCellType()){
            case Cell.CELL_TYPE_NUMERIC:
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING:
                cellValue = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BLANK:
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR:
                cellValue = "非法字符";
                break;
             default:
                 cellValue = "未知类型";
                 break;
        }
        return cellValue;
    }
}











