package AboutStrings;

import java.util.Arrays;

public class StringsUnderstanding {

    public static void main(String[] args) {
        String s = "Selenium";
        String s2 = s.concat(" Automation");
        System.out.println("S2 value :: " + s2);
        String s1 = new String("Selenium");

        System.out.println("s & s1 equals :: " + (s.equals(s1))); //true
        System.out.println(s == s1.intern()); // true
        System.out.println("s & s1 == :: " + (s == s1)); // false

        System.out.println(s2.contains("Auto"));
        System.out.println(s2.startsWith("Selenium"));
        System.out.println(s2.endsWith("Automation"));
        //System.out.println(StringUtils.normalizeSpace());
        // $22.09 , $25.08
        String s3 = "$22.09";
        String s4 = "$25.08";
        System.out.println((s3.replace("$","")));

        String s5[] = s2.split(" ");
        System.out.println(s5[0]);

        String s7 = "abcd1234xyz789ABC";

        String s8 = s7.replaceAll("[^\\d.]", "");
        System.out.println("s8 :: " + s8);

        String s9 = "abcd1234xyz789ABC";
        System.out.println(s9.replaceAll("\\d",""));



    }

}
