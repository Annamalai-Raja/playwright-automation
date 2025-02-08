package framework;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import ui.pages.AdvanceElements;
import ui.pages.BasicElements;

public class base {

   protected Playwright playwright;
   protected Browser browser;
     public Page page;

   public BasicElements baseElements;
   public AdvanceElements advanceElements;

    @BeforeTest
    public  void  setUp(){
        playwright = Playwright.create();
        BrowserType.LaunchOptions options =  new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false);
        browser = playwright.chromium().launch(options);
        page = browser.newPage();

        baseElements = new BasicElements(page);
        advanceElements = new AdvanceElements(page);
    }


    @BeforeMethod
    public void launchBrowser(){
        page.navigate("https://www.karthik.qa/practice");
    }

    @AfterTest
    public void tearDown(){
         page.close();
    }
}
