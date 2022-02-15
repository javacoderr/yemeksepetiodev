import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BrowserProcess {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private static final By REMOVE_FAVORITES_BUTTON = By.xpath("//*[contains(text(),'Favorilerden Çıkar')]");
    private static By ADD_FAVORITES_BUTTON = By.xpath("//*[contains(text(),'Favorilere Ekle')]");
    private static By FIRST_RESTAURANT = By.xpath("//*[@id='new-restaurants']/div[1]");
    private static By NEW_RESTAURANT_TAB = By.xpath("//*[contains(text(),'Yeni Restoranlar')]");
    private static final By USER_INFO_COMBO = By.id("user-info");
    private static final By MYFAVORITES_PAGE_BUTTON = By.xpath("//*[@class='ys-userDetails']//./*[contains(text(),'Favorilerim')]");

    public void addFavoritesAtRestaurantDetail() {
        clickElement(NEW_RESTAURANT_TAB);
        clickElement(FIRST_RESTAURANT);
        clickElement(ADD_FAVORITES_BUTTON);
        Assert.assertTrue("Restaurant didn't add to favorites", driver.findElement(REMOVE_FAVORITES_BUTTON).isEnabled());
    }

    public void gotoMyFavoritesPage() {
        clickElement(USER_INFO_COMBO);
        clickElement(MYFAVORITES_PAGE_BUTTON);
    }

    public void clickRemoveMyFavoritesButton() {
        clickElement(REMOVE_FAVORITES_BUTTON);
        Assert.assertTrue("Restaurant didn't add to favorites", driver.findElement(ADD_FAVORITES_BUTTON).isEnabled());
    }
}
