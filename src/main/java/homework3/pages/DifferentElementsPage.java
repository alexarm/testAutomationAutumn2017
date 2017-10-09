package homework3.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import homework3.enums.CheckBoxes;
import homework3.enums.Colors;
import homework3.enums.RadioButtons;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.page;
import static homework3.enums.CheckBoxes.*;

public class DifferentElementsPage {
    public RightBar rightBar = page(RightBar.class);

    @FindBy(css = ".label-checkbox>input")
    private ElementsCollection checkBoxes;

    @FindBy(css = ".label-radio>input")
    private ElementsCollection radioButtons;

    @FindBy(css = ".colors select")
    public SelenideElement selectElement;

    @Step
    public void checkElements(){
        checkBoxes.shouldHaveSize(4);
        for (SelenideElement checkBox: checkBoxes){
            Assert.assertTrue(CheckBoxes.getCheckBoxesLabels().contains(checkBox.closest("label").text()));
        }

        radioButtons.shouldHaveSize(4);
        for (SelenideElement radioButton: radioButtons){
            Assert.assertTrue(RadioButtons.getRadioLabels().contains(radioButton.closest("label").text()));
        }

        selectElement.shouldBe(visible);
        ElementsCollection selectOption = $$("select > option");
        for (SelenideElement option: selectOption){
            Assert.assertTrue(Colors.getColors().contains(option.getText()));
        }
    }

    @Step
    public void setSelect(Enum element, Boolean bool){
        boolean exist = false;
        SelenideElement setElement = null;
        if (element.getDeclaringClass().toString().matches(".*\\.enums\\.CheckBoxes$")) {
            for (SelenideElement checkBox : checkBoxes) {
                if (checkBox.closest("label").text().equalsIgnoreCase(element.toString())) {
                    exist = true;
                    setElement = checkBox;
                    break;
                }
            }
        }
        else if (element.getDeclaringClass().toString().matches(".*\\.enums\\.RadioButtons$")){
            for (SelenideElement radioButton : radioButtons) {
                if (radioButton.closest("label").text().equalsIgnoreCase(element.toString())) {
                    exist = true;
                    setElement = radioButton;
                    break;
                }
            }
        }
        else {
            throw new NullPointerException("Element to set not found");
        }
        if (exist){
            setElement.setSelected(bool);
        }
        else {
            throw new NullPointerException("Element to set not found");
        }

    }

    @Step
    public void checkSelected(Enum element){
        if (CheckBoxes.getCheckBoxesLabels().contains(element.toString())) {
            for (SelenideElement checkBox : checkBoxes) {
                if (checkBox.closest("label").text().equalsIgnoreCase(element.toString())) {
                    checkBox.shouldBe(selected);
                }
            }
        }
        else if (RadioButtons.getRadioLabels().contains(element.toString())){
            for (SelenideElement radioButton : radioButtons) {
                if (radioButton.closest("label").text().equalsIgnoreCase(element.toString())) {
                    radioButton.shouldBe(selected);
                }
            }
        }
        else {
            throw new NullPointerException("Element to set not found");
        }
    }

    @Step
    public void checkUnselected(Enum element) {
        if (CheckBoxes.getCheckBoxesLabels().contains(element.toString())) {
            for (SelenideElement checkBox : checkBoxes) {
                if (checkBox.closest("label").text().equalsIgnoreCase(element.toString())) {
                    checkBox.shouldNotBe(selected);
                }
            }
        }
        else if (RadioButtons.getRadioLabels().contains(element.toString())){
            for (SelenideElement radioButton : radioButtons) {
                if (radioButton.closest("label").text().equalsIgnoreCase(element.toString())) {
                    radioButton.shouldNotBe(selected);
                }
            }
        }
        else {
            throw new NullPointerException("Element to set not found");
        }
    }

    @Step
    public void chooseColor(String color){
        selectElement.selectOption(color);
    }


}
