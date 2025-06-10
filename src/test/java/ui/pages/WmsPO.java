package ui.pages;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.Cookie;
import framework.PlayWrightManager;

import java.util.List;

public class WmsPO extends PlayWrightManager {

    public static String NODE_ID ;

    String btnWms = "#wms";
    String btnExpandIcon = "#expand-menu-icon";
    String btnInventoryMenu = "#menu-item-Inventory";
    String btnInventoryCount = "#submenu-item-Inventory\\ Count";
    String lblInventoryCount = "//h3[text() = 'Inventory Count']";
    String btnProfileSelector = "#profile-node-selector";
    String selectBranch = "//h6[text() = 'SBX CI 1 (SBX_CI_1)']";
    String btnFilter = "#filter-m";

   String btnStateDD = "(//div[contains(@class , 'react-select__indicator react-select__dropdown-indicator')])[1]";

   String btnPeding = "//div[text() = 'PENDING']";

   String lblSessionId = "//p[text()='PENDING']/ancestor::div[@role='button']//h4";



    public WmsPO(Page page) {
        this.page = page;
    }

    public static String getCookies(BrowserContext context) {
        List<Cookie> cookiesList = context.cookies();
        StringBuilder cookies = new StringBuilder();

        for (Cookie cookie : cookiesList) {
            cookies.append(cookie.name).append("=").append(cookie.value).append("; ");
        }

        String cookieString = cookies.toString().trim();

        // Optional: remove trailing semicolon if needed
        if (cookieString.endsWith(";")) {
            cookieString = cookieString.substring(0, cookieString.length() - 1);
        }

        System.out.println(cookieString);
        return cookieString;
    }


    public void openInventoryCount(){
        page.locator(btnWms).click();
        page.locator(btnExpandIcon).click();
        page.locator(btnInventoryMenu).click();
        page.locator(btnInventoryCount).click();
    }

    public void changeBranch(){
        page.locator(btnProfileSelector).click();
        page.locator(selectBranch).click();
        getNodeID();
    }


    private  void getNodeID(){
        String currentUrl = page.url();
        System.out.println(currentUrl);
        System.out.println(currentUrl.replaceAll(".*nodeId=(\\d+).*", "$1"));
        NODE_ID = currentUrl.replaceAll(".*nodeId=(\\d+).*", "$1");
    }

    public void getSessionID(){
        page.reload();
        page.locator(btnFilter).click();
        page.locator(btnStateDD).click();
        page.locator(btnPeding).click();
        System.out.println(page.locator(lblSessionId).textContent());
    }

}
