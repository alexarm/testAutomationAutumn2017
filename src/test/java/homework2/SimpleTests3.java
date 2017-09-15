package homework2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by aleksandrarmensin on 14.09.17.
 */
public class SimpleTests3 {

    //private String driverPath = "chromedriver.exe";

    //R in name means Regression Group, S means Smoke Group

    @Test(groups = {"regression", "smoke"})
    public void simpleTest1SR() {
        //setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.epam.com");
        Assert.assertEquals(driver.getTitle(),
                "EPAM | Software Product Development Services");
        driver.close();
    }

    @Test(groups = {"regression", "smoke"})
    public void simpleTest2SR() {
        //setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.epam.com");
        Assert.assertEquals(driver.getTitle(),
                "EPAM | Software Product Development Services");
        driver.close();
    }

    @Test(groups = {"regression", "smoke"})
    public void simpleTest3SR() {
        //setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.epam.com");
        Assert.assertEquals(driver.getTitle(),
                "EPAM | Software Product Development Services");
        driver.close();
    }

}
