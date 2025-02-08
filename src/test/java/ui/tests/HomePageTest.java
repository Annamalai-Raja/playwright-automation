package ui.tests;

import framework.base;
import org.testng.annotations.Test;

public class HomePageTest extends base {

    @Test
    public void basicElementsTest(){
        baseElements.enterText();
        baseElements.selectDropDown();
        baseElements.clickCheckbox();
    }

    @Test
    public void advancedElementsTest(){
        advanceElements.sliderEvent();
    }
}
