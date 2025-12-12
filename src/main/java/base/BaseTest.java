package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import exceptions.InValidBrowserException;
import utils.ExtentManager;

public class BaseTest {

	public static FileInputStream fis;
	public static Properties conprop;
	public static WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest test;

	@BeforeTest
	public void fileConfiuration() {

		try {
			// CHANGE 1: Use System.getProperty("user.dir") for dynamic path
			String projectPath = System.getProperty("user.dir");
			fis = new FileInputStream(projectPath + "\\Properties\\configurationfiles\\configuration.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		conprop = new Properties();
		try {
			conprop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		reports=ExtentManager.getreports();// get reports is method name of extent reports class
	}

	@BeforeMethod
	public void browserSetup(Method methodname) {
		
	   test=reports.createTest(methodname.getName());

		switch (conprop.getProperty("browser")) {
		case "chrome":
			// CHANGE 2: Add ChromeOptions to force screen size in Jenkins
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--start-maximized"); 
			options.addArguments("--window-size=1920,1080"); // Crucial for Jenkins/System User
			
			driver = new ChromeDriver(options);
			test.log(Status.INFO, conprop.getProperty("browser") +" browser is selected");
			break;
			
		case "firefox":
			driver = new FirefoxDriver();
			test.log(Status.INFO, conprop.getProperty("browser") +" browser is selected");
			break;
		case "edge":
			driver = new EdgeDriver();
			test.log(Status.INFO, conprop.getProperty("browser") +" browser is selected");
			break;

		default:
			throw new InValidBrowserException();			
		}

		driver.get(conprop.getProperty("URL"));
		
		// This line is good, but the ChromeOptions above guarantees the size even if this fails
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}

	@AfterMethod
	public void tearDown() {
		// It is safer to check if driver is null before quitting
		if (driver != null) {
			driver.quit();
		}
	}
	
	@AfterTest
	public void reportsFlush() {
		reports.flush();
	}
}
