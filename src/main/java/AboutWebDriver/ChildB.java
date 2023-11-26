package AboutWebDriver;

public class ChildB extends ParentA{

    public static void main(String[] args) {
        ChildB childB = new ChildB();
        ParentA parentA = new ParentA();
        childB.testB();
        parentA.testA();

        ParentA parentA1 = new ChildB();
        parentA1.testA();
        childB.testA();
    }

    @Override
    public void testA(){
        System.out.println("TestA Executing");
    }

    public void testB(){
        System.out.println("TestB Executing");
    }
}
