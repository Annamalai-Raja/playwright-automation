package ui.pages;

import com.microsoft.playwright.Page;
import framework.base;

public class AdvanceElements extends base {

    public AdvanceElements(Page page){
        this.page = page;
    }

    public void sliderEvent(){
        page.evaluate("document.querySelector('input[type=range]').value = 50");
    }
}
