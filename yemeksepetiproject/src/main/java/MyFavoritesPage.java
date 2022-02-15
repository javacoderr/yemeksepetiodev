import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyFavoritesPage extends BrowserProcess {

    private WebDriver driver;
    private static final By FIRST_MY_FAVORITES_RESTAURANT = By.xpath("//*[@id='favorites']/form/div[1]/div[1]/a/span/b");

    public MyFavoritesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickFirstMyFavoritesRestaurant(){
        clickElement(FIRST_MY_FAVORITES_RESTAURANT);
    }

    public String getRestaurantName(){
        return driver.findElement(FIRST_MY_FAVORITES_RESTAURANT).getText();
    }

}
