package Inheritance;

public class TestClassA {

    int id = 10;
    String name = "Selenium";
    static String company = "LeafStone";

    static  {
        System.out.println("Test Block");
    }


  /*  public static void main(String[] args) {
        // ClassName someClassRefName = new TestClassA();
        TestClassA testClassA = new TestClassA();
        testClassA.login();
        verifyUserNamePresent();
    }*/

    public void login(){
        System.out.println("Enter valid credentials");
    }

    public static void verifyUserNamePresent(){
        System.out.println("UserName should present");
    }


}
