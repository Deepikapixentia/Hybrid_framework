package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GAdmin_HomePage extends BasePage {

	@FindBy(xpath = "//div[contains(@class,'card purple ng')]//child::button[text()='View']")
	WebElement userstabviewbutton;

	@FindBy(xpath = "//div[contains(@class,'card blue')]//child::button[text()='View']")
	WebElement learnjourneytabviewbutton;

	@FindBy(xpath = "//div[contains(@class,'card orange')]//child::button[text()='View']")
	WebElement gamificationtabviewbutton;

	@FindBy(xpath = "//div[contains(@class,'card dark')]//child::button[text()='View']")
	WebElement assessementtabviewbutton;

	@FindBy(xpath = "//div[contains(@class,'g-card-one')]//child::div[@class='count']")
	WebElement totalorgscount;

	@FindBy(xpath = "//div[contains(@class,'g-card-two')]//child::div[@class='count']")
	WebElement totaluserscount;

	@FindBy(xpath = "//div[contains(@class,'g-card-three')]//child::div[@class='count']")
	WebElement totallearnjourneyscount;

	@FindBy(xpath = "//a[contains(@href,'/Pixentia/GlobalAdmin/home') and text()=' Home']")
	WebElement homebutton;

	public GAdmin_HomePage() {
		super();
	}

	public void usersView() {
		click(userstabviewbutton);
	}

	public void clicOnHomeTab() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (!getTitle().equalsIgnoreCase("Home")) {
			wait.until(ExpectedConditions.elementToBeClickable(homebutton));
			
			click(homebutton);
		}
	}

	public void learningJourneyTabView() {
		click(learnjourneytabviewbutton);
	}

	public void gamificationTabView() {
		click(gamificationtabviewbutton);
	}

	public void assessmentsTabView() {
		click(assessementtabviewbutton);
	}

	public void getTotalOrgsInApplication() {
		getText(totalorgscount);
	}

	public void getTotalUsersInApplication() {
		getText(totaluserscount);
	}

	public void getTotalLearnJourneysInApplication() {
		getText(totaluserscount);
	}

}
