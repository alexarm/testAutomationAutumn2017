package homework3.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homework3.enums.HeaderMenu;
import homework3.enums.ServiceMenus;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static homework3.enums.Users.USER1;

public class Header {

    @FindBy(css = ".profile-photo span")
    private SelenideElement loginText;

    @FindBy(css = ".fa-user")
    private SelenideElement userIcon;

    @FindBy(css = "#Login")
    private SelenideElement loginInput;

    @FindBy(css = "#Password")
    private SelenideElement passwordInput;

    @FindBy(css = ".fa-sign-in")
    private SelenideElement signInButton;

    @FindBy(css = ".m-l8>li")
    private ElementsCollection headerMenus;

    @FindBy(css = ".dropdown a[href='page1.htm']")
    private SelenideElement serviceToggle;

    @FindBy(css = ".dropdown-menu>li>a")
    private ElementsCollection serviceMenus;

    @Step
    public void login(String username, String password) {
        userIcon.should(visible).click();
        loginInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInButton.should(visible).click();
    }

    public void checkLogin() {
        loginText.shouldBe(visible).should(text(USER1.name));
    }

    @Step("Open page")
    public void open(HeaderMenu menu) {
        for (SelenideElement headerMenu : headerMenus) {
            if (headerMenu.innerText().equalsIgnoreCase(menu.toString())) {
                headerMenu.click();
            }
        }
    }

    @Step("Open page")
    public void open(ServiceMenus menu) {
        for (SelenideElement serviceMenu : serviceMenus) {
            if (serviceMenu.innerText().equalsIgnoreCase(menu.toString())) {
                serviceToggle.click();
                serviceMenu.click();
            }
        }
    }

    @Step("Check Service Menu in header is correct")
    public void checkServiceMenu() {
        serviceToggle.click();
        for (SelenideElement serviceMenu : serviceMenus) {
            Assert.assertTrue(ServiceMenus.getMenuNames().contains(serviceMenu.getText().toLowerCase()));
        }
    }

}
