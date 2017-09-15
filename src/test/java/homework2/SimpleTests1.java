package homework2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by aleksandrarmensin on 14.09.17.
 */
public class SimpleTests1 {

    //private String driverPath = "chromedriver.exe";

    //S in name means Smoke Group

    @Test(groups = "smoke")
    public void simpleTest1S() {
        //setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.epam.com");
        Assert.assertEquals(driver.getTitle(),
                "EPAM | Software Product Development Services");
        driver.close();
    }

    @Test(groups = "smoke")
    public void simpleTest2S() {
        //setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.epam.com");
        Assert.assertEquals(driver.getTitle(),
                "EPAM | Software Product Development Services");
        driver.close();
    }
}
