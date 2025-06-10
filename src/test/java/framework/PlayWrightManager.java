package framework;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

public class PlayWrightManager {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected static BrowserContext context;

    BrowserFactory factory = new BrowserFactory();

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browserName) {
        playwright = Playwright.create();
        browser = factory.createBrowser(playwright, browserName);
        context = browser.newContext();
        page = context.newPage();
    }

    public static BrowserContext getContext() {
        return context;
    }

    @BeforeMethod
    public void launchApp() {
        page.navigate("https://wms.staging.stackbox.xyz/login");
    }

    @AfterClass
    public void tearDown() {
        if (page != null) page.close();
        if (context != null) context.close();
        if (browser != null) browser.close();
        factory.closePlaywright(playwright); // closes Playwright instance
    }
}
