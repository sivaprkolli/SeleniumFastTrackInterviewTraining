package Selenium4;

import com.sun.source.tree.WhileLoopTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TableHandling {
    WebDriver driver;
    @Test
    public void assignmnetTest() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("119");
        driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/tables");

        List<WebElement> table1HeaderNames = driver.findElements(By.xpath("//table[@id='table1']/descendant::span"));

        List<String> actualHeaderNames = new ArrayList<>();

        Iterator iterator = table1HeaderNames.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("************************************************");

        for(int i=0; i< table1HeaderNames.size(); i++){
            System.out.println(table1HeaderNames.get(i).getText());
            actualHeaderNames.add(table1HeaderNames.get(i).getText());
        }

        System.out.println(actualHeaderNames);

        List<String> expectedHeaders = new ArrayList<>();
        expectedHeaders.add("Last Name");
        expectedHeaders.add("First Name");
        expectedHeaders.add("Email");
        expectedHeaders.add("Due");
        expectedHeaders.add("Web Site");
        expectedHeaders.add("Action");

        Assert.assertEquals(actualHeaderNames, expectedHeaders);



    }
}
