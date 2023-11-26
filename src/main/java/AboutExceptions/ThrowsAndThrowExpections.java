package AboutExceptions;

public class ThrowsAndThrowExpections {
    public static void main(String[] args) {
        try {
            waitForElement();
        }catch (Exception e){

        }
    }

    public static void waitForElement() throws InterruptedException {

            int a = 10, b;

        Thread.sleep(5000);
            b = a / 1;

            try {
                Thread.sleep(5000);
                throw new ArithmeticException("Test ArithmeticException");
            }catch (Exception e){

            }
        System.out.println("Test");

    }
}
