package CommonFuctions;

import org.openqa.selenium.WebDriver;

import OR.LoginPage;
import config.StartBrowser;
import wdcmds.ActionDriver;

public class CommonFuct {
	private WebDriver driver;
	private ActionDriver aDriver;

	
	public CommonFuct(){
		driver=StartBrowser.driver;
		aDriver=new ActionDriver();
	}
	
	public void login() throws Exception {
		StartBrowser.childTest=StartBrowser.parentTest.createNode("Login To Application");
		aDriver.navigateApplication("https://www.linkedin.com/m/login/");
		aDriver.type(LoginPage.username, "username", "UserName");
		aDriver.type(LoginPage.password, "password", "Password");
		aDriver.click(LoginPage.submit,"Submit");
	}
}
