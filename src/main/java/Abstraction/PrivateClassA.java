package Abstraction;

public class PrivateClassA {
    private int a=10;

    private void testA(){
        System.out.println("Login");
    }

    public static void main(String[] args) {
        PrivateClassA privateClassA = new PrivateClassA();

        System.out.println("a value :: " + privateClassA.a);
        privateClassA.testA();
    }
}
