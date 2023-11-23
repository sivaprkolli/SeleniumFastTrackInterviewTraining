package KeyWords;

public class ThisAndSuperChild extends ThisAndSuper {

    public ThisAndSuperChild(int b, int c) {
        super(b, c);
    }

    public static void main(String[] args) {
        ThisAndSuperChild thisAndSuperChild = new ThisAndSuperChild(10, 15);
       // thisAndSuperChild.testC();
    }

    public void testC(){
        super.testB();
        int b = super.a;
        super.testA(12);

    }
}
