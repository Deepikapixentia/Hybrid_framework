package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GAdmin_HomePage extends BasePage {

	  @FindBy(xpath = "//div[contains(@class,'card purple')]//button")
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

	public void usersTabView() {		
		wait.until(ExpectedConditions.elementToBeClickable(userstabviewbutton));			
	//	click(userstabviewbutton);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", userstabviewbutton);
	}

	public void learningJourneyTabView() {
		wait.until(ExpectedConditions.elementToBeClickable(learnjourneytabviewbutton));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", learnjourneytabviewbutton);
	}

	public void gamificationTabView() {
		wait.until(ExpectedConditions.elementToBeClickable(gamificationtabviewbutton));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", gamificationtabviewbutton);
	}

	public void assessmentsTabView() {
		wait.until(ExpectedConditions.elementToBeClickable(assessementtabviewbutton));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", assessementtabviewbutton);
	}


	public void clickOnHomeTab() {
	
		if (!getTitle().equalsIgnoreCase("Home")) {
			wait.until(ExpectedConditions.elementToBeClickable(homebutton));
			
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// It is safer to use JS click here too if the menu is finicky
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", homebutton);
		}
	}

	public void getTotalOrgsInApplication() {
		getText(totalorgscount);
	}

	public void getTotalUsersInApplication() {
		getText(totaluserscount);
	}

	public void getTotalLearnJourneysInApplication() {
		getText(totallearnjourneyscount);
		System.out.println(totallearnjourneyscount.getText());
	}

}
