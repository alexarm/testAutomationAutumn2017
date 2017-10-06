package homework3.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;

public class RightBar {

    @FindBy(css = ".panel-body-list.logs>li")
    private ElementsCollection logs;

    @Step
    public void checkLog(String element, Boolean ... bool){

        Boolean result = false;

        ElementsCollection logs = Selenide.$$(".logs > li");

        if (bool.length > 0){
            for(SelenideElement log: logs){
                if(log.getText().contains(element + ": condition changed to " + bool[0].toString())) {
                    result = true;
                }
            }
            Assert.assertTrue(result);
        }
        else{
            for(SelenideElement log: logs){
                if(log.getText().contains(": value changed to " + element)) {
                    result = true;
                }
            }
            Assert.assertTrue(result);
        }
    }
}
