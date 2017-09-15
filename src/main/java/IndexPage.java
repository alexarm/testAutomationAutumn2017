import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by aleksandrarmensin on 15.09.17.
 */
public class IndexPage {

    @FindBy(xpath = "//*[@class=\"dropdown uui-profile-menu\"]")
    private WebElement loginForm;

    @FindBy(xpath = ".//*[@id='Login']")
    private WebElement inputLogin;

    @FindBy(xpath = ".//*[@id='Password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[contains(@class, 'fa-sign-in')]")
    private WebElement signinButton;

    public void login(String username, String password){
        loginForm.click();
        inputLogin.sendKeys(username);
        inputPassword.sendKeys(password);
        signinButton.click();
    }

}
