package Polymorphism;

public class MethodOverloading {
    public static void main(String[] args) {
        MethodOverloading methodOverloading = new MethodOverloading();
        methodOverloading.login("test",12);
    }

    public String testA(int a){
        String test = "Selenium";
         return test;
    }

    public int testA(){
        int id = 10;
        return id;
    }

    public void login(String username, String password){

    }

    public void login(String username, int number){

    }

    public void login(String username){

    }

    public void login(int number){

    }

    public void login(String username, String password, int loginNumber){

    }

    public void register(String email, int phone, String name){

    }

    public void register(String email, int phone,String name, String firstName, String lastName){

    }

}
