package Polymorphism;

public class TestClassB extends TestClassA{


    public static void main(String[] args) {
        TestClassB testClassB = new TestClassB();
        testClassB.testA();

        TestClassA testClassA = new TestClassB();
        testClassA.testA();

        testClassB.sum(4,4);
    }


    //@Override
    public int sum(int a, int b, int c){
         return 5;
    }

    @Override
    public void testA(){
        System.out.println("TestA");
        System.out.println("TestB");
    }

    public void testC(){

    }

}
