package scripts;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.WebFormPage;
import support.utils.DateUtil;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;

public class CalendarTest {

	WebDriver driver;
	WebFormPage calendarPage;

	@BeforeEach
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.get("https://www.selenium.dev/selenium/web/web-form.html");

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
		LocalDate date = LocalDate.of(1990, Month.MARCH, 8);
		String expectedDate = DateUtil.convertDateToStringFormatNumbersMonthDayYear(date);

		calendarPage.pickADateInCalendar(date);
		String resultDate = calendarPage.getDateFromTextBox();

		Assertions.assertEquals(expectedDate, resultDate);
	}

	@AfterEach
	public void teardown() {
		driver.quit();
	}

}