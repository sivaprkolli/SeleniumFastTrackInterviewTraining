package Inheritance;

public class TestClassB extends TestClassA{

    public static void main(String[] args) {
        TestClassB testClassB = new TestClassB();
        System.out.println("id from classA ::: " + testClassB.id );
        System.out.println("name from classA ::: " + testClassB.name );
        System.out.println("company :: " + TestClassA.company);
        testClassB.login();

        TestClassA.verifyUserNamePresent();
    }
}
