import java.time.Duration;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class SearchByBrandsTest {
  WebDriver driver;
  JavascriptExecutor js;
  WebDriverWait wait;

  @Before
  public void setUp() {
    System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver"); // point to chrome driver
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(15));
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void brandsAlphabeticalPath() throws InterruptedException {
    driver.get("https://www.bestbuy.ca/en-ca");
    driver.manage().window().maximize();
    driver.findElement(By.cssSelector("li:nth-child(2) button > span")).click();
    try {
      driver.findElement(By.linkText("JBL")).click(); // check point after new page
      Thread.sleep(2000); 
    } catch (NoSuchElementException e) {
      fail("Cannot find JBL link.");
    }
    js.executeScript("window.scrollTo(0,222)");
    try {
      Thread.sleep(5000);      
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".col-xs-12_198le:nth-child(6) .productItemName_3IZ3c")));
      driver.findElement(By.cssSelector(".col-xs-12_198le:nth-child(6) .productItemName_3IZ3c")).click();
      Thread.sleep(1000);
    } catch (NoSuchElementException e) {
      fail("Cannot find JBL Flip 5");
    }
    
    js.executeScript("window.scrollTo(0,0)");
    js.executeScript("window.scrollTo(0,0)");
  }
  
  @Test
  public void brandsIdealPath() throws InterruptedException {
    driver.get("https://www.bestbuy.ca/en-ca");
    driver.manage().window().maximize();
    driver.findElement(By.cssSelector("li:nth-child(2) button > .white_3qh7k")).click();
    try {
      driver.findElement(By.linkText("JBL")).click();
      Thread.sleep(3000);
    } catch (NoSuchElementException e) {
      fail("Could not find JBL.");
    }
    
    try {
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".col-xs-12_198le:nth-child(6) .productItemName_3IZ3c")));
      js.executeScript("window.scrollTo(0,500)");
      driver.findElement(By.cssSelector(".col-xs-12_198le:nth-child(6) .productItemName_3IZ3c")).click();
      Thread.sleep(1000);
    } catch (NoSuchElementException e) {
      fail("Could not find JBL Flip 5.");
    }
  }

}
