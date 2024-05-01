package scripts;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.WebFormPage;
import support.constants.UrlEnum;
import support.utils.DriverUtil;

public class RadioButtonTest {

	private WebDriver driver;

	private WebFormPage page;

	@BeforeEach
	public void setup() {
		driver = DriverUtil.setupChromeDriverWithWaiting(UrlEnum.SELENIUM_WEB_FORM_PAGE.getUrl());
		page = new WebFormPage(driver);
	}

	@Test
	@DisplayName("radio button is not enabled.")
	public void radioButtonNotEnabled() {
		Assertions.assertFalse(page.isRadioButtonSelected());
	}

	@Test
	@DisplayName("radio button can be enabled.")
	public void radioButtonCanBeEnabled() {
		Assertions.assertFalse(page.isRadioButtonSelected());
		page.enableRadioButton();
		Assertions.assertTrue(page.isRadioButtonSelected());
	}

	@AfterEach
	public void teardown() {
		driver.quit();
	}

}