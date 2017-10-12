package homework3.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import homework3.enums.TextsUnderPictures;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static homework3.enums.TextsAbove.MAIN_TITLE;
import static homework3.enums.TextsAbove.MAIN_TXT;

public class IndexPage {
    public LeftBar leftBar = page(LeftBar.class);

    @FindBy(css = ".icons-benefit")
    private ElementsCollection mainIcons;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection textsUnderPictures;

    @FindBy(css = ".main-title")
    public SelenideElement mainTitle;

    @FindBy(css = ".main-txt")
    public SelenideElement mainTxt;

    public void open() {
        Selenide.open("/");
    }

    @Step("Check pictures on Index Page")
    public void checkPictures() {
        for (SelenideElement icon : mainIcons) {
            icon.should(visible);
        }
    }

    @Step("Check texts under pictures on Index Page")
    public void checkTextsUnderPictures() {
        for (SelenideElement text : textsUnderPictures) {
            Assert.assertTrue(TextsUnderPictures.getTexts().contains(text.getText()));
        }
    }

    @Step("Check main texts on Index page")
    public void checkTextsAbove() {
        mainTitle.should(visible).should(text(MAIN_TITLE.text));
        mainTxt.should(visible).should(text(MAIN_TXT.text));
    }

    public void checkInterface() {
        this.checkPictures();
        this.checkTextsUnderPictures();
        this.checkTextsAbove();
    }
}

