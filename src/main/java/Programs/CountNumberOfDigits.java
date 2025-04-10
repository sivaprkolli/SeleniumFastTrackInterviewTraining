package Programs;

import org.testng.annotations.Test;

public class CountNumberOfDigits {

    @Test
    public void getNumberOfDigits(){
        int n = 123456;
        int count = 0;

        while (n!=0){
            n = n /10;
            count ++;
        }
        System.out.println(count);
    }
}
