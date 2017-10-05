package homework3.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.getWebDriverLogs;
import static com.codeborne.selenide.Selenide.page;
import static homework3.util.CalculateMethods.*;

public class DatesPage {
    @FindBy(css = ".ui-slider-handle:nth-of-type(1)")
    private SelenideElement leftHandle;

    @FindBy(css = ".ui-slider-handle:nth-of-type(2)")
    private SelenideElement rightHandle;

    @FindBy(css = ".ui-slider")
    private SelenideElement sliderTrack;

    public void setSliders(int leftValue, int rightValue){

        if(leftValue > Integer.parseInt($(".ui-slider-handle:nth-of-type(2)>span").getText())){

            actions().dragAndDropBy(rightHandle, getOffset(rightValue, sliderTrack, rightHandle), 0).perform();
            actions().dragAndDropBy(leftHandle, getOffset(leftValue, sliderTrack, leftHandle), 0).perform();
        }
        else {

            actions().dragAndDropBy(leftHandle, getOffset(leftValue, sliderTrack, leftHandle), 0).perform();
            actions().dragAndDropBy(rightHandle, getOffset(rightValue, sliderTrack, rightHandle), 0).perform();
        }
    }

    public void checkRange(int leftValue, int rightValue){
        leftHandle.should(text(String.valueOf(leftValue)));
        rightHandle.should(text(String.valueOf(rightValue)));
    }
}
