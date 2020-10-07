package helperMethods;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import config.defineConstants;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;
    private static XSSFCellStyle style;
    private static Object CellStyle;
    dataGenerator produce = new dataGenerator();

    public static String getCellData(int RowNum, int ColNum, String sheetName) throws Exception {
        defineConstants Constant = new defineConstants();
        File src = new File(Constant.Path_TestData);

        FileInputStream fis = new FileInputStream(src);
        String CellData = null;

        XSSFCell cell;
        @SuppressWarnings("resource")
        XSSFWorkbook wb = new XSSFWorkbook(fis);

        XSSFSheet sh1 = wb.getSheet(sheetName);
        try {
            cell = sh1.getRow(RowNum).getCell(ColNum);
            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                CellData = cell.getStringCellValue();
                return CellData;
            } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                int i = (int) cell.getNumericCellValue();
                return String.valueOf(i);

            } else {
                CellData = cell.getRawValue();
            }
            return CellData;
            // System.out.println(CellData);
        } catch (Exception e) {
            return "";
        }
    }

    public static void Write(int num, int col, String actual, String path, String sheetName) throws Exception {
        defineConstants Constant = new defineConstants();
        File src = new File(path);
        FileInputStream fis = new FileInputStream(src);

        // load the workbook
        HSSFRow row = null;
        HSSFCell cell;

        @SuppressWarnings("resource")
        HSSFWorkbook wb = new HSSFWorkbook (fis);

        HSSFSheet sh1 = wb.getSheet(sheetName);
        // int num = 1;
        row = sh1.getRow(num);
        cell = row.createCell(col);
        cell.setCellValue(actual);
       /* cell = row.createCell(3);
        cell.setCellValue(status);*/
        FileOutputStream fout = new FileOutputStream(path);
        wb.write(fout);
        // fout.close();
    }

    public List<Object> readCsvFile(String path) throws Exception {
        List<Object> value = new ArrayList<Object>();
        int i = 0;
        try {
            FileReader filereader = new FileReader(path);
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                for (Object cell : nextRecord) {
                    value.add(cell);
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }


    public static String getCourseCellData(int RowNum, int ColNum, String sheetName, String path) throws Exception {
        defineConstants Constant = new defineConstants();
        File src = new File(path);

        FileInputStream fis = new FileInputStream(src);
        String CellData = null;

        XSSFCell cell;
        @SuppressWarnings("resource")
        XSSFWorkbook wb = new XSSFWorkbook(fis);

        XSSFSheet sh1 = wb.getSheet(sheetName);
        try {

            cell = sh1.getRow(RowNum).getCell(ColNum);
            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                CellData = cell.getStringCellValue();
                return CellData;
            } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                int i = (int) cell.getNumericCellValue();
                return String.valueOf(i);
            } else {
                CellData = cell.getRawValue();
            }
            return CellData;
            // System.out.println(CellData);
        } catch (Exception e) {
            return "";
        }
    }

    public String csvDataWriteLearner(String path) throws Exception {
        // first create file object for file placed at location
        // specified by filepath
        File file = new File(path);
        String mailID = produce.generateEmailAddress();
        String fName = produce.generateName();
        String lName = produce.generateName();
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // adding header to csv
            String[] header = {"*Email Address","*First Name","*Last Name","*Branch","Phone Number","Country","State","City","Line Manager","Instructor Rights(0 => No,1 => Yes)"};
            writer.writeNext(header);

            // add data to csv
            String branch = "Default";
            String[] data1 = {mailID, fName, lName, branch,"","","","","",""};
            writer.writeNext(data1);

            // closing writer connection
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mailID;
    }

    public String csvDataWriteLineManage(String path) throws Exception {
        // first create file object for file placed at location
        // specified by filepath
        File file = new File(path);
        String mailID = produce.generateEmailAddress();
        String fName = produce.generateName();
        String lName = produce.generateName();
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // adding header to csv
            String[] header = {"*Email Address","*First Name","*Last Name","*Branch","Phone Number","Country","State","City","Instructor Rights(0 => No,1 => Yes)"};
            writer.writeNext(header);

            // add data to csv
            String branch = "Default";
            String[] data1 = {mailID, fName, lName, branch,"","","","",""};
            writer.writeNext(data1);
            // closing writer connection
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mailID;
    }

    public static File lastFileModified(String dir) {
        File fl = new File(dir);
        File[] files = fl.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isFile();
            }
        });
        long lastMod = Long.MIN_VALUE;
        File choice = null;
        for (File file : files) {
            if (file.lastModified() > lastMod) {
                choice = file;
                lastMod = file.lastModified();
            }
        }
        return choice;
    }
}

