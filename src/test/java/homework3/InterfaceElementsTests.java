package homework3;

import homework3.enums.Ranges;
import homework3.pages.DatesPage;
import homework3.pages.DifferentElementsPage;
import homework3.pages.IndexPage;
import homework3.util.InitTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static homework3.enums.CheckBoxes.*;
import static homework3.enums.Colors.*;
import static homework3.enums.RadioButtons.*;
import static homework3.enums.Ranges.*;
import static homework3.enums.Users.*;

public class InterfaceElementsTests extends InitTest{

    @BeforeClass
    public void setup(){
        indexPage = page(IndexPage.class);
        differentElementsPage = page(DifferentElementsPage.class);
        datesPage = page(DatesPage.class);
    }

    @Test
    public void testCorrectUserInterfaceWork(){

        //0. Open and login IndexPage
        indexPage.open();
        indexPage.login(USER1.username, USER1.password);
        indexPage.checkLogin();

        //1. Check interface on Index Page
        indexPage.checkInterface();

        //2. Check Service Menu
        indexPage.header.checkServiceMenu();
        indexPage.leftBar.checkServiceMenu();

        //3. Open page with different elements and check interface
        indexPage.header.openDifferentElementsPage();
        differentElementsPage.checkElements();

        //4. Check correct checkboxes work
        differentElementsPage.setSelect(WATER.checkBox,true);
        differentElementsPage.checkSelected(WATER.checkBox);
        differentElementsPage.rightBar.checkLog(WATER.label, true);
        differentElementsPage.setSelect(WIND.checkBox, true);
        differentElementsPage.checkSelected(WIND.checkBox);
        differentElementsPage.rightBar.checkLog(WIND.label, true);

        //5. Check correct radiobuttons work
        differentElementsPage.setSelect(SELEN.radio, true);
        differentElementsPage.checkSelected(SELEN.radio);
        differentElementsPage.rightBar.checkLog(SELEN.label);

        //6. Check correct dropdown work
        differentElementsPage.chooseColor(YELLOW.color);
        differentElementsPage.rightBar.checkLog(YELLOW.color);

        //7. Check log field
        differentElementsPage.setSelect(WATER.checkBox,false);
        differentElementsPage.checkUnselected(WATER.checkBox);
        differentElementsPage.rightBar.checkLog(WATER.label, false);
        differentElementsPage.setSelect(WIND.checkBox,false);
        differentElementsPage.checkUnselected(WIND.checkBox);
        differentElementsPage.rightBar.checkLog(WIND.label, false);

    }

    @Test
    public void testCorrectSlidersWork(){
        //0. Open and login IndexPage
        indexPage.open();
        indexPage.login(USER1.username, USER1.password);
        indexPage.checkLogin();

        //1. Open Dates Page
        indexPage.header.openDatesPage();

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

}
