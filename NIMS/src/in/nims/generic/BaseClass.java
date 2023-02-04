package in.nims.generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import in.nims.pom.HomePage;
import in.nims.pom.LoginPage;

public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static WebDriver driver;

	@BeforeTest
	public void openBrowser()throws IOException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	@BeforeMethod
	public void login()throws IOException {
		FileLib fl=new FileLib();
		String url=fl.getPropertyData("url");
		driver.get(url);
		LoginPage lp=new LoginPage(driver);
		String un=fl.getPropertyData("username");
		String pw=fl.getPropertyData("password");
		lp.setLogin(un, pw);		
	}
	@AfterMethod
	public void logout(){
		HomePage hp=new HomePage(driver);
		hp.setLogout();
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}