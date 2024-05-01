package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.page.BasePage;
import support.page.elements.WebFormPageCalendarElements;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class WebFormPage extends BasePage {

    private final WebFormPageCalendarElements calendarElement = new WebFormPageCalendarElements(navegador);

    private WebElement dayElement;


    public WebFormPage(WebDriver navegador) {
        super(navegador);
    }

    public void inputADateWithVisibleCalendar(String date) {
        calendarElement.datePickerTextBox.click();
        calendarElement.datePickerTextBox.sendKeys(date);
        calendarElement.datePickerTextBox.sendKeys(Keys.ESCAPE);
    }

    public void inputADateWithoutCalendar(String date) {
        calendarElement.datePickerTextBox.sendKeys(Keys.ESCAPE);
        calendarElement.datePickerTextBox.sendKeys(date);
        calendarElement.datePickerTextBox.sendKeys(Keys.ESCAPE);
    }

    public String getDateFromTextBox(){
        return calendarElement.datePickerTextBox.getAttribute("value");
    }

    public void pickADateInCalendar(LocalDate targetDate){
        String targetMonth = targetDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.getDefault());
        int targetYear = targetDate.getYear();

        calendarElement.datePickerTextBox.click();
        calendarElement.actualMonthYear.click();
        boolean sameYear = false;

        while (!sameYear){
            int actualYear = Integer.parseInt( calendarElement.selectedYear.getText() );
            if(targetYear > actualYear) {
                calendarElement.nextYearButton.click();
            } else if (targetYear < actualYear) {
                calendarElement.prevYearButton.click();
            } else {
                sameYear = true;
            }
        }

        calendarElement.setMonthElement(targetMonth);
        calendarElement.monthElement.click();

        calendarElement.setDayElement(String.valueOf(targetDate.getDayOfMonth()));
        calendarElement.dayElement.click();
    }


}
