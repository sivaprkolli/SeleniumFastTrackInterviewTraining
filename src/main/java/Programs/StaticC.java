package Programs;

public class StaticC {

    int id;
    String name;
   static String org;


   public static void moreDetails(StaticC obj){
       System.out.println(
               "EmpId :: " + obj.id
                       + " EmpName :: " + obj.name
                       + " Company :: " + org
       );
   }
    public void details(){
        System.out.println(
                "EmpId :: " + id
                + " EmpName :: " + name
                + " Company :: " + org
        );
    }

    public static void main(String[] args) {
        StaticC c1 = new StaticC();
        c1.id = 1;
        c1.name = "Siva";
        org = "QZ";
        StaticC c2 = new StaticC();
        c2.id = 2;
        c2.name = "Prasad";
        org = "QZ";

        c1.details();
        c2.details();

        System.out.println("***************************************************888");
        moreDetails(c1);
    }
}
