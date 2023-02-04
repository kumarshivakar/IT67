package in.nims.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskListPage {
	@FindBy(xpath="//div[text()='Add New']")
	private WebElement addnewbtn;
	
	@FindBy(xpath="//div[text()='+ New Customer']")
	private WebElement newcustomerbtn;
	
	@FindBy(xpath="//input[@placeholder='Enter Customer Name' and @ class='inputFieldWithPlaceholder newNameField inputNameField']")
	private WebElement entrcustomernm;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
	private WebElement entrcustomerdesc;
	
	@FindBy(xpath="//div[@class='emptySelection']")
	private WebElement selectcstmr;
	
	@FindBy(xpath="(//div[@class='inputPlaceholder'])[16]/input")
	private WebElement cstmrclk;
	
	@FindBy(xpath="//div/span[contains(text(),'Our')]")
	private WebElement selectourcompny;
	
	@FindBy(xpath="//div[text()='Create Customer']")
	private WebElement createcstmrbtn;
	
	@FindBy(xpath="(//div[text()='HDFC-001'])[1]")
	private WebElement hdfc;
	
	@FindBy(xpath="//div[text()='HDFC-001']/../div[2]")
	private WebElement editbtn;
	
	@FindBy(xpath="(//div[@class='action'])[1]")
	private WebElement actionbtn;
	
	@FindBy(xpath="(//div[text()='Delete'])[2]")
	private WebElement deletebtn;
	
	@FindBy(xpath="//span[text()='Delete permanently']")
	private WebElement deletepermanentlybtn;
	
	

	public TaskListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddnewbtn() {
		return addnewbtn;
	}

	public WebElement getNewcustomerbtn() {
		return newcustomerbtn;
	}

	public WebElement getEntrcustomernm() {
		return entrcustomernm;
	}

	public WebElement getEntrcustomerdesc() {
		return entrcustomerdesc;
	}

	public WebElement getSelectcstmr() {
		return selectcstmr;
	}
	
	public WebElement getCstmrclk() {
		return cstmrclk;
	}

	public WebElement getSelectourcompny() {
		return selectourcompny;
	}

	public WebElement getCreatecstmrbtn() {
		return createcstmrbtn;
	}
	
	public WebElement getHdfc() {
		return hdfc;
	}
	
	public WebElement getEditbtn() {
		return editbtn;
	}

	public WebElement getActionbtn() {
		return actionbtn;
	}

	public WebElement getDeletebtn() {
		return deletebtn;
	}

	public WebElement getDeletepermanentlybtn() {
		return deletepermanentlybtn;
	}
}
