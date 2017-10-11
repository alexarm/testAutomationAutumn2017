package homework3.init;

import com.codeborne.selenide.Configuration;

public abstract class InitTest {

    public InitTest() {
        Configuration.browser = "Chrome";
        Configuration.browserSize = "1440x900";
        Configuration.baseUrl = "https://jdi-framework.github.io/tests";
    }

}