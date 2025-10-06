package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecondLowSalEmp {

    public static void main(String[] args) {
        String appUrl = "https://the-internet.herokuapp.com/tables";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(appUrl);
        //WebElement headerElement = driver.findElement(By.xpath("//th[@class='header headerSortDown']/span[text()='Due']"));

        List<WebElement> dueItems = driver.findElements(By.xpath("//th/span[text()='Due']/ancestor::table[@id='table2']/tbody/tr/td[4]"));
        List<String> dues = new ArrayList<>();
        for (int i=0; i<dueItems.size(); i++){
            dues.add(dueItems.get(i).getText().substring(1));
        }

        System.out.println(dues);

        List<Double> actaulNumbers = new ArrayList<>();
        for (int i=0; i<dues.size(); i++){
            actaulNumbers.add(Double.valueOf(dues.get(i)));
        }

        Collections.sort(actaulNumbers);
        System.out.println(actaulNumbers);



        driver.findElement(By.xpath("//table[@id='table1']//td[contains(text(),'"+actaulNumbers.get(0)+"')]/following-sibling::td/a[text()='edit']")).click();
        driver.getCurrentUrl().contains("edit");

        System.out.println("");

    }

}
