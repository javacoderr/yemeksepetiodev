import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BrowserProcess {

    private WebDriver driver;

    public static By MAIL_TEXTBOX = By.id("UserName");
    public static By PASSWORD_TEXTBOX = By.id("password");
    public static By SIGNIN_BUTTON = By.id("ys-fastlogin-button");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void openLoginPage() {
        driver.navigate().to("https://www.yemeksepeti.com/istanbul");
    }

    public void successLogin(String email, String password) {
        typeToTextbox(MAIL_TEXTBOX, email);
        typeToTextbox(PASSWORD_TEXTBOX, password);
        clickElement(SIGNIN_BUTTON);
    }
}
