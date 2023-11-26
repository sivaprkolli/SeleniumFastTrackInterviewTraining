package CustomExceptions;

public class AAAException extends Exception{

    public AAAException(String text){
        System.out.println("AAA - Automate Any Application" + text);
    }

}
