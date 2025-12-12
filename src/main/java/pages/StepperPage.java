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
	    // 1. Type and wait
	    wait.until(ExpectedConditions.visibilityOf(SelectJobTitle));
	    type(SelectJobTitle, jobcategoryname);

	    // 2. Small static wait for animation
	    try { Thread.sleep(2000); } catch (InterruptedException e) {}

	    String optionXpath = "//mat-option[contains(@class,'mat-mdc-option mdc-list-item') and normalize-space()='" + jobcategoryname + "']";

	    // 3. Retry Logic: Try 3 times to find and click
	    for(int i=0; i<3; i++){
	        try{
	            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath)));
	            option.click();
	            break; // If click works, exit loop
	        } catch(org.openqa.selenium.StaleElementReferenceException ex){
	            // If failed, wait 1 second and try again
	            try { Thread.sleep(1000); } catch (InterruptedException e) {}
	        }
	    }
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

	    // 1. Wait for list to filter
	    try { Thread.sleep(2000); } catch (InterruptedException e) {}

	    String optionXpath = "//mat-option[contains(@class,'mat-mdc-option mdc-list-item')" + "and normalize-space()='"
	            + interestname + "']";

	    // 2. Retry Logic
	    for(int i=0; i<3; i++){
	        try{
	            WebElement interestoption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath)));
	            interestoption.click();
	            break; 
	        } catch(org.openqa.selenium.StaleElementReferenceException ex){
	            try { Thread.sleep(1000); } catch (InterruptedException e) {}
	        }
	    }
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
	    
	    // 1. Wait for list to filter
	    try { Thread.sleep(2000); } catch (InterruptedException e) {}

	    // Note: I used the XPath from your code that was active
	    String optionXpath = "//span[contains(@class,'mdc-list-item__primary-text')" + "and normalize-space()='"
	            + skillname + "']";

	    // 2. Retry Logic
	    for(int i=0; i<3; i++){
	        try{
	            WebElement skilloption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath)));
	            skilloption.click();
	            break; 
	        } catch(org.openqa.selenium.StaleElementReferenceException ex){
	            try { Thread.sleep(1000); } catch (InterruptedException e) {}
	        }
	    }
	}
	public void selectSkillLevelFromDropdown(String skilllevelname) {
	    click(skilllevel);

	    // 1. Wait for menu to animate open
	    try { Thread.sleep(2000); } catch (InterruptedException e) {}

	    String levelXpath = "//mat-option[contains(@class,'mat-mdc-option mdc-list-item')"+ "and normalize-space()='"
	            + skilllevelname + "']";

	    // 2. Retry Logic
	    for(int i=0; i<3; i++){
	        try{
	            WebElement leveloption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(levelXpath)));
	            leveloption.click();
	            break; 
	        } catch(org.openqa.selenium.StaleElementReferenceException ex){
	            try { Thread.sleep(1000); } catch (InterruptedException e) {}
	        }
	    }
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
