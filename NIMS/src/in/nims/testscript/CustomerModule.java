package in.nims.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import in.nims.generic.BaseClass;
import in.nims.generic.FileLib;
import in.nims.pom.HomePage;
import in.nims.pom.TaskListPage;

@Listeners(in.nims.generic.ListenerImplementation.class)
public class CustomerModule extends BaseClass {
	@Test
	public void testCreateCustomer() throws EncryptedDocumentException, IOException, InterruptedException{
		Reporter.log("testCreateCustomer",true);
		HomePage hp=new HomePage(driver);
		hp.setTask();
		TaskListPage tlp=new TaskListPage(driver);
		tlp.getAddnewbtn().click();
		tlp.getNewcustomerbtn().click();
		FileLib flb=new FileLib();
		String custnm=flb.getExcelData("CreateCustomer", 1, 1);
		tlp.getEntrcustomernm().sendKeys(custnm);
		String custdscp=flb.getExcelData("CreateCustomer", 1, 2);
		tlp.getEntrcustomerdesc().sendKeys(custdscp);
		tlp.getSelectcstmr().click();
		tlp.getCstmrclk().sendKeys("our");
		tlp.getSelectourcompny().click();
		tlp.getCreatecstmrbtn().click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(tlp.getActualcustomer(),custnm));
		String actualText = tlp.getActualcustomer().getText();
		Assert.assertEquals(actualText, custnm);
		//Assert.fail();
	}
	
	@Test
	public void testDeleteCustomer() {
		Reporter.log("testDeleteCustomer",true);
		HomePage hp=new HomePage(driver);
		hp.setTask();
		TaskListPage tlp=new TaskListPage(driver);
//		tlp.getHdfc().click();
		tlp.getEditbtn().click();
		int i=0;
		while(i<100) {
				try {
					tlp.getActionbtn().click();
					break;
				}
				catch(ElementClickInterceptedException e) {
					i++;
				}
		}
		tlp.getDeletebtn().click();
		tlp.getDeletepermanentlybtn().click();
	}
}