package com.extra.first.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Excel工具类
 * Created by Kee on 2016/10/31.
 */
public class ExcelUtil {

   public static HSSFWorkbook createExcel(String sheetName, String[] titles, String[] keys, List<Map<String,Object>> data) throws IOException{
      HSSFWorkbook workbook = new HSSFWorkbook();
      HSSFSheet sheet = workbook.createSheet(sheetName);

      HSSFCellStyle cs1 = workbook.createCellStyle();
      HSSFFont f1 = workbook.createFont();
      f1.setFontHeightInPoints((short)10);
      f1.setColor(IndexedColors.BLACK.getIndex());
      f1.setBoldweight(Font.BOLDWEIGHT_BOLD);

      cs1.setFont(f1);
      cs1.setFillForegroundColor(HSSFColor.YELLOW.index);
      cs1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
      cs1.setBorderBottom(HSSFCellStyle.BORDER_THIN);
      cs1.setBorderLeft(HSSFCellStyle.BORDER_THIN);
      cs1.setBorderRight(HSSFCellStyle.BORDER_THIN);
      cs1.setBorderTop(HSSFCellStyle.BORDER_THIN);
      cs1.setAlignment(HSSFCellStyle.ALIGN_CENTER);

      HSSFCellStyle cs2 = workbook.createCellStyle();
      HSSFFont f2 = workbook.createFont();
      f2.setFontHeightInPoints((short)10);
      f2.setColor(IndexedColors.BLACK.getIndex());

      cs2.setFont(f2);
      cs2.setFillForegroundColor(HSSFColor.WHITE.index);
      cs2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
      cs2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
      cs2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
      cs2.setBorderRight(HSSFCellStyle.BORDER_THIN);
      cs2.setBorderTop(HSSFCellStyle.BORDER_THIN);
      cs2.setAlignment(HSSFCellStyle.ALIGN_CENTER);

      //创建第一行
      HSSFRow row = sheet.createRow((short)0);
      //设置列名
      for (int i=0;i< titles.length;i++){
         HSSFCell cell = row.createCell(i);
         cell.setCellValue(titles[i]);
         cell.setCellStyle(cs1);
      }

      //设置每行每列的值
      for ( int i = 1;i<data.size();i++){
         HSSFRow row1 = sheet.createRow((short)i);
         for ( int j = 0;j<keys.length;j++){
            HSSFCell cell = row1.createCell(j);
            cell.setCellValue(data.get(i-1).get(keys[j]) == null ? "":data.get(i-1).get(keys[j]).toString());
            cell.setCellStyle(cs2);
         }
      }
      return workbook;
   }

   public static List<List<String>> readExcel(String filePath) {
      List<List<String>> dataLst = new ArrayList<List<String>>();
      InputStream is = null;
      try {
         /** 验证文件是否合法 */
         if (!validateExcel(filePath)) {
            return null;
         }
         /** 判断文件的类型，是2003还是2007 */
         boolean isExcel2003 = true;
         if (WDWUtil.isExcel2007(filePath)) {
            isExcel2003 = false;
         }
         /** 调用本类提供的根据流读取的方法 */
         File file = new File(filePath);
         is = new FileInputStream(file);
         dataLst = read(is, isExcel2003);
         is.close();
      } catch (Exception ex) {
         ex.printStackTrace();
      } finally {
         if (is != null) {
            try {
               is.close();
            } catch (IOException e) {
               is = null;
               e.printStackTrace();
            }
         }
      }
      /** 返回最后读取的结果 */
      return dataLst;
   }

   private static List<List<String>> read(InputStream inputStream, boolean isExcel2003) {
      List<List<String>> dataLst = null;
      try {
         /** 根据版本选择创建Workbook的方式 */
         Workbook wb = null;
         if (isExcel2003) {
            wb = new HSSFWorkbook(inputStream);
         } else {
            wb = new XSSFWorkbook(inputStream);
         }
         dataLst = read(wb);
      } catch (IOException e) {
         e.printStackTrace();
      }
      return dataLst;
   }

   private static List<List<String>> read(Workbook wb) {
      List<List<String>> dataLst = new ArrayList<List<String>>();
      /** 得到第一个shell */
      Sheet sheet = wb.getSheetAt(0);
      /** 得到Excel的行数 */
       int totalRows = sheet.getPhysicalNumberOfRows();
      /** 得到Excel的列数 */
      int totalCells = 0;
      if (totalRows >= 1 && sheet.getRow(0) != null) {
         totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
      }
      /** 循环Excel的行 */
      for (int r = 0; r < totalRows; r++) {
         Row row = sheet.getRow(r);
         if (row == null) {
            continue;
         }
         List<String> rowLst = new ArrayList<String>();
         /** 循环Excel的列 */
         for (int c = 0; c < totalCells; c++) {
            Cell cell = row.getCell(c);
            String cellValue = "";
            if (null != cell) {
               // 以下是判断数据的类型
               switch (cell.getCellType()) {
                  case HSSFCell.CELL_TYPE_NUMERIC: // 数字
                     cellValue = cell.getNumericCellValue() + "";
                     break;
                  case HSSFCell.CELL_TYPE_STRING: // 字符串
                     cellValue = cell.getStringCellValue();
                     break;
                  case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                     cellValue = cell.getBooleanCellValue() + "";
                     break;
                  case HSSFCell.CELL_TYPE_FORMULA: // 公式
                     cellValue = cell.getCellFormula() + "";
                     break;
                  case HSSFCell.CELL_TYPE_BLANK: // 空值
                     cellValue = "";
                     break;
                  case HSSFCell.CELL_TYPE_ERROR: // 故障
                     cellValue = "非法字符";
                     break;
                  default:
                     cellValue = "未知类型";
                     break;
               }
            }
            rowLst.add(cellValue);
         }
         /** 保存第r行的第c列 */
         dataLst.add(rowLst);
      }
      return dataLst;
   }

   private static boolean validateExcel(String filePath) {
      /** 检查文件名是否为空或者是否是Excel格式的文件 */
      if (filePath == null || !(WDWUtil.isExcel2003(filePath) || WDWUtil.isExcel2007(filePath))) {
         return false;
      }
      /** 检查文件是否存在 */
      File file = new File(filePath);
      if (file == null || !file.exists()) {
         return false;
      }
      return true;
   }
   public static void main(String[] args){
      List<List<String>> list =  ExcelUtil.readExcel("D:\\20161228众泰大迈经销商通讯录.xlsx");
      if (list != null) {
         for (int i = 0; i < list.size(); i++) {
            System.out.print("第" + (i) + "行");
            List<String> cellList = list.get(i);
            for (int j = 0; j < cellList.size(); j++) {
               System.out.print("    " + cellList.get(j));
            }
            System.out.println();
         }
      }
   }
}

class WDWUtil {
   public static boolean isExcel2003(String filePath) {
      return filePath.matches("^.+\\.(?i)(xls)$");
   }
   public static boolean isExcel2007(String filePath) {
      return filePath.matches("^.+\\.(?i)(xlsx)$");
   }
}
