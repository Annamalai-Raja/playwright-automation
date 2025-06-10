package Commons;

import framework.PlayWrightManager;

public class BrowserActions extends PlayWrightManager {

    public void type(String locator , String value){
        page.locator(locator).fill(value);
    }

    public void clickOn(String locator){
        page.locator(locator).click();
    }
}
