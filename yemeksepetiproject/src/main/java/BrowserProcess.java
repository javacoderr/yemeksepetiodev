import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BrowserProcess {

    WebDriver driver;

    public void typeToTextbox(By by, String keyword) {
        WebElement element = driver.findElement(by);
        element.click();
        element.sendKeys(keyword);
    }

    public void clickElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    public WebElement visibilityWait(int timeoutInSeconds, By by) {
        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(ofSeconds(timeoutInSeconds)).
                pollingEvery(ofMillis(500)).
                ignoring(NotFoundException.class).ignoring(NoSuchElementException.class);
        return wait.until(visibilityOfElementLocated(by));
    }

    public BrowserProcess(WebDriver driver) {
        this.driver = driver;
    }
}
