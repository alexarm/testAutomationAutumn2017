package homework1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.*;

import static java.lang.System.setProperty;

/**
 * Created by aleksandrarmensin on 11.09.17.
 */

public class SeleniumTest {

    private WebDriver driver;
    private static final String TEST_SITE = "https://jdi-framework.github.io/tests";

    private static final String EXPECTED_BROWSER_TITLE = "Index Page";

    private static final String LOGIN_MENU_X_PATH = "//*[@class=\"dropdown uui-profile-menu\"]";
    private static final String LOGIN_X_PATH = ".//*[@id='Login']";
    private static final String PASSWD_X_PATH = ".//*[@id='Password']";
    private static final String ENTER_BUTTON_X_PATH = "//*[contains(@class, 'fa-sign-in')]";
    private static final String LOGIN = "epam";
    private static final String PASSWD = "1234";

    private static final String EXPECTED_NAME = "PITER CHAILOVSKII";
    private static final String USERNAME_X_PATH = "//div[@class='profile-photo']/span";

    private static final String CONTACT_FORM_X_PATH = "//li/a[contains(text(),'Contact form')]";
    private static final String EXPECTED_CONTACT_FORM_TITLE = "Contact Form";

    private static final String INPUT_NAME_X_PATH = ".//*[@id='Name']";
    private static final String INPUT_LAST_NAME_XPATH = ".//*[@id='LastName']";
    private static final String NAME = "Alex";
    private static final String LAST_NAME = "Arm";
    private static final String SUBMIT_BUTTON_X_PATH = "//button[contains(text(), 'Submit')]";
    private static final String LOG_RAW_X_PATH = "//ul[contains(@class, 'logs')]/li[1]";

    private String driverPath = "chromedriver";


    @BeforeMethod
    public void setUp(){
        setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        Dimension targetSize = new Dimension(1440, 900);
        driver.manage().window().setSize(targetSize);
    }

    @Test
    public void testRightLoginAndCorrectSubmitContactForm(){

        //navigate to website
        driver.navigate().to(TEST_SITE);

        //assert title
        String actualBrowserTitle = driver.getTitle();
        Assert.assertEquals(actualBrowserTitle, EXPECTED_BROWSER_TITLE);

        //login
        WebElement loginMenu = driver.findElement(By.xpath(LOGIN_MENU_X_PATH));
        loginMenu.click();
        WebElement loginInput = driver.findElement(By.xpath(LOGIN_X_PATH));
        loginInput.sendKeys(LOGIN);
        WebElement passwordInput = driver.findElement(By.xpath(PASSWD_X_PATH));
        passwordInput.sendKeys(PASSWD);
        WebElement enterButton = driver.findElement(By.xpath(ENTER_BUTTON_X_PATH));
        enterButton.click();

        //assert username
        WebElement username = driver.findElement(By.xpath(USERNAME_X_PATH));
        String actualUsername = username.getText();
        Assert.assertEquals(actualUsername, EXPECTED_NAME);

        //navigate to contact form
        WebElement contactForm = driver.findElement(By.xpath(CONTACT_FORM_X_PATH));
        contactForm.click();
        String actualContactFormTitle = driver.getTitle();
        Assert.assertEquals(actualContactFormTitle, EXPECTED_CONTACT_FORM_TITLE);

        //input name, lastname
        //assert logs
        WebElement inputName = driver.findElement(By.xpath(INPUT_NAME_X_PATH));
        inputName.sendKeys(NAME);
        WebElement inputLastName = driver.findElement(By.xpath(INPUT_LAST_NAME_XPATH));
        inputLastName.sendKeys(LAST_NAME);
        WebElement submitButton = driver.findElement(By.xpath(SUBMIT_BUTTON_X_PATH));
        submitButton.click();
        WebElement logRaw = driver.findElement(By.xpath(LOG_RAW_X_PATH));
        Assert.assertTrue(logRaw.getText().contains("submit"));

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }
}
