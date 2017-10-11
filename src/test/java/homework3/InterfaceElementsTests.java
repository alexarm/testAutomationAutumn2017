package homework3;

import com.codeborne.selenide.Selenide;
import homework3.pages.DifferentElementsPage;
import homework3.pages.Header;
import homework3.pages.IndexPage;
import homework3.listeners.AllureAttachmentListener;
import homework3.init.InitTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static homework3.enums.CheckBoxes.WATER;
import static homework3.enums.CheckBoxes.WIND;
import static homework3.enums.Colors.YELLOW;
import static homework3.enums.HeaderMenu.HOME;
import static homework3.enums.HeaderMenu.SERVICE;
import static homework3.enums.RadioButtons.SELEN;
import static homework3.enums.ServiceMenus.DIFFERENT_ELEMENTS;
import static homework3.enums.Users.USER1;

@Listeners(AllureAttachmentListener.class)
public class InterfaceElementsTests extends InitTest {

    private IndexPage indexPage;
    private DifferentElementsPage differentElementsPage;
    private Header header;

    @BeforeMethod
    public void setup() {
        indexPage = page(IndexPage.class);
        differentElementsPage = page(DifferentElementsPage.class);
        header = page(Header.class);
    }

    @Test
    public void testCorrectUserInterfaceWork() {

        //0. Open and login IndexPage
        indexPage.open();
        header.open(HOME);
        header.login(USER1.username, USER1.password);
        header.checkLogin();

        //1. Check interface on Index Page
        indexPage.checkInterface();

        //2. Check Service Menu
        header.checkServiceMenu();
        indexPage.leftBar.checkServiceMenu();

        //3. Open page with different elements and check interface
        header.open(SERVICE, DIFFERENT_ELEMENTS);
        differentElementsPage.checkElements();

        //4. Check correct checkboxes work
        differentElementsPage.setSelectCheckBox(WATER, true);
        differentElementsPage.checkSelectedCheckBox(WATER);
        differentElementsPage.rightBar.checkLog(WATER, true);
        differentElementsPage.setSelectCheckBox(WIND, true);
        differentElementsPage.checkSelectedCheckBox(WIND);
        differentElementsPage.rightBar.checkLog(WIND, true);

        //5. Check correct radiobuttons work
        differentElementsPage.setSelectRadiobutton(SELEN, true);
        differentElementsPage.checkSelectedRadiobutton(SELEN);
        differentElementsPage.rightBar.checkLog(SELEN);

        //6. Check correct dropdown work
        differentElementsPage.chooseColor(YELLOW);
        differentElementsPage.rightBar.checkLog(YELLOW);

        //7. Check log field
        differentElementsPage.setSelectCheckBox(WATER, false);
        differentElementsPage.checkUnselectedCheckBox(WATER);
        differentElementsPage.rightBar.checkLog(WATER, false);
        differentElementsPage.setSelectCheckBox(WIND, false);
        differentElementsPage.checkUnselectedCheckBox(WIND);
        differentElementsPage.rightBar.checkLog(WIND, false);

    }

    @AfterMethod
    public void tearDown() {
        Selenide.close();
    }

}
