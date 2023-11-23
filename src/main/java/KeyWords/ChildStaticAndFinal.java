package KeyWords;

public class ChildStaticAndFinal extends StaticAndFinal{
    public static void main(String[] args) {
        ChildStaticAndFinal childStaticAndFinal = new ChildStaticAndFinal();
        String s = childStaticAndFinal.state;
        int i = childStaticAndFinal.id;

        String s1 = city;
        int n = number;
        String n1 = name;
        int p = StaticAndFinal.pincode;

        testS();
        childStaticAndFinal.testF();
    }

    /*public final void testF(){
        System.out.println("Test Final");
    }*/

    public static void testS(){
        System.out.println("Test Static");
    }
}
