package Assignments;

import java.util.HashMap;
import java.util.Map;

public class GetDuplicates {

    public static void main(String[] args) {
        String s = "selenium";
        char[] c = s.toCharArray();

        Map map = new HashMap();

        for(char a:c){
            if(map.containsKey(a)){
                 map.put(map.getOrDefault(a,0), 1);
            } else{
                map.put(a,1);
            }
        }

        System.out.println(map);
    }
}
