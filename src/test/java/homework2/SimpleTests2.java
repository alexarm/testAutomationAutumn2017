package homework2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by aleksandrarmensin on 14.09.17.
 */
public class SimpleTests2 {

    //private String driverPath = "chromedriver.exe";

    //R in name means Regression Group

    @Test(groups = "regression")
    public void simpleTest1R() {
        //setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.epam.com");
        Assert.assertEquals(driver.getTitle(),
                "EPAM | Software Product Development Services");
        driver.close();
    }

    @Test(groups = "regression")
    public void simpleTest2R() {
        //setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.epam.com");
        Assert.assertEquals(driver.getTitle(),
                "EPAM | Software Product Development Services");
        driver.close();
    }

    @Test(groups = "regression")
    public void simpleTest3R() {
        //setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.epam.com");
        Assert.assertEquals(driver.getTitle(),
                "EPAM | Software Product Development Services");
        driver.close();
    }

    @Test(groups = "regression")
    public void simpleTest4R() {
        //setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.epam.com");
        Assert.assertEquals(driver.getTitle(),
                "EPAM | Software Product Development Services");
        driver.close();
    }
}
