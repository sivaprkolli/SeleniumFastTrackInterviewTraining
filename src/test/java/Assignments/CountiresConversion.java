package Assignments;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class CountiresConversion {

    public static void main(String[] args) {
        System.out.println(getCountryAlpha3Code("United States"));

        System.out.println(getCountryName("US"));
    }
    //b43231fe13ea81c166cd5426de96a090

    public static String getCountryName(String countryCode) {
        Locale locale = new Locale("", countryCode);
        return locale.getDisplayCountry(Locale.ENGLISH);
    }
    public static String getCountryAlpha3Code(String countryName) {
        for (String iso : Locale.getISOCountries()) {
            Locale locale = new Locale("", iso);
            if (locale.getDisplayCountry().equalsIgnoreCase(countryName)) {
                if (locale.getDisplayCountry().equals("US")){

                }
                try {
                    return locale.getCountry();
                } catch (MissingResourceException e) {
                    return null; // If 3-letter code is missing for some reason
                }
            }
        }
        return null; // Not found
    }

    // Clean the list to remove both actual null and "null" strings
    private List<String> cleanList(List<String> list) {
        return list.stream()
                .filter(item -> item != null && !"null".equals(item)) // Removes both actual null and "null" string
                .collect(Collectors.toList());
    }

    public static String getLanguageCode(String languageName) {
        for (Locale locale : Locale.getAvailableLocales()) {
            if (locale.getDisplayLanguage(Locale.ENGLISH).equalsIgnoreCase(languageName)) {
                return locale.getLanguage();
            }
        }
        return null; // Not found
    }

    @Test
    public void compareLists() {
        List<String> actualList = new ArrayList<>(Arrays.asList("Apple", "null", null, "Banana", "Cherry", "null"));
        List<String> expectedList = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry", "null", null));

        // Clean both lists by removing "null" strings and actual nulls
        Assert.assertEquals(cleanList(actualList), cleanList(expectedList), "Lists do not match after removing 'null' values and null references!");

        Locale englishLocale = new Locale("EN");
        System.out.println("Language code: " + getLanguageCode("ENGLISH").toUpperCase());
    }

}