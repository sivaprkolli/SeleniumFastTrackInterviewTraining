package Assignments;

import org.apache.commons.lang3.StringUtils;

public class AirportNameAssertion {

    public static String normalizeAirportName(String name) {
        if (name == null) {
            return "";
        }
        String normalized = name.toLowerCase()
                .replaceAll("[/,-]", " ")
                .replaceAll("\\s+", " ")
                .trim();

        normalized = normalized.replaceAll("\\bairport\\b", "").trim();
        if (!normalized.isEmpty()) {
            normalized = normalized + " airport";
        }

        return normalized;
    }

    public static void assertAirportNamesMatch(String expected, String actual) {
        String normalizedExpected = StringUtils.normalizeSpace(normalizeAirportName(expected));
        String normalizedActual = StringUtils.normalizeSpace(normalizeAirportName(actual));

        if (normalizedExpected.equals(normalizedActual)) {
            System.out.println("Assertion PASSED: '" + expected + "' matches '" + actual + "'");
        } else {
            throw new AssertionError(
                    "Airport names don't match after normalization:\n" +
                            "Expected: '" + expected + "' → '" + normalizedExpected + "'\n" +
                            "Actual:   '" + actual + "' → '" + normalizedActual + "'"
            );
        }
    }

    public static void main(String[] args) {
//        String name = normalizeAirportName("Keflavik International Airport");
//        System.out.println(name);
        // Test cases - all these should pass
        assertAirportNamesMatch("Oslo Gardermoen Airport", "Oslo Airport, Gardermoen");
        assertAirportNamesMatch("Keflavik International Airport",
                "Keflavík International Airport");
        assertAirportNamesMatch("Savannah Hilton Head International Airport",
                "Savannah/hilton Head International Airport");

        // This will fail
        try {
            assertAirportNamesMatch("New York JFK Airport", "Chicago O'Hare Airport");
        } catch (AssertionError e) {
            System.out.println("Expected failure:\n" + e.getMessage());
        }
    }
}