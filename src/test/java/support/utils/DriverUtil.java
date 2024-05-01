package support.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverUtil {

    private static final int MAX_SECONDS_WAIT = 3;

    public static WebDriver setupChromeDriverWithWaiting(String url){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(MAX_SECONDS_WAIT));
        driver.get(url);
        return driver;
    }
}
