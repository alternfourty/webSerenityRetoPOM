package com.demoblaze.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ExcelRead {
    public static ArrayList<Map<String,String>> readExcel(String excelFilePath, String excelSheet) throws IOException {
        ArrayList<Map<String,String>> dataArray = new ArrayList<>();
        FileInputStream file = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(excelSheet);
        HashMap<String, String> map = new HashMap<>();

        for (int r = 0; r <= sheet.getLastRowNum(); r++) {
            String key =  sheet.getRow(r).getCell(0).getStringCellValue();
            String value = sheet.getRow(r).getCell(1).getStringCellValue();
            map.put(key, value);
        }

        dataArray.add(map);

        return dataArray;
    }
}
