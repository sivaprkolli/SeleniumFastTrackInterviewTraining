package ReadDataFromExcel;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ReadDataFromOneSheetAndGetBasedOnThatKey {

    public static List<Map<String, String>> getNVSData(String sheetName, String... columnHeaders) throws IOException {
        List<Map<String, String>> result = new ArrayList<>();
        String filePath = "C:\\Users\\Siva\\Downloads\\KAFKA_DATA.xlsx";

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);
            Map<String, Integer> headerIndexMap = new HashMap<>();
            for (Cell cell : headerRow) {
                String keyValue = cell.getStringCellValue().replaceAll(" ", "");
                headerIndexMap.put(StringUtils.normalizeSpace(keyValue), cell.getColumnIndex());
            }

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                Map<String, String> rowData = new HashMap<>();
                for (String header : columnHeaders) {
                    int colIndex = headerIndexMap.get(header.trim());
                    Cell cell = row.getCell(colIndex);

                    String[] actualData = getCellValue(cell).split(":");
                    String name = actualData[1].replace("\"", "");
                    rowData.put(header, name);
                }
                result.add(rowData);
            }
        }
        System.out.println(result);
        return result;
    }

    private static String getCellValue(Cell cell) {
        if (cell == null) return "";
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> DateUtil.isCellDateFormatted(cell)
                    ? cell.getDateCellValue().toString()
                    : String.valueOf(cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            case FORMULA -> cell.getCellFormula();
            default -> "";
        };
    }

    private static Map<String, Integer> getHeaderIndexMap(Sheet sheet) {
        Map<String, Integer> map = new HashMap<>();
        Row header = sheet.getRow(0);
        for (Cell cell : header) {
            map.put(cell.getStringCellValue().trim(), cell.getColumnIndex());
        }
        return map;
    }

    public List<String> getColumnValues(Map<String, String> data, List<String> columnName) {
        List<String> values = new ArrayList<>();
        for (Map.Entry<String, String> row : data.entrySet()) {
            for (String test : columnName) {
                if (row.getKey().contains(test)) {
                    values.add(row.getValue());
                }
            }
        }
        return values;
    }


    @Test
    public void getData() throws IOException {
        List<String> list = getSpecialRequestData("Special Requests", "ITEM_CD", "RES_ID", "ITEM_CD", "Code");

        //  System.out.println(list.get(0));

       /* List<String> columnName = Arrays.asList("FIRST_NAME","LAST_NAME","MIDDLE_NAME","TITLE","GENDER",
                "PROFESSION","BIRTH_DATE","BIRTH_PLACE","NATIONALITY","LOYALTY_CARD_NUM","LOYALTY_CRUISE_POINTS","LOYALTY_TOTAL_POINTS",
                "EXTERNAL_CD","FAMILY_GROUP_CD","PRIMARY_LANGUAGE_CD","LOYALTY_CARD_TYPE","GOLDEN_ID");
        List<String> data = getColumnValues(list.get(0), columnName);

        getNVSData("Hotels", "RES_ID","DIRECTION");
       */// System.out.println(data);
    }
    public List<String> getSpecialRequestData(String sheet1, String sheet2, String sheet1_col1, String sheet1_col2, String sheet2_col1) throws IOException {
        List<Map<String, String>> result = new ArrayList<>();
        FileInputStream fis1 = new FileInputStream(new File("C:\\Users\\Siva\\Desktop\\KAFKA_DATA.xlsx"));
        Workbook workbook1 = new XSSFWorkbook(fis1);

        FileInputStream fis2 = new FileInputStream(new File("C:\\Users\\Siva\\Desktop\\SpecialRequest.xlsx"));
        Workbook workbook2 = new XSSFWorkbook(fis2);


        Sheet reservationSheet = workbook1.getSheet(sheet1);
        Sheet guestProfileSheet = workbook2.getSheet(sheet2);

        // Get column index maps
        Map<String, Integer> reservationHeader = getHeaderIndexMap(reservationSheet);
        Map<String, Integer> guestHeader = getHeaderIndexMap(guestProfileSheet);

        int resIdCol = reservationHeader.get(sheet1_col1);
        int profileIdCol = reservationHeader.get(sheet1_col2);
        int guestProfileIdCol = guestHeader.get(sheet2_col1);
        Set<String> list = guestHeader.keySet();
        List<String> list1 = new ArrayList<>(list);
        System.out.println(list1.get(guestProfileIdCol));

        List<String> spdata = new ArrayList<>();
        // Loop through each row in Reservation sheet to get ReservationId dynamically
        //for (int i = 1; i <= reservationSheet.getLastRowNum(); i++) {
        for (int i = 1; i <= 10; i++) {
            Row resRow = reservationSheet.getRow(i);
            if (resRow == null) continue;

            Cell resIdCell = resRow.getCell(resIdCol);
            Cell profileCell = resRow.getCell(profileIdCol);

            if (resIdCell == null || profileCell == null) continue;

            String reservationId = resIdCell.toString().trim();
           // String[] actualData1 = profileCell.toString().trim().split("-");
            String profileId = reservationId.replace("\"", "");
            //System.out.println(profileId);
            //profileId.replace("\"","")
            String data = ReadData.readUserData("ITEM_CD", profileId.trim(), list1.get(guestProfileIdCol).trim());
            spdata.add(data);
            System.out.println(spdata);
        }
             System.out.println("********************************************************");
        return spdata;
    }
}

