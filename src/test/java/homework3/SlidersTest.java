package homework3;

import com.codeborne.selenide.Selenide;
import homework3.init.InitTest;
import homework3.listeners.AllureAttachmentListener;
import homework3.pages.DatesPage;
import homework3.pages.Header;
import homework3.pages.IndexPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static homework3.enums.Ranges.*;
import static homework3.enums.ServiceMenus.DATES;
import static homework3.enums.Users.USER1;

@Listeners(AllureAttachmentListener.class)
public class SlidersTest extends InitTest {

    private IndexPage indexPage;
    private DatesPage datesPage;
    private Header header;

    @BeforeMethod
    public void setup() {
        indexPage = page(IndexPage.class);
        datesPage = page(DatesPage.class);
        header = page(Header.class);
    }

    @Test
    public void testCorrectSlidersWork() {
        //0. Open and login IndexPage
        indexPage.open();
        header.login(USER1.username, USER1.password);
        header.checkLogin();

        //1. Open Dates Page
        header.open(DATES);

        //2. Check slider work
        datesPage.setSliders(MIN.range, MAX.range);
        datesPage.checkRange(MIN.range, MAX.range);

        datesPage.setSliders(MIN.range, MIN.range);
        datesPage.checkRange(MIN.range, MIN.range);

        datesPage.setSliders(MAX.range, MAX.range);
        datesPage.checkRange(MAX.range, MAX.range);

        datesPage.setSliders(LEFT_TEST.range, RIGHT_TEST.range);
        datesPage.checkRange(LEFT_TEST.range, RIGHT_TEST.range);
    }

    @AfterMethod
    public void tearDown() {
        Selenide.close();
    }
}
