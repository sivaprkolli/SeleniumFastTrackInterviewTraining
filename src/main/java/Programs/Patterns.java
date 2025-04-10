package Programs;

import org.testng.annotations.Test;

public class Patterns {

    @Test
    public void numberTrianglePattern(){

        int i, j;
        for(i=1; i<=10; i++){

            for(j=1; j<=10-i; j++){
                System.out.print(" ");
            }

            for( j=1; j<=i; j++ ){
                System.out.print( i + " ");
            }
            System.out.println();
        }
    }


    @Test
    public void rightTrianglePattern(){

        int i, j;
        for(i=1; i<=10; i++){

            for( j=1; j<=i; j++ ){
                System.out.print( i + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void leftTrianglePattern(){

        int i, j;
        for(i=1; i<=10; i++){

            for(j=10; j<=1; j--){   // todo
                System.out.print(" ");
            }

            for( j=1; j<=i; j++ ){
                System.out.print( i + " ");
            }
            System.out.println();
        }
    }
}
