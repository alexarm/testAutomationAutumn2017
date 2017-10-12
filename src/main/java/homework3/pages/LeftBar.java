package homework3.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homework3.enums.ServiceMenus;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class LeftBar {

    @FindBy(css = ".sub-menu")
    private SelenideElement serviceToggle;

    @FindBy(css = ".sub>li>a>p>span")
    private ElementsCollection serviceMenus;

    @Step("Check Service Menu in Left section is correct")
    public void checkServiceMenu() {
        serviceToggle.click();
        for (SelenideElement serviceMenu : serviceMenus) {
            Assert.assertTrue(ServiceMenus.getMenuNames().contains(serviceMenu.getText().toLowerCase()));
        }
    }
}
