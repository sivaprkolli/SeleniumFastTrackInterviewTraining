package Programs;

import org.testng.annotations.Test;

public class ReverseANumber {

    @Test
    public void reverseNumber(){
        int number = 1234;
        int rev=0, remainder=0;

        while (number!=0){
            remainder = number%10;
            rev = rev *10 + remainder;
            number = number/10;
        }
        System.out.println(rev);
    }
}
