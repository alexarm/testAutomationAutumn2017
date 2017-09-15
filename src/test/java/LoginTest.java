import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * Created by aleksandrarmensin on 15.09.17.
 */
public class LoginTest {

    private WebDriver driver;

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }

    @Test
    public void loginTest(){
        //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        Dimension targetSize = new Dimension(1440, 900);
        driver.manage().window().setSize(targetSize);

        driver.navigate().to("https://jdi-framework.github.io/tests");

        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);

        indexPage.login("epam", "1234");

    }
}
