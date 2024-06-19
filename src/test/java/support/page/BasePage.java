package support.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver browser;

    public BasePage(WebDriver browser){
        PageFactory.initElements(browser, this);
        this.browser = browser;
    }
}
