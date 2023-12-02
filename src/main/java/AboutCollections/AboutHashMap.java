package AboutCollections;

import java.util.HashMap;
import java.util.Map;

public class AboutHashMap {

    public static void main(String[] args) {
        Map map = new HashMap();

        HashMap<String, Integer> hashMap = new HashMap();
        hashMap.put("Selenium", 4);
        hashMap.put("Appium", 2);
        hashMap.put("Gatling", 5);
        hashMap.put("WebDriverIO", 7);
        hashMap.put("WebDriverIO", 6);

        System.out.println(hashMap);


        HashMap<Integer, String> hashMap1 = new HashMap();
        hashMap1.put(1, "Selenium");
        hashMap1.put(1, "Appium");
        hashMap1.put(1, "WebDriverIO");


        System.out.println(hashMap1);
        System.out.println(hashMap1.get(1));
    }
}
