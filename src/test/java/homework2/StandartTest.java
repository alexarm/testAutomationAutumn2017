package homework2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by aleksandrarmensin on 14.09.17.
 */
public class StandartTest {

    private WebDriver driver;
    private long timeBefore;
    private long timeAfter;

    @BeforeSuite
    public void globalSetUp(){
        //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @AfterSuite
    public void globalTearDown(){
        if(driver.toString().contains("null")) { driver.quit();}
    }

    @BeforeClass
    public void printTitle(){
        driver.navigate().to("https://www.epam.com");
        System.out.println(driver.getTitle());
    }

    @BeforeTest
    public void setUp(){
       driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }

    @BeforeMethod
    public void getTimeBefore(){
        timeBefore = System.currentTimeMillis();
        System.out.println(timeBefore);
    }

    @AfterMethod
    public void getTimeAfter(){
        timeAfter = System.currentTimeMillis();
        System.out.println(timeAfter);
        System.out.println("Time is " + (timeAfter-timeBefore) + " millis");
    }

    @Test
    public void simpleTest() {
        Assert.assertEquals(driver.getTitle(),
                "EPAM | Software Product Development Services");
    }

}
