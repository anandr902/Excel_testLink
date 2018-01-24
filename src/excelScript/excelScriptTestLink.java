package excelScript;

import org.testng.annotations.Test;

import excelUploadTestLinkPage.testLinkPage;
import genricMethods.Genric_Methods;
import genricMethods.baseTestNg;

public class excelScriptTestLink extends baseTestNg {

	@Test
	public void uploadExceltoTestLink() throws InterruptedException {

		testLinkPage t = new testLinkPage(driver);
		t.enterLoginid(Genric_Methods.Get_Property("LoginIdTestLink"));
		t.enterPassword(Genric_Methods.Get_Property("PasswordTestLink"));
		t.clickLogin();
		t.switchTotitleFrame(driver);
		t.selectProjectValue(Genric_Methods.Get_Property("TestProject"), driver);
		t.switchToMainPage(driver);
		t.switchToMainFrame(driver);
		t.selectTestPlanValue(Genric_Methods.Get_Property("TestPlan"), driver);
		t.clickOnExecuteTest();
		t.switchToTreeFrame(driver);
		t.clickOnProject(driver);
		t.clickOnNotRunExcel(driver, PHOTO_PATH);
		
		

	}

}
