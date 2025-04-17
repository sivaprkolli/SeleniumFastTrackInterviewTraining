package Programs;

import org.testng.annotations.Test;

public class SumOfDigits {

    @Test
    public void sumOfDigits(){
        int n = 1234;
        int rem =0;
        int total = 0;

        while (n!=0){
            rem = rem + n%10;
            n = n/10;

        }
        System.out.println(rem);
    }
}
