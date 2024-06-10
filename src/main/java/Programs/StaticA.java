package Programs;

public class StaticA {

    public void testA(){
        StaticB.automationTool = "Playwright";
        System.out.println(StaticB.automationTool);
    }

    public static void testB(){
        StaticB.automationTool = "Playwright";
        System.out.println(StaticB.automationTool);
    }

    public static void main(String[] args) {
        StaticA staticA = new StaticA();
        System.out.println(StaticB.automationTool);
       staticA.testA();
        System.out.println(StaticB.automationTool);
       testB();
        System.out.println(StaticB.automationTool);
    }
}
