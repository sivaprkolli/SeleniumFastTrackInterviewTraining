package Assignments;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ConvertXMLToCSV {

    @Test
    public void convertTest() {
        File xmlFile = new File("test.xml");
        File excelFile = new File("path/testExcel.xlsx");

        try {
            // convertXmlToCsv(xmlFile, excelFile);
            System.out.println("Conversion successful.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   /* public static void convertXmlToCsv(File xmlFile, File csvFile) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ConvertXMLToCSV.class); // Replace YourXmlClass with your XML-annotated class
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ConvertXMLToCSV xmlObject = (ConvertXMLToCSV) jaxbUnmarshaller.unmarshal(xmlFile);

        try (Writer writer = new java.io.FileWriter(csvFile);
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {

            // Add CSV header if needed
            // csvPrinter.printRecord("Header1", "Header2", ...);

            // Process your XML object and write to CSV
            List<String> csvRecord = new ArrayList<>();
            // Populate csvRecord with data from xmlObject
            // csvRecord.add(xmlObject.getField1());
            // csvRecord.add(xmlObject.getField2());
            // ...

            csvPrinter.printRecord(csvRecord);
        }
    }
*/
}