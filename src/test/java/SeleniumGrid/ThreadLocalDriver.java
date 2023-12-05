package SeleniumGrid;

import org.openqa.selenium.WebDriver;

public class ThreadLocalDriver {
    //create a generic thread-local object
    protected static ThreadLocal<WebDriver> myThreadLocal = new ThreadLocal<>();

}
