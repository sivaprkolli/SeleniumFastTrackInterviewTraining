package DesignPatterns;

public class DriverFactory {

    public static BrowserDriver getDriver(String browser){
        switch (browser){
            case "chrome":
                return new ChromeDriverManager();

            case "firefox":
                return new FireFoxDriverManager();

            default:
                throw new IllegalArgumentException();
        }
    }
}
