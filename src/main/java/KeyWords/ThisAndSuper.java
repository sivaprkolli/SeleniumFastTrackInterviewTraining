package KeyWords;

public class ThisAndSuper {
    public int a = 10;
    public int b = 20;
    public int c = 30;
    public String s = "Hyderabad";

  /*  public ThisAndSuper(){

    }*/

    public ThisAndSuper(int b, int c){
            b = this.b;
            c = this.c;
        System.out.println("b + c :: " + (b+c));
    }

    public static void main(String[] args) {
        ThisAndSuper thisAndSuper = new ThisAndSuper(2,3);
      //  int b = thisAndSuper.a;
        //thisAndSuper.testA(15);
    }

    public void testA(int aa){
        aa = this.a;
       System.out.println("aa :: " + aa);
       int c = this.testB();
        System.out.println("c :: " + c);
    }

    public int testB(){
        return 5;
    }
}
