package Constructor;

public class ClassA {


    public ClassA(){
        System.out.println("Default Constructor");
    }

    public ClassA(String s){
        System.out.println("name :: "+ s );
    }

    public ClassA(int a){
        System.out.println("number :: " + a);
    }




    public static void main(String[] args) {
        ClassA classA = new ClassA();
        ClassA classA1 = new ClassA("Siva");
        ClassA classA2 = new ClassA(5);


    }

}
