package ui.pages;

import com.microsoft.playwright.Page;
import framework.base;

public class BasicElements extends base {

    public String  txtInput = "#practice-input";
    public String ddOption = "#practice-select";
    public String checkBox = "#practice-checkbox";

    public BasicElements(Page page) {
        this.page = page;
    }

    public void enterText(){
        page.locator(txtInput).fill("Annamalai QA");
    }

    public void selectDropDown(){
        page.selectOption(ddOption , "Option 1");
    }

    public void clickCheckbox(){
        page.click(checkBox);
    }
}
