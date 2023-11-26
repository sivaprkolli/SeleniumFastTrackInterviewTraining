package AboutCollections;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AboutArrayList {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Selenium");
        arrayList.add(4.0);
        arrayList.add("WebDriverIO");
        arrayList.add('W');
        arrayList.add("Gatling");
        arrayList.add("Gatling");
        arrayList.add("Pynt");

        System.out.println(arrayList);

        List test = new ArrayList();

        ArrayList<String> arrayLista = new ArrayList<String>();
        arrayLista.add("Selenium");
        arrayLista.add("Appium");
        arrayLista.add("WebDriverIO");
        arrayLista.add("RestAssured");
        arrayLista.add("Gatling");
        arrayLista.add("Pynt");

       // System.out.println(arrayLista);

        Iterator iterator = arrayLista.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println(arrayLista.get(5));

        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }
    }
}
