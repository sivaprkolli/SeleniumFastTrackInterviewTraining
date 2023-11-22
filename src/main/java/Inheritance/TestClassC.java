package Inheritance;

public class TestClassC {

    public static void main(String[] args) {
        TestClassA testClassA = new TestClassA();
        TestClassA testClassA1 = new TestClassB();
        testClassA.login();
        testClassA.verifyUserNamePresent();

        TestClassA.verifyUserNamePresent();
    }
}
