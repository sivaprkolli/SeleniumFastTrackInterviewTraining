package KeyWords;

public class ChildStaticAndFinal extends StaticAndFinal{
    public static String WEB_AUTOMATION_TOOL;
    static {
        WEB_AUTOMATION_TOOL = "Selenium";
    }

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

        System.out.println(WEB_AUTOMATION_TOOL);
    }

    /*public final void testF(){
        System.out.println("Test Final");
    }*/

    public static void testS(){
        System.out.println("Test Static");
    }
}
