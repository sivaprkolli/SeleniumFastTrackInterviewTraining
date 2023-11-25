package AboutExceptions;

public class TestExceptions {
    public static void main(String[] args) {
        try{
            int a = 10,b;
            b = 10/0;
        }catch (ArithmeticException ae) {
            ae.printStackTrace();
        }
        System.out.println("Arithmetic Exception");

        try{
            int a[] = {1,2,3,4,5};
            System.out.println(a[7]);
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }

        System.out.println("ArrayIndexOut Of Bounds Exception");
    }
}
