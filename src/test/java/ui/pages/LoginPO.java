package ui.pages;

import com.microsoft.playwright.Page;
import framework.PlayWrightManager;
import Commons.BrowserActions;

public class LoginPO extends PlayWrightManager {

    String  txtUsername = "#user-name-input";
    String txtPassword = "#user-password-input";
    String btnLogin = "#main-login-button";
    String btnProfile ="#profile";

    public LoginPO(Page page){
        this.page = page;
    }

    public  void doLogin(String username , String password){
   page.type();
        page.locator(txtPassword).fill(password);
        page.locator(btnLogin).click();
    }

    public boolean isLoggedIn(){
        System.out.println(page.title());
        page.locator(btnProfile).waitFor();
        return page.locator(btnProfile).isVisible();
    }

}
