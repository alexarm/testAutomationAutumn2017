package homework3.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import homework3.enums.HeaderMenu;
import homework3.enums.ServiceMenus;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class Header {

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
    public void login(String username, String password){
        userIcon.should(visible).click();
        loginInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInButton.should(visible).click();
    }

    @Step
    public void open(Enum... pages){
        if (pages.length == 1){
            for (SelenideElement headerMenu: headerMenus){
                if (headerMenu.innerText().equalsIgnoreCase(pages[0].toString())){
                    headerMenu.click();
                }
            }
        }
        else {
            for (SelenideElement serviceMenu : serviceMenus) {
                if (serviceMenu.innerText().equalsIgnoreCase(pages[1].toString())) {
                    serviceToggle.click();
                    serviceMenu.click();
                }
            }
        }
    }

    @Step
    public void checkServiceMenu(){
        serviceToggle.click();
        for (SelenideElement serviceMenu: serviceMenus){
            Assert.assertTrue(ServiceMenus.getMenuNames().contains(serviceMenu.getText().toLowerCase()));
        }
    }

    public void openDifferentElementsPage(){
        serviceToggle.click();
        serviceMenus.get(5).click();
    }

    public void openDatesPage(){
        serviceToggle.click();
        serviceMenus.get(1).click();
    }


}
