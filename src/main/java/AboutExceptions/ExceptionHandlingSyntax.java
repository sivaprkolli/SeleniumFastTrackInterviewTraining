package AboutExceptions;

import java.sql.SQLOutput;

public class ExceptionHandlingSyntax {

    public static void main(String[] args) {
        int a=10,b;
        try{

            b= a/0;

        }catch (ArithmeticException te){
            System.out.println("Exception handled");
            b = a/10;
            System.out.println(b);
        } finally {
            System.out.println("Compulsory Execution");
        }
    }
}
