package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.page.BasePage;

import java.time.Duration;

public class AlertsPage extends BasePage {

    @FindBy(id = "alert")
    private WebElement alert;

    @FindBy(id = "empty-alert")
    private WebElement emptyAlert;

    @FindBy(id = "confirm")
    private WebElement confirmDismissAlert;

    @FindBy(tagName = "h1")
    private WebElement textTitle;

    public AlertsPage(WebDriver driver){
        super(driver);
    }

    public void waitAlert(int seconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public Alert open(WebElement element){
        element.click();
        waitAlert(2);
        return driver.switchTo().alert();
    }

    public Alert openAlert(){
        return open(alert);
    }

    public Alert openEmptyAlert(){
        return open(emptyAlert);
    }

    public Alert openDismissConfirmAlert(){
        return open(confirmDismissAlert);
    }

    public String getTextTitle(){
        return textTitle.getText();
    }
}
