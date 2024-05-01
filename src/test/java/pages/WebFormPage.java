package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.page.BasePage;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class WebFormPage extends BasePage {

    @FindBy(name = "my-date")
    private WebElement datePickerTextBox;

    @FindBy(css = ".datepicker-days th.datepicker-switch")
    private WebElement actualMonthYear;

    @FindBy(css = ".datepicker-months .datepicker-switch")
    private WebElement selectedYear;

    @FindBy(css = ".datepicker-months th.next")
    private WebElement nextYearButton;

    @FindBy(css = ".datepicker-months th.prev")
    private WebElement prevYearButton;

    @FindBy(css = ".datepicker-days th.next")
    private WebElement nextMonthButton;

    @FindBy(css = ".datepicker-days th.prev")
    private WebElement prevMonthButton;

    private WebElement monthElement;

    private WebElement dayElement;


    public WebFormPage(WebDriver navegador) {
        super(navegador);
    }

    public void inputADateWithVisibleCalendar(String date) {
        datePickerTextBox.click();
        datePickerTextBox.sendKeys(date);
        datePickerTextBox.sendKeys(Keys.ESCAPE);
    }

    public void inputADateWithoutCalendar(String date) {
        datePickerTextBox.sendKeys(Keys.ESCAPE);
        datePickerTextBox.sendKeys(date);
        datePickerTextBox.sendKeys(Keys.ESCAPE);
    }

    public String getDateFromTextBox(){
        return datePickerTextBox.getAttribute("value");
    }

    public void pickADateInCalendar(LocalDate targetDate){
        String targetMonth = targetDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.getDefault());
        int targetYear = targetDate.getYear();

        datePickerTextBox.click();
        actualMonthYear.click();
        boolean sameYear = false;

        while (!sameYear){
            int actualYear = Integer.parseInt( selectedYear.getText() );
            if(targetYear > actualYear) {
                nextYearButton.click();
            } else if (targetYear < actualYear) {
                prevYearButton.click();
            } else {
                sameYear = true;
            }
        }

        setMonthElement(targetMonth);
        monthElement.click();

        setDayElement(String.valueOf(targetDate.getDayOfMonth()));
        dayElement.click();
    }

    private void setMonthElement(String month) {
        String xpath = "//div[@class='datepicker-months']//span[@class='month'][text()='" + month + "']";
        this.monthElement = navegador.findElement(By.xpath(xpath));
    }

    private void setDayElement(String day) {
        String xpath = "//div[@class='datepicker-days']/table[@class='table-condensed']/tbody//td[@class='day'][text()='" + day + "']";
        this.dayElement = navegador.findElement(By.xpath(xpath));
    }
}
