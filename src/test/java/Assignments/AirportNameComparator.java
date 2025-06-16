package Assignments;

import java.util.regex.Pattern;

public class AirportNameComparator {
    public static String normalizeAirportName(String name) {
        String normalized = name.replaceAll("[,/-]+", " ");
        normalized = normalized.replaceAll("\\s+", " ").trim();
        return normalized.toLowerCase();
    }

    public static void assertAirportNameEquals(String expected, String actual) {
        String normalizedExpected = normalizeAirportName(expected);
        String normalizedActual = normalizeAirportName(actual);

        if (!normalizedExpected.equals(normalizedActual)) {
            throw new AssertionError(
                    String.format("Expected: %s (%s)%nActual: %s (%s)",
                            expected, normalizedExpected,
                            actual, normalizedActual)
            );
        }
    }

    // Example usage
    public static void main(String[] args) {

        System.out.println(normalizeAirportName("Hartsfield - Jackson Atlanta International Airport"));
        System.out.println(normalizeAirportName("Savannah/hilton Head International Airport"));
        System.out.println(normalizeAirportName("Oslo Airport, Gardermoen"));
//        String expected1 = "Savannah Hilton Head International Airport";
//        String actual1 = "Savannah/hilton Head International Airport";
//        assertAirportNameEquals(expected1, actual1);
//
//        String expected2 = "Hartsfield Jackson Atlanta International Airport";
//        String actual2 = "Hartsfield - Jackson Atlanta International Airport";
//        assertAirportNameEquals(expected2, actual2);
    }
}