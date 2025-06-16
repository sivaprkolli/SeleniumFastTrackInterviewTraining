package ReadDataFromExcel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.*;

public class ReadData {

    @Test
    public void getData() throws IOException {
        File file = new File(System.getProperty("user.dir")+"/testData/Goals.xlsx");

        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        String cellValue = sheet.getRow(1).getCell(2).toString();
        System.out.println("cellValue :: "  + cellValue);
    }

    @Test
    public void writeData() throws IOException {
        String filePath = System.getProperty("user.dir") + "/testData/Goals.xlsx";
        String sheetName = "Sheet1";
        int rowNumber = 1; // The row number to write data into (starting from 0)

        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheet(sheetName);


            Row row = sheet.getRow(rowNumber);
            if (row == null) {
                row = sheet.createRow(rowNumber);
            }

            Cell cell = row.createCell(0); // Create a new cell in the first column
            cell.setCellValue("Hello, World!"); // Set the cell value

            // Save the changes back to the Excel file
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            workbook.write(fileOutputStream);
            fileOutputStream.close();

            System.out.println("Data written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void getData1(){
        readUserData("ITEM_CD","DIET","Request");
    }

    public static String readUserData(String sheetName, String rowCell, String columnCell) {
        File file = new File("C:\\Users\\Siva\\Desktop\\SpecialRequest.xlsx");
        XSSFWorkbook xssfWorkbook = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            xssfWorkbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheetName);

        int rowNumber = 0, colNumber = 0;

        /**
         * Iteration of all rows in the sheet
         */

        for (Row row : xssfSheet) {
            Cell cell = row.getCell(3); // first cell in the row
            if (cell != null
                    && cell.getCellType() == CellType.STRING
                    && cell.getStringCellValue().equals(rowCell)) {
                rowNumber = row.getRowNum();
                System.out.println(rowNumber);
            }
        }

        /**
         * Iteration of cells on header row
         */
        Row headerRow = xssfSheet.getRow(0); // first cell in the header row
        for (Cell cell : headerRow) {
            if (cell != null
                    && cell.getCellType() == CellType.STRING
                    && cell.getStringCellValue().equals(columnCell)) {
                colNumber = cell.getColumnIndex();
                System.out.println(colNumber);
            }

        }

        Cell cellValue = xssfSheet.getRow(rowNumber).getCell(colNumber);
        System.out.println(cellValue);
        String actualCellValue = cellValue.toString();
        return actualCellValue;
    }
}
