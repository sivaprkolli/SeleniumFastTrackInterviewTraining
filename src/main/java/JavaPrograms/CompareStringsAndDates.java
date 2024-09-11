package JavaPrograms;

import java.util.ArrayList;
import java.util.List;

public class CompareStringsAndDates {
    public static void main(String[] args) {
       String str = "1990/10/08";
        System.out.println(str.matches("\\d{4}/\\d{2}/\\d{2}"));

        String s = "@#$%^&*34567890trdtfgahvbjnkjlljhgfdgDGAFSGDHJKFLSDHG";

        String name = "Siva Prasad";
        String[] fullName = name.split(" ");
        System.out.println(fullName.length == 2);

        System.out.println(s.replaceAll("[^0-9]", ""));
        System.out.println(s.replaceAll("[^a-z]", ""));
        System.out.println(s.replaceAll("[^A-Z]", ""));
        System.out.println(s.replaceAll("[^a-zA-Z]", ""));
        System.out.println(s.replaceAll("[0-9a-zA-Z]", ""));

        List al = new ArrayList<>();

        al.add(10);
        al.add(20);
        al.add("Appium");
        al.add(1);
        al.add("Selenium");

        System.out.println(al);
        al.remove("Appium");
       // al.remove(1);
        System.out.println(al);
    }
}
