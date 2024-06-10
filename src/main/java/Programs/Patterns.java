package Programs;

import org.testng.annotations.Test;

public class Patterns {

    @Test
    public void numberTrianglePattern(){

        int i, j;
        for(i=1; i<=10; i++){

            for(j=1; j<=10-i; j++){
                System.out.println(" ");
            }

            for( j=1; j<=i; j++ ){
                System.out.println( i + " ");
            }
            System.out.println();
        }
    }
}
