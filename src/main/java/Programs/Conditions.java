package Programs;

public class Conditions {

    public static void main(String[] args) {

        int age = 18;

        if(age>18){
            System.out.println("Eligible for vote");
        } else if (age < 18) {
            System.out.println("Not eligible for vote");
        } else {
            System.out.println("Apply for voter card");
        }

        String day = "Sunday";

        switch (day){
            case "Sunday":
                System.out.println("Monday is holiday");
                break;
            case "Tuesday":
                System.out.println("Tuesday is WFH");
                break;
            default:
                System.out.println("Goto office");
        }

        for(int i=0; i<5; i++){
            System.out.println(i);
        }

        for(int i=10; i>0; i--){
            System.out.println(i);
        }

        int a =1;

        while (a<5){
            a++;
            System.out.println("a :: " + a);
        }
        int b = 10;


        // avoid using in projects
        do{
            System.out.println("Test");
            b++;
        }while (b < 5);

    }
}
