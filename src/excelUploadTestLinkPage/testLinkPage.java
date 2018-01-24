package excelUploadTestLinkPage;

import java.io.File;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import genricMethods.Genric_Methods;

public class testLinkPage {
	public int n;
	int j = 2;
	public int sizee;
	String AtitleExcel = Genric_Methods.Get_cell_value("TestCases", j, 3);
	String formatPhoto = Genric_Methods.Get_Property("PhotoFormat");

	@FindBy(id = "login")
	private WebElement loginTextBox;

	@FindBy(name = "tl_password")
	private WebElement passwordTextBox;

	@FindBy(name = "login_submit")
	private WebElement loginBtn;

	@FindBy(name = "testproject")
	private WebElement selectProject;

	@FindBy(xpath = "//div[@class='chosen-container chosen-container-single']//span")
	private WebElement selectTestPlan;

	@FindBy(name = "titlebar")
	private WebElement titleFrame;

	@FindBy(name = "mainframe")
	private WebElement mainFrame;

	@FindBy(xpath = "//div[@class='chosen-search']/input")
	private WebElement testPlanTextBox;

	@FindBy(xpath = "//ul[@class='chosen-results']//li")
	private WebElement testPlanTextBoxclick;

	@FindBy(linkText = "Execute Tests")
	private WebElement executeTest;

	@FindBy(name = "treeframe")
	private WebElement treeFrame;

	@FindBy(name = "workframe")
	private WebElement workFrame;

	@FindBy(xpath = "//div[@class='x-tree-node-el x-unselectable x-tree-node-collapsed']")
	private WebElement projectClick;

	@FindBy(xpath = "//span[@unselectable='on']//span[@alt='Not Run'] | //span[@unselectable='on']//span[@alt='Failed']")
	private List<WebElement> notRunExcelBtn;

	@FindBy(xpath = "//td[@class='exec_tcstep_note']/textarea")
	private List<WebElement> exceutionNotesTextArea;

	@FindBy(xpath = "//tr//select")
	private List<WebElement> testStatus;

	@FindBy(xpath = "//input[@type='file']")
	private List<WebElement> photoUploadbtn;

	@FindBy(xpath = "//div[@class='resultBox']//select")
	private WebElement finalResultTestStatus;

	@FindBy(id = "execution_duration")
	private WebElement testExecutionTime;

	@FindBy(xpath = "//input[@value='Save execution']")
	private WebElement saveExecutionbtn;

	String sETO = Genric_Methods.Get_Property("ETO");
	long ETO = Long.parseLong(sETO);

	public testLinkPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterLoginid(String uname) {
		try {
			loginTextBox.sendKeys(uname);
		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();
		}

	}

	public void enterPassword(String pwd) {
		try {
			passwordTextBox.sendKeys(pwd);
		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();
		}
	}

	public void clickLogin() {
		try {
			loginBtn.click();
		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();
		}
	}

	public void selectProjectValue(String projectName, WebDriver driver) {

		Select s = new Select(selectProject);
		try {
			s.selectByVisibleText(projectName);
		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();
		}
	}

	public void selectTestPlanValue(String testplanName, WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, ETO);
		try {
			w.until(ExpectedConditions.visibilityOf(selectTestPlan));
			selectTestPlan.click();
			testPlanTextBox.sendKeys(testplanName);
			testPlanTextBoxclick.click();
		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();
		}
	}

	public void switchTotitleFrame(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, ETO);
		try {
			w.until(ExpectedConditions.visibilityOf(titleFrame));
			driver.switchTo().frame(titleFrame);
		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();
		}

	}

	public void switchToMainFrame(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, ETO);
		try {
			w.until(ExpectedConditions.visibilityOf(mainFrame));
			driver.switchTo().frame(mainFrame);
		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();
		}
	}

	public void switchToMainPage(WebDriver driver) {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();
		}
	}

	public void clickOnExecuteTest() {
		executeTest.click();
	}

	public void clickOnProject(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, ETO);
		Actions act = new Actions(driver);
		try {
			w.until(ExpectedConditions.visibilityOf(projectClick));

			act.moveToElement(projectClick);
			act.doubleClick().perform();
		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();
		}
	}

	public void switchToTreeFrame(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, ETO);
		try {
			w.until(ExpectedConditions.visibilityOf(treeFrame));
			driver.switchTo().frame(treeFrame);
		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();
		}
	}

	public void switchToWorkFrame(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, ETO);
		try {
			w.until(ExpectedConditions.visibilityOf(workFrame));
			driver.switchTo().frame(workFrame);
		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();
		}

	}

	public void clickOnNotRunExcel(WebDriver driver, String folder) {
		Actions act = new Actions(driver);
		n = exceutionNotesTextArea.size();
		sizee = notRunExcelBtn.size();
		String TicketNumber = Genric_Methods.Get_Property("TicketNumber");
		for (WebElement e : notRunExcelBtn) {
			String text = e.getText();
			if (text.contains(TicketNumber)) {
				act.moveToElement(e);
				e.click();
				switchToMainPage(driver);
				switchToMainFrame(driver);
				switchToWorkFrame(driver);
				enterDetailsOfTicket(driver, folder);
				break;
			}
		}
	}

	public void enterDetailsOfTicket(WebDriver driver, String folder) {
		int i = 2;
		int o = 2;
		int k = 2;
		int l = 2;
		for (WebElement exeText : exceutionNotesTextArea) {
			try {
				String excuetionNotes = Genric_Methods.Get_cell_value("TestCases", i, 12);
				exeText.sendKeys(excuetionNotes);
				i++;
			} catch (Exception e1) {
				e1.printStackTrace();
				Assert.fail();
			}
		}
		for (WebElement testRes : testStatus) {
			try {
				Select s = new Select(testRes);
				String statusTest = Genric_Methods.Get_cell_value("TestCases", o, 13);
				s.selectByVisibleText(statusTest);
				o++;

			} catch (Exception e1) {
				e1.printStackTrace();
				Assert.fail();
			}

		}
		String fileName = "";
		String path = "";
		File f = null;
		String[] spilterString = null;
		String ticketNumber = "";
		for (int z = 0; z < photoUploadbtn.size(); z++) {
			try {
				String WtitleExcel1 = AtitleExcel;
				WebElement upload = photoUploadbtn.get(z);
				spilterString = WtitleExcel1.split(":");
				ticketNumber = spilterString[1];
				fileName = String.valueOf(z + 1) + formatPhoto;
				path = folder + ticketNumber + "/" + fileName;
				f = new File(path);
				if (f.exists()) {
					String absPath = f.getAbsolutePath();
					upload.sendKeys(absPath);
				}

			} catch (Exception e1) {
				e1.printStackTrace();
				Assert.fail();
			}
		}
		switchToMainPage(driver);
		switchToMainFrame(driver);
		switchToWorkFrame(driver);
		Select s = new Select(finalResultTestStatus);
		try {

			String value = Genric_Methods.Get_cell_value("TestCases", k, 17);
			s.selectByVisibleText(value);

		} catch (Exception e2) {

			e2.printStackTrace();
			Assert.fail();
		}
		try {
			String value = Genric_Methods.Get_cell_value("TestCases", l, 18);
			testExecutionTime.sendKeys(value);
			Thread.sleep(10000);

		} catch (Exception e3) {

			e3.printStackTrace();
			Assert.fail();
		}
		saveExecutionbtn.click();

	}

}
