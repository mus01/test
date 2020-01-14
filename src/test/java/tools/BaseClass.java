package tools;


import java.util.regex.Pattern;
import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.io.FileUtils;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import pom.Home_Page;
import pom.Login_Page;



  
public class BaseClass {
	  public static  WebDriver driver;
	  public static  String baseUrl;
	  protected boolean acceptNextAlert = true;
	  public StringBuffer verificationErrors = new StringBuffer();
	  protected String vUserName = "TesterSelenium4";
	  protected String vPassword = "selenium4";
	  @BeforeClass
	  public static void setUp() throws Exception {
	       
	     System.out.println("Chrome");     
	     System.setProperty("webdriver.chrome.driver","C://SeleniumLibrary/v78/chromedriver.exe");
	     driver = new ChromeDriver();
	    
	    baseUrl = "http://4testautomation.com/VS2010Test";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  
	protected void verificationPoint_Text(String expectedValue, String obtainedValue) {
		try {
			assertEquals(expectedValue, obtainedValue);
		} catch (Error e) {
			verificationErrors.append("\n" + e.toString());
		}
	}
	  
	  
	  @After
	  public  void Verification() throws Exception {    
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  
	  @AfterClass
	  public static void tearDown() throws Exception {
	    driver.quit();
	  }

	  protected boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  protected boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  protected String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	  

public static void waitForPageCompleteLoad(WebDriver driver) {

  ExpectedCondition<Boolean> pageLoadCondition = new
  ExpectedCondition<Boolean>() {
  public Boolean apply(WebDriver driver) {
  return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
  }
  };
  WebDriverWait wait = new WebDriverWait(driver, 30);
  wait.until(pageLoadCondition);

  }
  
}
