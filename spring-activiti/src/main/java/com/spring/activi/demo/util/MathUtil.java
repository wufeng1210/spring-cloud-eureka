package com.spring.activi.demo.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author: wufeng
 * @date: 2018/6/28 8:43
 * @desrcption: 高级函数的计算
 */
public class MathUtil {

    public static void main(String[] args) {
        int a = 1;
        System.out.println(Math.abs(a));

        String expression = "(0*1--3)-5/-4-(3*(-2.13))";
        double result = Calculator.conversion(expression);
        System.out.println(expression + " = " + result);
        try {
            File file = new File("D:\\workspace\\excel.xlsx");
            FileInputStream inputStream = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(0);
            int totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
            for(int i=0; i<totalCells; i++){
                Cell cell = row.getCell(i);
                if(cell.getCellType() == Cell.CELL_TYPE_FORMULA){
                    System.out.println(cell.getNumericCellValue());
                }
            }
            inputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
