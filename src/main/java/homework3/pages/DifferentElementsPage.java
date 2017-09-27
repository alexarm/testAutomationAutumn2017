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

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.page;
import static homework3.enums.CheckBoxes.*;

public class DifferentElementsPage {

    public Header header = page(Header.class);
    public LeftBar leftBar = page(LeftBar.class);
    public RightBar rightBar = page(RightBar.class);

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkBoxes;

    @FindBy(css = ".label-radio")
    private ElementsCollection radioButtons;

    @FindBy(css = ".colors select")
    public SelenideElement selectElement;

    public void checkElements(){
        checkBoxes.shouldHaveSize(4);
        for (SelenideElement checkBox: checkBoxes){
            Assert.assertTrue(CheckBoxes.getCheckBoxesLabels().contains(checkBox.getText()));
        }

        radioButtons.shouldHaveSize(4);
        for (SelenideElement radioButton: radioButtons){
            Assert.assertTrue(RadioButtons.getRadioLabels().contains(radioButton.getText()));
        }

        selectElement.shouldBe(visible);
        ElementsCollection selectOption = $$("select > option");
        for (SelenideElement option: selectOption){
            Assert.assertTrue(Colors.getColors().contains(option.getText()));
        }
    }

    public void setSelect(SelenideElement element, Boolean bool){
        element.setSelected(bool);
    }

    public void checkSelected(SelenideElement checkBox){
        checkBox.shouldBe(selected);
    }

    public void checkUnselected(SelenideElement checkBox){
        checkBox.shouldNotBe(selected);
    }

    public void chooseColor(String color){
        selectElement.selectOption(color);
    }


}
