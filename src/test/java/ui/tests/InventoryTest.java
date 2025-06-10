package ui.tests;

import com.microsoft.playwright.BrowserContext;
import framework.PlayWrightManager;
import org.testng.annotations.Test;
import ui.pages.LoginPO;
import ui.pages.WmsPO;

import static apis.Requests.createSession;
import static ui.pages.WmsPO.NODE_ID;
import static ui.pages.WmsPO.getCookies;

public class InventoryTest extends PlayWrightManager {

    @Test
    public void SessionCreationTest(){
        LoginPO loginPO  = new LoginPO(page);
        WmsPO wmsPO = new WmsPO(page);

        BrowserContext context = PlayWrightManager.getContext();

        loginPO.doLogin("SBX_CI_ADMIN" , "StackboxCI123");
        wmsPO.openInventoryCount();
        wmsPO.changeBranch();
        String cookie = getCookies(context);
        createSession(cookie , NODE_ID);
        wmsPO.getSessionID();
    }

}
