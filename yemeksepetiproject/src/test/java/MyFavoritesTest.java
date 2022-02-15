import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class MyFavoritesTest extends BaseClass {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homepage = new HomePage(driver);
    MyFavoritesPage myFavoritesPage = new MyFavoritesPage(driver);


    @Test
    public void addMyFavoritesFromHomePage() {
        loginPage.openLoginPage();
        loginPage.successLogin(Statics.CURRENT_MAIL + Statics.CURRENT_DOMAIN, Statics.CURRENT_PASSWORD);
        Assert.assertTrue("User didn't login", driver.findElement(By.id("user-info")).isDisplayed());
        homepage.addFavoritesAtRestaurantDetail();
    }


    @Test
    public void removeMyFavoritesRestaurant() {
        loginPage.openLoginPage();
        loginPage.successLogin(Statics.CURRENT_MAIL + Statics.CURRENT_DOMAIN, Statics.CURRENT_PASSWORD);
        homepage.gotoMyFavoritesPage();
        String restaurantName = myFavoritesPage.getRestaurantName();
        myFavoritesPage.clickFirstMyFavoritesRestaurant();
        homepage.clickRemoveMyFavoritesButton();
        homepage.gotoMyFavoritesPage();
        Assert.assertTrue("Restaurant didn't removed  list", driver.findElements(By.xpath("//*[contains(text(),'" + restaurantName + "')]")).size() < 1);
    }
}
