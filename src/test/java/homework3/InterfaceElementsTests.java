package homework3;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.webdriver.WebDriverFactory;
import homework3.enums.Ranges;
import homework3.enums.ServiceMenus;
import homework3.pages.DatesPage;
import homework3.pages.DifferentElementsPage;
import homework3.pages.Header;
import homework3.pages.IndexPage;
import homework3.util.AllureAttachmentListener;
import homework3.util.InitTest;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static homework3.enums.CheckBoxes.*;
import static homework3.enums.Colors.*;
import static homework3.enums.HeaderMenu.HOME;
import static homework3.enums.HeaderMenu.SERVICE;
import static homework3.enums.RadioButtons.*;
import static homework3.enums.Ranges.*;
import static homework3.enums.ServiceMenus.*;
import static homework3.enums.Users.*;

@Listeners(AllureAttachmentListener.class)
public class InterfaceElementsTests extends InitTest{

    private IndexPage indexPage;
    private DifferentElementsPage differentElementsPage;
    private DatesPage datesPage;
    private Header header;

    @BeforeMethod
    public void setup(){
        indexPage = page(IndexPage.class);
        differentElementsPage = page(DifferentElementsPage.class);
        datesPage = page(DatesPage.class);
        header = page(Header.class);
    }

    @Test
    public void testCorrectUserInterfaceWork(){

        //0. Open and login IndexPage
        indexPage.open();
        header.open(HOME);
        header.login(USER1.username, USER1.password);
        indexPage.checkLogin();

        //1. Check interface on Index Page
        indexPage.checkInterface();

        //2. Check Service Menu
        header.checkServiceMenu();
        indexPage.leftBar.checkServiceMenu();

        //3. Open page with different elements and check interface
        header.open(SERVICE, DIFFERENT_ELEMENTS);
        differentElementsPage.checkElements();

        //4. Check correct checkboxes work
        differentElementsPage.setSelect(WATER,true);
        differentElementsPage.checkSelected(WATER);
        differentElementsPage.rightBar.checkLog(WATER, true);
        differentElementsPage.setSelect(WIND, true);
        differentElementsPage.checkSelected(WIND);
        differentElementsPage.rightBar.checkLog(WIND, true);

        //5. Check correct radiobuttons work
        differentElementsPage.setSelect(SELEN, true);
        differentElementsPage.checkSelected(SELEN);
        differentElementsPage.rightBar.checkLog(SELEN);

        //6. Check correct dropdown work
        differentElementsPage.chooseColor(YELLOW.color);
        differentElementsPage.rightBar.checkLog(YELLOW);

        //7. Check log field
        differentElementsPage.setSelect(WATER,false);
        differentElementsPage.checkUnselected(WATER);
        differentElementsPage.rightBar.checkLog(WATER, false);
        differentElementsPage.setSelect(WIND,false);
        differentElementsPage.checkUnselected(WIND);
        differentElementsPage.rightBar.checkLog(WIND, false);

    }

    @AfterMethod
    public void tearDown(){
        Selenide.close();
    }

}
