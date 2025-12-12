package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StepperPage extends BasePage {

	public StepperPage() {
		super();
	}

	@FindBy(xpath = "//input[@formcontrolname='firstName']")
	WebElement firstnamefield;

	@FindBy(xpath = "//input[@formcontrolname='lastName']")
	WebElement lastnamefield;

	@FindBy(xpath = "//input[@formcontrolname='jobTitle' or @placeholder='Search Job Titles']")
	WebElement SelectJobTitle;

	@FindBy(xpath = "//div[@id='mat-autocomplete-0']")
	WebElement jobcategorydropdown;

	@FindBy(xpath = "//button[@type='submit']")
	
	WebElement Detailsnextbutton;

	@FindBy(xpath = "//input[@formcontrolname='interests']")
	WebElement SelectInterests;

	@FindBy(xpath = "//div[@id='mat-autocomplete-1']")
	WebElement interestsdropdown;

	@FindBy(xpath = "(//button[text()=' Add '])[1]")
	WebElement interestsaddbutton;

	@FindBy(xpath = "(//button[text()='Back'])[1]")
	WebElement interestsbackbutton;

	@FindBy(xpath = "//button[text()=' Skip']")
	WebElement interestsskipbutton;

	@FindBy(xpath = "(//button[text()=' Next' and @class='nxtBtn'])[1]")
	WebElement interestsnextbutton;

	@FindBy(xpath = "//input[@formcontrolname='skills']")
	WebElement SelectSkills;

	@FindBy(xpath = "//div[@id='mat-autocomplete-2']")
	WebElement skillsdropdown;

	@FindBy(xpath = "//span[@class='mat-mdc-select-placeholder mat-mdc-select-min-line']")
	WebElement skilllevel;
	// div[@id='mat-select-value-1']/child::span[@class='mat-mdc-select-placeholder mat-mdc-select-min-line']

	@FindBy(xpath = "//div[@id='mat-select-0-panel']")
	WebElement skillleveldropdown;

	@FindBy(xpath = "(//button[text()=' Add '])[2]")
	WebElement skilladdbutton;

	@FindBy(xpath = "(//button[text()='Back'])[2]")
	WebElement skillbackbutton;

	@FindBy(xpath = "(//button[text()=' Next' and @class='nxtBtn'])[2]")
	WebElement skillnextbutton;

	@FindBy(xpath = "(//button[@class='nxtBtn'])[3]")
	WebElement getstartedbutton;

	@FindBy(xpath = "//button[text()='Proceed']")
	WebElement preassessproceddbutton;

	// user details methods

	public void getFirstNameTexts(String firstname) {
		wait.until(ExpectedConditions.visibilityOf(firstnamefield));
		//attributeValueValidation(firstnamefield, firstname);
		validateInputTextUsingJS(firstnamefield, firstname);
	}

	public void getLastNameTexts(String lastname) {
		wait.until(ExpectedConditions.visibilityOf(lastnamefield));
		validateInputTextUsingJS(lastnamefield, lastname);
	}

	public String getCurrentJobTitle(String jobname) {
		wait.until(ExpectedConditions.visibilityOf(SelectJobTitle));
		return validateInputTextUsingJS(SelectJobTitle, jobname);
	}

	public void selectJobCategoryFromDropdown(String jobcategoryname) {
		wait.until(ExpectedConditions.visibilityOf(SelectJobTitle));
		type(SelectJobTitle, jobcategoryname);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String optionXpath = "//mat-option[contains(@class,'mat-mdc-option mdc-list-item')" + "and normalize-space()='"
				+ jobcategoryname + "']";

		WebElement jobTitleOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(optionXpath)));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(jobTitleOption);
	}

	public void clickOnDetailsNextButton() {
		click(Detailsnextbutton);
	}

	// interests methods

	public void clickOnInterestField() {
		click(SelectInterests);
	}

	public void selectInterestFromDropdown(String interestname) {
		wait.until(ExpectedConditions.visibilityOf(SelectInterests));
		type(SelectInterests, interestname);

		String optionXpath = "//mat-option[contains(@class,'mat-mdc-option mdc-list-item')" + "and normalize-space()='"
				+ interestname + "']";
		WebElement interestoption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(optionXpath)));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(interestoption);
	}

	public void clickInterestAddButton() {
		click(interestsaddbutton);
	}

	public void clickInterestSkipButton() {
		click(interestsskipbutton);
	}

	public void clickInterestNextButton() {
		click(interestsnextbutton);
	}

	public void clickInterestBackButton() {
		click(interestsbackbutton);
	}

	// skill methods

	public void clickOnSkillsField() {
		click(SelectSkills);
	}

	public void selectSkillFromDropdown(String skillname) {
		type(SelectSkills, skillname);
	//	String optionXpath = "//mat-option[contains(@class,'mat-mdc-option mdc-list-item')" + "and normalize-space()='"
	//			+skillname + "']";
		
		
				String optionXpath = "//span[contains(@class,'mdc-list-item__primary-text')" + "and normalize-space()='"
						+skillname + "']";

		WebElement skilloption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(optionXpath)));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(skilloption);
	}

	public void selectSkillLevelFromDropdown(String skilllevelname) {
		click(skilllevel);

		String levelXpath = "//mat-option[contains(@class,'mat-mdc-option mdc-list-item')"+ "and normalize-space()='"
				+ skilllevelname + "']";

		WebElement leveloption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(levelXpath)));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(leveloption);
	}

	public void clickOnSkillAddButton() {
		click(skilladdbutton);
	}

	public void clickOnSkillbackButton() {
		click(skillbackbutton);
	}

	public void clickOnSkillNextButton() {
		click(skillnextbutton);
	}

	public void clickOnGetStartedButton() {
		click(getstartedbutton);
	}

}
