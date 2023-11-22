package Polymorphism;

public class TestClassC extends TestClassB{

    public static void main(String[] args) {
        TestClassC testClassc = new TestClassC();
        TestClassA testClassA = new TestClassC();

        new TestClassC().testA();
        testClassc.testA();
        testClassc.testB();
    }
}
