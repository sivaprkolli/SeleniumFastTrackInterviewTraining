package Encapsulation;

public class TestClassA {
    private int id;
    private String name;

    protected void setId(int id){
        this.id = id;
    }

    protected int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static class TestClassV{

    }
}
