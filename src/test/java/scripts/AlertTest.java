package scripts;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import pages.AlertsPage;
import support.utils.DriverUtil;

import static support.constants.UrlEnum.SELENIUM_ALERTS_PAGE;

public class AlertTest {

    private WebDriver driver;
    private AlertsPage alertsPage;

    @BeforeEach
    public void setUp(){
        driver = DriverUtil.setupChromeDriverWithWaiting(SELENIUM_ALERTS_PAGE.getUrl());
        alertsPage = new AlertsPage(driver);
    }

    @Test
    @DisplayName("Check the text in the alert.")
    public void checkAlertText() throws InterruptedException {
        Alert alert = alertsPage.openAlert();
        Assertions.assertEquals("cheese", alert.getText());
    }

    @Test
    @DisplayName("Check the alert doesn't have a text.")
    public void checkAlertWithoutText() {
        Alert alert = alertsPage.openEmptyAlert();
        String alertText = alert.getText();
        Assertions.assertEquals("", alertText);
    }

    @Test
    @DisplayName("Dismiss an alert.")
    public void dismissAlert(){
        Alert alert = alertsPage.openDismissConfirmAlert();
        Assertions.assertEquals("Are you sure?", alert.getText());
        alert.dismiss();
        Assertions.assertEquals("Testing Alerts and Stuff", alertsPage.getTextTitle());
    }

    @AfterEach
    public void tearDown(){ driver.quit(); }
}
