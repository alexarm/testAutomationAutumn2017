package homework3.util;

import com.codeborne.selenide.Configuration;
import homework3.pages.DatesPage;
import homework3.pages.DifferentElementsPage;
import homework3.pages.IndexPage;

import static com.codeborne.selenide.Selenide.page;

/**
 * Created by aleksandrarmensin on 21.09.17.
 */
public abstract class InitTest {

    public InitTest() {
        Configuration.browser = "Chrome";
        Configuration.baseUrl = "https://jdi-framework.github.io/tests";
    }

    protected IndexPage indexPage;
    protected DifferentElementsPage differentElementsPage;
    protected DatesPage datesPage;

}
