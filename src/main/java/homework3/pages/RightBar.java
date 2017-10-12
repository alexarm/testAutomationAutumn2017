package homework3.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import homework3.enums.CheckBoxes;
import homework3.enums.Colors;
import homework3.enums.RadioButtons;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class RightBar {

    @Step("Check log section, when Radio value changed")
    public void checkLog(RadioButtons element) {
        Boolean result = false;
        ElementsCollection logs = Selenide.$$(".logs > li");
        for (SelenideElement log : logs) {
            if (log.getText().contains("metal: value changed to " + element.toString())) {
                result = true;
            }
        }
        Assert.assertTrue(result);
    }

    @Step("Check log section, when CheckBox value changed")
    public void checkLog(CheckBoxes checkBox, Boolean bool) {
        Boolean result = false;
        ElementsCollection logs = Selenide.$$(".logs > li");
        for (SelenideElement log : logs) {
            if (log.getText().contains(checkBox.toString() + ": condition changed to " + bool.toString())) {
                result = true;
            }
        }
        Assert.assertTrue(result);
    }

    @Step("Check log section, when Dropdown value changed")
    public void checkLog(Colors color) {
        Boolean result = false;
        ElementsCollection logs = Selenide.$$(".logs > li");
        for (SelenideElement log : logs) {
            if (log.getText().contains("Colors: value changed to " + color.toString())) {
                result = true;
            }
        }
        Assert.assertTrue(result);
    }
}
