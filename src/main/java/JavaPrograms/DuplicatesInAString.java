package JavaPrograms;

import java.util.HashMap;
import java.util.Map;

public class DuplicatesInAString {
    public static void main(String[] args) {
        String s = "selenium";
        char c[] = s.toCharArray();
        // for first character
        for (int i=0; i<s.length(); i++){
            //remaining characters for comarision
            for (int j=i+1; j<s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    System.out.println(s.charAt(i));
                }
            }
        }

        Map<Character, Integer> map = new HashMap<>();

        for(char c1 : c){
            if(map.containsKey(c1)){
                map.put(c1, map.get(c1) + 1);
            } else{
                map.put(c1,1);
            }
        }

        System.out.println(map);
    }
}
