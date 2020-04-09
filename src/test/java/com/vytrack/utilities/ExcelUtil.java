package com.vytrack.utilities;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil {
    private Sheet workSheet;
    private Workbook workbook;
    private String path;


    public ExcelUtil(String path, String sheetName){
        this.path = path;
        try {
            FileInputStream ExelFile = new FileInputStream(path);

            workbook = WorkbookFactory.create(ExelFile);
            workSheet = workbook.getSheet(sheetName);
            Assert.assertNotNull( "Invalid sheet name",workSheet);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public ExcelUtil(String sheetName){
        this.path = ConfigurationsReader.getProperty("users_test_data");
        try {
            FileInputStream ExelFile = new FileInputStream(path);

            workbook = WorkbookFactory.create(ExelFile);
            workSheet = workbook.getSheet(sheetName);
            Assert.assertNotNull("Invalid sheet name", workSheet);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


    public String getCellData(int rowNum, int colNum){
        Cell cell;
        cell = workSheet.getRow(rowNum).getCell(colNum);

        String cellDAta = cell.toString();
        return cellDAta;
    }


    public String[][] getDAtaArrayDataProvider(){
            String[][] data = new  String[rowCount()][columnCount()];
        for(int i=1; i<rowCount(); i++){
            for(int j=0; j<columnCount(); j++){
                String value = getCellData(i, j);
                data[i-1][j] = value;

            }
        }
        return data;
    }

    public String[][] getDAtaArray(){
        String[][] data = new  String[rowCount()][columnCount()];
        for(int i=0; i<rowCount(); i++){
            for(int j=0; j<columnCount(); j++){
                String value = getCellData(i, j);
                data[i][j] = value;

            }
        }
        return data;
    }

    public List<Map<String, String>> getDataList(){
        List<String> columns = getColumnsNames();
        List<Map<String, String>> data = new ArrayList<>();

        for(int i=1; i< rowCount(); i++){

            Row row = workSheet.getRow(i);
            Map<String, String> rowMap = new HashMap<>();
            for(Cell cell : row){
                int columnIndex = cell.getColumnIndex();
                rowMap.put(columns.get(columnIndex), cell.toString());
            }
            data.add(rowMap);
        }
        return data;
    }


    public List<String> getColumnsNames (){

        List<String> columns = new ArrayList<>();

        for(Cell cell : workSheet.getRow(0)){
            columns.add(cell.toString());
        }
        return columns;
    }


    public void setCellDAta(String value, int rowNum, int colNum){

        Cell cell;
        Row row;
        try {
            row = workSheet.getRow(rowNum);
            cell = row.getCell(colNum);

         if(cell==null){
             cell=row.createCell(colNum);
             cell.setCellValue(value);
         }else{
            cell.setCellValue(value);
         }


            FileOutputStream fileOutputStream = new FileOutputStream(path);

         workbook.write(fileOutputStream);
         fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCellData(String value, String columnName, int row){
        int column = getColumnsNames().indexOf(columnName);
        setCellDAta(value, row, column);
    }




    public int columnCount(){

        return workSheet.getRow(0).getLastCellNum();
    }


    public int rowCount(){

        return workSheet.getLastRowNum()+1;
    }

    public static void main(String[] args) {
        ExcelUtil ex = new ExcelUtil("vytrack_testusers.xlsx", "QA3-short");
        System.out.println(ex.workSheet.getLastRowNum());
    }

}
