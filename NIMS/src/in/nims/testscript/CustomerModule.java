package in.nims.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
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
		Thread.sleep(5000);
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
		tlp.getActionbtn().click();
		tlp.getDeletebtn().click();
		tlp.getDeletepermanentlybtn().click();
	}
}