package Abstraction;

public class TestClass extends TestAbstraction implements InterfaceTest,InterfaceTest1{


    @Override
    public void submitCardDetails() {
        System.out.println("Test Submit Card Data");
    }

    @Override
    public void payment(){
        System.out.println("Payment success");
    }

    @Override
    public void selectMovie() {

    }

    @Override
    public void selectSeats() {

    }

    @Override
    public void bookTicket() {

    }

    @Override
    public void watchMovie() {

    }
}
