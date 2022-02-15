import drivermanager.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import static java.time.format.DateTimeFormatter.ofPattern;


public abstract class BaseClass {
    protected static WebDriver driver;

    private static Dimension getWindowSize() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        return new Dimension((int) toolkit.getScreenSize().getWidth(),
                (int) toolkit.getScreenSize().getHeight());
    }

    @BeforeClass
    public static void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = WebDriverFactory.createWebDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver = new ChromeDriver();
    }

    @AfterClass
    public static void tearDown() throws IOException {
        String getDateNow = getDateNow();
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(source, new File("screenshots" + getDateNow + ".png"));
            System.out.println("Screenshot taken");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
        driver.quit();
    }

    public static String getDateNow() {
        LocalDateTime localDate = LocalDateTime.now();
        return localDate.format(ofPattern("ddMMMyyyy HHmmss"));
    }
}
