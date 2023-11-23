package KeyWords;

public class StaticAndFinal {

    public static String city = "Mumbai";
    public final String state = "MahaRastra";


    public static String name;
    public static int number;
    public final int id = 10;
    public static final int pincode = 123456;

    public static void main(String[] args) {
        StaticAndFinal staticAndFinal = new StaticAndFinal();

        System.out.println("City  :: " + city);
        System.out.println("State :: " + staticAndFinal.state);

        String updatedCity = city + "Financial City";

        String updatedState = staticAndFinal.state + "Biggest State";

        System.out.println("UpdatedCity  :: " + updatedCity);
        System.out.println("UpdatedState :: " + updatedState);

        city = "Hyderabad";
        //staticAndFinal.state = "AP";
        System.out.println("City  :: " + city);

        System.out.println("name :: " + name);
        System.out.println("number :: " + number);
    }

    public final void testF(){
        System.out.println("Test Final");
    }

    public static void testS(){
        System.out.println("Test Static");
    }

    public final void testF(String s){
        System.out.println("Test Final");
    }

    public static void testS(String s){
        System.out.println("Test Static");
    }
}
