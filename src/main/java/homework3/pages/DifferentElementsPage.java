package homework3.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homework3.enums.CheckBoxes;
import homework3.enums.Colors;
import homework3.enums.RadioButtons;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class DifferentElementsPage {
    public RightBar rightBar = page(RightBar.class);

    @FindBy(css = ".label-checkbox>input")
    private ElementsCollection checkBoxes;

    @FindBy(css = ".label-radio>input")
    private ElementsCollection radioButtons;

    @FindBy(css = ".colors select")
    public SelenideElement selectElement;

    @FindBy(css = "select > option")
    private ElementsCollection selectOptions;

    @Step
    public void checkElements() {
        checkBoxes.shouldHaveSize(4);
        for (SelenideElement checkBox : checkBoxes) {
            Assert.assertTrue(CheckBoxes.getCheckBoxesLabels().contains(checkBox.closest("label").text()));
        }

        radioButtons.shouldHaveSize(4);
        for (SelenideElement radioButton : radioButtons) {
            Assert.assertTrue(RadioButtons.getRadioLabels().contains(radioButton.closest("label").text()));
        }

        selectElement.shouldBe(visible);
        for (SelenideElement option : selectOptions) {
            Assert.assertTrue(Colors.getColors().contains(option.getText()));
        }
    }

    @Step
    public void setSelectCheckBox(CheckBoxes checkBox, Boolean bool) {
        checkBoxes.get(checkBox.ordinal()).setSelected(bool);
    }

    @Step
    public void checkSelectedCheckBox(CheckBoxes checkBox) {
        checkBoxes.get(checkBox.ordinal()).shouldBe(selected);
    }

    @Step
    public void checkUnselectedCheckBox(CheckBoxes checkBox) {
        checkBoxes.get(checkBox.ordinal()).shouldNotBe(selected);
    }

    @Step
    public void setSelectRadiobutton(RadioButtons radio, Boolean bool) {
        radioButtons.get(radio.ordinal()).setSelected(bool);
    }

    @Step
    public void checkSelectedRadiobutton(RadioButtons radioButton) {
        radioButtons.get(radioButton.ordinal()).shouldBe(selected);
    }

    @Step
    public void chooseColor(Colors color) {
        selectElement.selectOption(color.toString());
    }

}
