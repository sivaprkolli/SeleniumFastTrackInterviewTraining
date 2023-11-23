package Encapsulation;

public class TestClassB {

    public static void main(String[] args) {
        TestClassA testClassA = new TestClassA();

        testClassA.setName("Venkat");
        testClassA.setId(5);

        System.out.println(testClassA.getId());
        System.out.println(testClassA.getName());
    }


}
