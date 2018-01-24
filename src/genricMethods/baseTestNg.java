package genricMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class baseTestNg implements Iconstants {
	public WebDriver driver;
	static {
		System.setProperty(CHROME_KEY, CHROME_PATH);
		System.setProperty(GECKO_KEY, GECKO_PATH);
		System.setProperty(IEKEY, IE_PATH);
	}

	@BeforeMethod
	public void openBrowser() {
		driver = new ChromeDriver();
		String URL = Genric_Methods.Get_Property("URL");
		driver.get(URL);
		String sITO = Genric_Methods.Get_Property("ITO");
		long ITO = Long.parseLong(sITO);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void closeBrowser(ITestResult res) {
		String testName = res.getName();
		int result = res.getStatus();
		if (result == 2) {
			Genric_Methods.clickScreenshot(SCREENSHOT_PATH, testName, driver);
		}
		driver.quit();
	}

}
