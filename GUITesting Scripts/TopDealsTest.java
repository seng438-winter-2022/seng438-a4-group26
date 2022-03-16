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
import java.time.Duration;

public class TopDealsTest {
  WebDriver driver;
  JavascriptExecutor js;
  WebDriverWait wait;

  @Before
  public void setUp() {
    System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(15));
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void dealsByCategoryPath() throws InterruptedException {
    driver.get("https://www.bestbuy.ca/en-ca");
    driver.manage().window().maximize();

    try {
      driver.findElement(By.cssSelector(".contentContainer_3jS31:nth-child(4) .content_3Dbgg")).click();
      Thread.sleep(5000);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".slick-slide:nth-child(10) .col-xs-12_198le:nth-child(2)")));
      driver.findElement(By.cssSelector(".slick-slide:nth-child(10) .col-xs-12_198le:nth-child(2)")).click();    
    } catch (NoSuchElementException e) {
      fail("System could not find Deals box on home page.");
    }
    
    Thread.sleep(2000);
    driver.findElement(By.cssSelector(".slick-slide:nth-child(10) .col-xs-12_198le:nth-child(2)")).click();
    
    Thread.sleep(2000);
    driver.findElement(By.cssSelector(".slick-slide:nth-child(10) .col-xs-12_198le:nth-child(2)")).click();

    js.executeScript("window.scrollTo(0,93)");
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    try {
      driver.findElement(By.cssSelector(".col-xs-4_1EA1G:nth-child(2) .link_ldnKD")).click();
    } catch (NoSuchElementException e) {
      fail("Could not find category 'Smart Locks and Video Doorbells'.");//TODO: handle exception
    }
    js.executeScript("window.scrollTo(0,0)");
    try {
      driver.findElement(By.cssSelector(".col-xs-12_198le:nth-child(1) .productItemName_3IZ3c")).click();
    } catch (NoSuchElementException e) {
      fail("Could not find Google Nest Doorbell.");
    }
    js.executeScript("window.scrollTo(0,0)");
  }

  @Test
  public void dealsFullPath() throws InterruptedException {
    driver.get("https://www.bestbuy.ca/en-ca");
    driver.manage().window().maximize();
    driver.findElement(By.cssSelector("li:nth-child(3) button > span")).click();
    try {
      driver.findElement(By.cssSelector(".flyoutMenu_2DHKo:nth-child(3) .menuItem_2kIs9:nth-child(3) .menuItemText_1yd__")).click();
    } catch (NoSuchElementException e) {
      fail("Could not find Top Deals page from menu bar.");
    }
    Thread.sleep(3000);
    js.executeScript("window.scrollTo(0,5000)");
    Thread.sleep(3000);
    try {
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".button_1Yg9v > .content_3Dbgg")));
      driver.findElement(By.cssSelector(".button_1Yg9v > .content_3Dbgg")).click();
    } catch (NoSuchElementException e) {
      fail("Could not find/click 'Show More' button.");
    }
    js.executeScript("window.scrollTo(0,6324)");
    try {
      Thread.sleep(3000);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".col-xs-12_198le:nth-child(29) .productItemName_3IZ3c")));
      driver.findElement(By.cssSelector(".col-xs-12_198le:nth-child(29) .productItemName_3IZ3c")).click();
    } catch (NoSuchElementException e) {
      fail("Cannot find Google Nest Doorbell.");
    }
    js.executeScript("window.scrollTo(0,0)");
  }

  @Test
  public void dealsIdealPath() throws InterruptedException {
    driver.get("https://www.bestbuy.ca/en-ca");
    driver.manage().window().maximize();
    {
      WebElement element = driver.findElement(By.cssSelector("li:nth-child(3) button > span"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector("li:nth-child(3) button > span")).click();
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    try {
      driver.findElement(By.cssSelector(".flyoutMenu_2DHKo:nth-child(3) .menuItem_2kIs9:nth-child(3) .menuItemText_1yd__")).click();
    } catch (NoSuchElementException e) {
      fail("Cannot find 'Top Deals' in menu.");
    }
    Thread.sleep(1000);
    js.executeScript("window.scrollTo(0,1477)");
    Thread.sleep(3000);
    try {
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".rowSkuList_22-Vn > .productItemContainer_1KkmO:nth-child(8) .truncate_gQkhK")));
      driver.findElement(By.cssSelector(".rowSkuList_22-Vn > .productItemContainer_1KkmO:nth-child(8) .truncate_gQkhK")).click();
    } catch (NoSuchElementException e) {
      fail("Cannot find Google Nest Doorbell.");
    }
    js.executeScript("window.scrollTo(0,0)");
  }

  @Test
  public void dealsPromotionPath() throws InterruptedException {
    driver.get("https://www.bestbuy.ca/en-ca");
    driver.manage().window().maximize();
    try {
      driver.findElement(By.cssSelector(".contentContainer_3jS31:nth-child(3) .content_3Dbgg")).click();
      Thread.sleep(2000);
    } catch (NoSuchElementException e) {
      fail("Could not find Top Deals box on home page.");
    }
    js.executeScript("window.scrollTo(0,80)");
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    js.executeScript("window.scrollTo(0,778)");
    js.executeScript("window.scrollTo(0,1415)");
    try {
      Thread.sleep(2000);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".rowSkuList_22-Vn > .productItemContainer_1KkmO:nth-child(8) .truncate_gQkhK")));
      driver.findElement(By.cssSelector(".rowSkuList_22-Vn > .productItemContainer_1KkmO:nth-child(8) .truncate_gQkhK")).click();
    } catch (NoSuchElementException e) {
      fail("Could not find Google Nest Doorbell.");
    }
    js.executeScript("window.scrollTo(0,0)");
  }

  @Test
  public void dealsSimpleDealPath() throws InterruptedException {
    driver.get("https://www.bestbuy.ca/en-ca");
    driver.manage().window().maximize();
    try {
      driver.findElement(By.cssSelector(".contentContainer_3jS31:nth-child(4) .content_3Dbgg")).click();
      Thread.sleep(2000);
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".slick-slide:nth-child(10) .col-xs-12_198le:nth-child(2)")));
      driver.findElement(By.cssSelector(".slick-slide:nth-child(10) .col-xs-12_198le:nth-child(2)")).click();
      Thread.sleep(2000);
      // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".slick-slide:nth-child(10) .col-xs-12_198le:nth-child(2)")));
      // driver.findElement(By.cssSelector(".slick-slide:nth-child(10) .col-xs-12_198le:nth-child(2)")).click();
    } catch (NoSuchElementException e) {
      fail("Cannot find Deals box on home page.");
    }

    try {
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".slick-slide:nth-child(7) .truncate_gQkhK:nth-child(1)")));
      driver.findElement(By.cssSelector(".slick-slide:nth-child(7) .truncate_gQkhK:nth-child(1)")).click();
    } catch (NoSuchElementException e) {
      fail("Could not find Google Nest Doorbell.");
    }
    js.executeScript("window.scrollTo(0,0)");
  }

}
