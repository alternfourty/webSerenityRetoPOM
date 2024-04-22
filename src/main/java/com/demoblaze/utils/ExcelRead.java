package com.demoblaze.utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExcelRead {
    public static ArrayList<Map<String,String>> readExcel(String excelFilePath, String excelSheet) throws IOException {
        ArrayList<Map<String,String>> dataArray = new ArrayList<>();
        FileInputStream file = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(excelSheet);
        HashMap<String, String> map = new HashMap<>();
        String userKey = null;
        String passwordKey = null;

        for (int r = 0; r == 0; r++) {
            userKey = sheet.getRow(r).getCell(0).getStringCellValue();
            passwordKey = sheet.getRow(r).getCell(1).getStringCellValue();
        }

        for (int r = 0; r <= sheet.getLastRowNum(); r++) {
            //Register on the hashmap only the last row, Excel should only have 1 user password pair
            String userValue =  sheet.getRow(r).getCell(0).getStringCellValue();
            map.put(userKey,userValue);
            String passwordValue = sheet.getRow(r).getCell(1).getStringCellValue();
            map.put(passwordKey, passwordValue);
        }

        dataArray.add(map);

        return dataArray;
    }
}
