package scripts;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.WebFormPage;
import support.utils.DateUtil;
import support.utils.DriverUtil;

import java.time.LocalDate;
import java.time.Month;

import static support.constants.UrlEnum.SELENIUM_WEB_FORM_PAGE;

public class CalendarTest {

	private WebDriver driver;

	private WebFormPage calendarPage;

	@BeforeEach
	public void setup() {
		driver = DriverUtil.setupChromeDriverWithWaiting(SELENIUM_WEB_FORM_PAGE.getUrl());
		calendarPage = new WebFormPage(driver);
	}

	@Test
	@DisplayName("Write a valid date in the calendar text box.")
	public void writeAValidDateInTheDateInput() {
		LocalDate date = LocalDate.of(2026, Month.SEPTEMBER, 8);
		String expectedDate = DateUtil.convertDateToStringFormatNumbersMonthDayYear(date);

		calendarPage.inputADateWithVisibleCalendar(expectedDate);
		String actualDate = calendarPage.getDateFromTextBox();

		Assertions.assertEquals(expectedDate, actualDate);
	}

	@Test
	@DisplayName("Write an invalid date in the calendar text box must replace to actual date.")
	public void writeAnInvalidDateInTheDateInputAndMustReplaceToCorrectDate() {
		LocalDate today = LocalDate.now();
		String expectedDate = DateUtil.convertDateToStringFormatNumbersMonthDayYear(today);

		calendarPage.inputADateWithVisibleCalendar("ABCDFG");
		String actualDate = calendarPage.getDateFromTextBox();

		Assertions.assertEquals(expectedDate, actualDate);
	}

	@Test
	@DisplayName("Write an invalid date in the calendar text box will not replace to actual date.")
	public void writeAnInvalidDateInTheDateInput() {
		String invalidDate = "ABCDFG";
		calendarPage.inputADateWithoutCalendar(invalidDate);
		String actualDate = calendarPage.getDateFromTextBox();

		Assertions.assertEquals(invalidDate, actualDate);
	}

	@Test
	@DisplayName("Pick a future date in the calendar.")
	public void pickAFutureDateInTheCalendar() {
		LocalDate date = LocalDate.of(2026, Month.SEPTEMBER, 8);
		String expectedDate = DateUtil.convertDateToStringFormatNumbersMonthDayYear(date);

		calendarPage.pickADateInCalendar(date);
		String resultDate = calendarPage.getDateFromTextBox();

		Assertions.assertEquals(expectedDate, resultDate);
	}

	@Test
	@DisplayName("Pick a past date in the calendar.")
	public void pickAPastDateInTheCalendar() {
		LocalDate date = LocalDate.of(2000, Month.MARCH, 8);
		String expectedDate = DateUtil.convertDateToStringFormatNumbersMonthDayYear(date);

		calendarPage.pickADateInCalendar(date);
		String resultDate = calendarPage.getDateFromTextBox();

		Assertions.assertEquals(expectedDate, resultDate);
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

}