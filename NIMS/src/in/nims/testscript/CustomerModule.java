package in.nims.testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import in.nims.generic.BaseClass;

@Listeners(in.nims.generic.ListenerImplementation.class)
public class CustomerModule extends BaseClass {
	@Test
	public void testCreateCustomer(){
		Reporter.log("testCreateCustomer",true);
		//Assert.fail();
	}
}