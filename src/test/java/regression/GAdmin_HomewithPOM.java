package regression;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.GAdmin_HomePage;
import pages.LoginPage;


public class GAdmin_HomewithPOM extends BaseTest  {
	
	@Test
	public void homePageRedirectionsvalidation() {
		
		LoginPage lg=new LoginPage();
		lg.usernamefield("bdatla@pixentia.com");
		lg.passwordfield("Test123$");
		lg.loginbutton();
		
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		GAdmin_HomePage gadminhomepage=	new GAdmin_HomePage();
		
		gadminhomepage.usersTabView();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		gadminhomepage.clickOnHomeTab();
		gadminhomepage.learningJourneyTabView();
		gadminhomepage.clickOnHomeTab();
		gadminhomepage.gamificationTabView();
		gadminhomepage.clickOnHomeTab();
		gadminhomepage.assessmentsTabView();
		gadminhomepage.clickOnHomeTab();
		
		gadminhomepage.getTotalUsersInApplication();
		gadminhomepage.getTotalOrgsInApplication();
		gadminhomepage.getTotalLearnJourneysInApplication();
	}

}
