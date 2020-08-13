package Script;

import org.testng.annotations.Test;

import CommonFuctions.CommonFuct;
import config.StartBrowser;

public class TestCase1 extends StartBrowser {
	
	@Test
	public void Login_logout() throws Exception {
		CommonFuct cfs=new CommonFuct();
		cfs.login();
	}
	
	@Test
	public void Delete() throws Exception {
	System.out.println("TestCase2");
	}

}
