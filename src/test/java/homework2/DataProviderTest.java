package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

/**
 * Created by aleksandrarmensin on 14.09.17.
 */
public class DataProviderTest {

    private WebDriver driver;
    private final String TEST_SITE = "https://jdi-framework.github.io/tests";


    @DataProvider(parallel = true)
    private Object[][] expectedTexts(){
        return new Object[][]{
                {0, "To include good practices\nand ideas from successful\nEPAM projec"},
                {1, "To be flexible and\ncustomizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"},
        };
    }

    @Test(dataProvider = "expectedTexts")
    public void testAreTextsRight(int textNumber, String expectedText){
        //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Dimension targetSize = new Dimension(1440, 900);
        driver.manage().window().setSize(targetSize);

        driver.navigate().to(TEST_SITE);
        List<WebElement> actualTexts = driver.findElements(By.xpath("//span[@class='benefit-txt']"));
        Assert.assertEquals(actualTexts.get(textNumber).getText(), expectedText);

        driver.close();
    }

}
