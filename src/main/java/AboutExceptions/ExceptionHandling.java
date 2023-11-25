package AboutExceptions;

import org.openqa.selenium.WebDriver;

public class ExceptionHandling {
    public static void main(String[] args) {
        WebDriver driver = null;
        try{
            driver.get("");
            int a[] = {1,2,3,4,5};
            System.out.println(a[7]);
        }catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("ArithmeticException");
        } catch (ArrayIndexOutOfBoundsException ae){
            ae.printStackTrace();
            System.out.println("ArrayIndexOutOfBoundsException");
        } catch (NullPointerException ne){
            System.out.println("NullPointerException");
        }
    }
}
