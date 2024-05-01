package support.page.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.page.BasePage;

public class WebFormPageCalendarElements extends BasePage {
    
    @FindBy(name = "my-date")
    public WebElement datePickerTextBox;

    @FindBy(css = ".datepicker-days th.datepicker-switch")
    public WebElement actualMonthYear;

    @FindBy(css = ".datepicker-months .datepicker-switch")
    public WebElement selectedYear;

    @FindBy(css = ".datepicker-months th.next")
    public WebElement nextYearButton;

    @FindBy(css = ".datepicker-months th.prev")
    public WebElement prevYearButton;

    public WebElement monthElement;

    public WebElement dayElement;

    public WebFormPageCalendarElements(WebDriver navegador) {
        super(navegador);
    }

    public void setMonthElement(String month) {
        String xpath = "//div[@class='datepicker-months']//span[@class='month'][text()='" + month + "']";
        this.monthElement = navegador.findElement(By.xpath(xpath));
    }

    public void setDayElement(String day) {
        String xpath = "//div[@class='datepicker-days']/table[@class='table-condensed']/tbody//td[@class='day'][text()='" + day + "']";
        this.dayElement = navegador.findElement(By.xpath(xpath));
    }

}
