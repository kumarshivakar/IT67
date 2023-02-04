package in.nims.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath="//div[text()='Tasks']")
	private WebElement taskbtn;
	
	@FindBy(id="logoutLink")
	private WebElement lgoutbtn;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void setTask() {
		
		taskbtn.click();
	}
	public void setLogout() {
		lgoutbtn.click();
	}

}
