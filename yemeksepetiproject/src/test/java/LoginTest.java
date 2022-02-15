import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseClass {

    BrowserProcess browserProcess = new BrowserProcess(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void successLogin() {
        loginPage.openLoginPage();
        loginPage.successLogin(Statics.CURRENT_MAIL + Statics.CURRENT_DOMAIN, Statics.CURRENT_PASSWORD);
        Assert.assertTrue("User didn't login", driver.findElement(By.id("user-info")).isDisplayed());
    }

    @Test
    public void failLoginWithWrongPassword() {
        loginPage.openLoginPage();
        loginPage.successLogin(Statics.CURRENT_MAIL + Statics.CURRENT_DOMAIN, Statics.UNCURRENT_PASSWORD);
        Assert.assertTrue("User didn't login", driver.findElement(By.xpath("//*[contains(text(),'Hatalı giriş. Lütfen kullanıcı adı ve şifrenizi kontrol edip tekrar deneyiniz.')]")).isDisplayed());
    }

    @Test
    public void failLoginWithWrongMail() {
        loginPage.openLoginPage();
        loginPage.successLogin(Statics.UNCURRENT_MAIL + Statics.CURRENT_DOMAIN, Statics.CURRENT_PASSWORD);
        Assert.assertTrue("User didn't login", driver.findElement(By.xpath("//*[contains(text(),'Hatalı giriş. Lütfen kullanıcı adı ve şifrenizi kontrol edip tekrar deneyiniz.')]")).isDisplayed());
    }

    @Test
    public void failScenerioForScreenshot(){
        loginPage.openLoginPage();
        loginPage.successLogin(Statics.UNCURRENT_MAIL + Statics.CURRENT_DOMAIN, Statics.CURRENT_PASSWORD);
        Assert.assertTrue("User didn't login", driver.findElement(By.id("user-info")).isDisplayed());
    }

}
