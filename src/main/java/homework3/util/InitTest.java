package homework3.util;

import com.codeborne.selenide.Configuration;
import homework3.pages.DatesPage;
import homework3.pages.DifferentElementsPage;
import homework3.pages.IndexPage;

import static com.codeborne.selenide.Selenide.page;

public abstract class InitTest {

    public InitTest() {
        Configuration.browser = "Chrome";
        Configuration.browserSize = "1440x900";
        Configuration.baseUrl = "https://jdi-framework.github.io/tests";
    }

}
