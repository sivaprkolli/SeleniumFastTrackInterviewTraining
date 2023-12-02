package JavaPrograms;

public class GetNumericValues {
    public static void main(String[] args) {
        String s = "Appium@1234";

        String s1 = s.replaceAll("[^0-9]", "");
        String s2 = s.replaceAll("[^A-Z][^a-z]", "");
        System.out.println(s1);
        System.out.println(s2);
    }
}
