package JavaPrograms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesInAList {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 1, 2, 2, 3, 3, 3, 2,3);

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : values){
            if (map.containsKey(i)){
                map.put(i, map.get(i)  + 1);
            }else {
                map.put(i, 1);
            }
        }
        System.out.println(map);
    }
}
