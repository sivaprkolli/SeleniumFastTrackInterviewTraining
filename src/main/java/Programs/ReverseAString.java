package Programs;

import org.testng.annotations.Test;

public class ReverseAString {

    @Test
    public void reverseAString(){
        String str = "selenium";

        for (int i=str.length()-1; i>=0; i--){
            System.out.print(str.charAt(i));
        }
    }
}
