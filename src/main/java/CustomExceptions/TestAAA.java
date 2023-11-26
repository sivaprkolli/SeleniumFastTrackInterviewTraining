package CustomExceptions;

public class TestAAA extends AAAException{

    public TestAAA(String text) {
        super(text);
    }

    public static void myCustomException(){
        try{
            throw new AAAException(" :: No SuchElement exception");
        }catch (AAAException e){
        }
    }

    public static void main(String[] args) {
        System.out.println("Test Login");
        myCustomException();
        System.out.println("Test Payment");
    }
}
