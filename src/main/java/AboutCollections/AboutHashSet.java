package AboutCollections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AboutHashSet {
    public static void main(String[] args) {
        Set set = new HashSet();

        HashSet arrayList = new HashSet();
        arrayList.add("Selenium");
        arrayList.add(4.0);
        arrayList.add("WebDriverIO");
        arrayList.add('W');
        arrayList.add("Gatling");
        arrayList.add("Gatling");
        arrayList.add("Pynt");

        System.out.println(arrayList);

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
