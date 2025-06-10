package framework;

import com.microsoft.playwright.*;

public class BrowserFactory {

    public Browser createBrowser(Playwright playwright,String browserName){
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions().setHeadless(false);

        switch (browserName.toLowerCase()) {
            case "chrome":
                options.setChannel("chrome");
                return playwright.chromium().launch(options);
            case "edge":
                options.setChannel("msedge");
                return playwright.chromium().launch(options);
            case "firefox":
                return playwright.firefox().launch(options);
            case "webkit":
                return playwright.webkit().launch(options);
            default:
                System.out.println("Unsupported browser: " + browserName + ". Defaulting to Chrome.");
                options.setChannel("chrome");
                return playwright.chromium().launch(options);
        }
    }

    public void closePlaywright( Playwright playwright) {
        if (playwright != null) playwright.close();
    }
}
