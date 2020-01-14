package automation;

import static org.junit.Assert.assertTrue;

import java.awt.List;
import java.util.Arrays;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import junit.framework.Assert;

public class TestAutoHero {
	@Test
	public void Search() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		RemoteWebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();

	    String baseUrl = "https://www.autohero.com/de/search/";
	    driver.get(baseUrl);
	    driver.findElement(By.xpath(".//*[text()='Erstzulassung ab']")).click();
	    driver.findElement(By.xpath("//*[@data-qa-selector='select']")).click();
	    driver.findElement(By.name("yearRange.min")).sendKeys("2015");
	    driver.findElement(By.name("sort")).sendKeys("Höchster Preis");
	    
	    // Verification
	    
	    String URL = driver.getCurrentUrl();
	    Assert.assertEquals(URL, "https://www.autohero.com/de/search/?sort=PRICE_DESC&yearMin=2015" );
	    
	    
	    driver.quit();
	}
	
	
}
