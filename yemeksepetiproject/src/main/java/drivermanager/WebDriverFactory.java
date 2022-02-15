package drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    //private String PATH_SAFARI_DRIVER = "/usr/bin/safaridriver";
    public static WebDriver createWebDriver() {
        String webdriver = System.getProperty("browser", "chrome");
        if ("firefox".equals(webdriver)) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if ("chrome".equals(webdriver)) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }//TODO: implement SafariDriver to drivermanager
        //return new SafariDriver();
        //throw new RuntimeException("Unsupported webdriver: " + webdriver);

        throw new RuntimeException("Unsupported webdriver: " + webdriver);
    }
}