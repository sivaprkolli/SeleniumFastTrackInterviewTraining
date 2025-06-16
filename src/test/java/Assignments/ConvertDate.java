package Assignments;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConvertDate {

    public static void main(String[] args) {
        String inputDate = "2025-05-22";
        LocalDate date = LocalDate.parse(inputDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        String formattedDate = date.format(formatter);
        System.out.println(formattedDate);

        String inputDate1 = "5/22/2025";
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

        LocalDate date1 = LocalDate.parse(inputDate1, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate1 = date1.format(outputFormatter);
        System.out.println(formattedDate1);  // Output: 2025-05-22
    }
}

