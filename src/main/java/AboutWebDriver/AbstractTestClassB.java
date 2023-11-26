package AboutWebDriver;

public class AbstractTestClassB extends AbstractClassA implements InterfaceA{
    @Override
    public void testA() {
        System.out.println("TestA Execution .....");
    }

/*    public static void main(String[] args) {
        AbstractClassA abstractClassA = new AbstractTestClassB();
        abstractClassA.testA();

        InterfaceA interfaceA = new AbstractTestClassB();
        interfaceA.testI();
    }*/

    @Override
    public void testI() {
        System.out.println("TestI Execution .....");
    }
}
