package AboutExceptions;

import org.openqa.selenium.WebDriver;

public class ParentChildExceptions {
    public static void main(String[] args) {
        WebDriver driver = null;
        try{
          //  driver.get("");
            int a[] = {1,2,3,4,5};
            int b[] = new int[0];
            System.out.println(b[0]);
            System.out.println(a[7]);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Exception");
        } catch (Throwable ae){
            ae.printStackTrace();
            System.out.println("Throwable");
        }
    }
}
