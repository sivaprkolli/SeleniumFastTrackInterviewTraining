package ReadDataFromExcel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelDataReader {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\Siva\\Desktop\\KAFKA_DATA_Test.xlsx");
        Workbook workbook = new XSSFWorkbook(fis);

        Sheet sheet1 = workbook.getSheet("Communication_Info");
        Sheet sheet2 = workbook.getSheet("Reservations");

        String lookupKey = getDataKeyFromSheet1(sheet1, "PROFILE_ID");
        if (lookupKey != null) {
            readDataFromSheet2(sheet2, lookupKey);
        }

        workbook.close();
        fis.close();
    }

    public static String getDataKeyFromSheet1(Sheet sheet, String testCaseId) {
        for (Row row : sheet) {
            Cell idCell = row.getCell(0); // TestCaseID column
            if (idCell != null && idCell.getCellType() == CellType.STRING &&
                    idCell.getStringCellValue().equalsIgnoreCase(testCaseId.trim())) {

                return row.getCell(1).getStringCellValue(); // DataKey column
            }
        }
        return null;
    }

    public static void readDataFromSheet2(Sheet sheet, String dataKey) {
        for (Row row : sheet) {
            Cell keyCell = row.getCell(0); // DataKey column
            if (keyCell != null && keyCell.getCellType() == CellType.STRING &&
                    keyCell.getStringCellValue().equalsIgnoreCase(dataKey.trim())) {

                String username = row.getCell(1).getStringCellValue().trim();
                String role = row.getCell(2).getStringCellValue().trim();

                System.out.println("Username: " + username);
                System.out.println("Role: " + role);
                return;
            }
        }
        System.out.println("DataKey not found in Sheet2.");
    }
}
