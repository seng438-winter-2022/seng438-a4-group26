package guiTesting;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.Duration;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

class TestTradeIn {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

	@Test
	void IdealPathTest() throws InterruptedException {
		driver.get("https:www.bestbuy.ca/en-ca");
    	driver.manage().window().maximize();
    	driver.findElement(By.cssSelector("li:nth-child(4) button > .white_3qh7k")).click();
        {
          WebElement element = driver.findElement(By.cssSelector("li:nth-child(4) button > .white_3qh7k"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element).perform();
        }
        {
          WebElement element = driver.findElement(By.tagName("body"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.linkText("Trade-In Program")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".container_23b42:nth-child(1) > .col-xs-4_1EA1G:nth-child(2) .link_ldnKD")));
        if(driver.findElement(By.className("title_3A6Uh")).getText().contains("Trade-In Program")) {
        	System.out.println("Checkpoint 1 reached");
        }else {
        	fail("Checkpoint 1 not reached, expected Trade-In page, was elsewhere");
        }
        driver.findElement(By.cssSelector(".container_23b42:nth-child(1) > .col-xs-4_1EA1G:nth-child(2) .link_ldnKD")).click();
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        if(tabs.size()>1) {
        	System.out.println("Check point 2 reached, new tab opened");
        }else {
        	fail("Checkpoint 2 not reached, new tab not opened");
        }
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("Model")));
        Select drop = new Select(driver.findElement(By.name("Model")));
        drop.selectByVisibleText("IPHONE 12 128GB");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("CurrentCarrier")));
        drop = new Select(driver.findElement(By.name("CurrentCarrier")));
        drop.selectByVisibleText("Virgin Mobile");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("grey_button")));
        driver.findElement(By.className("grey_button")).click();
        Thread.sleep(1000);
        assertTrue("Wrong outputed price, should have been $450",driver.findElement(By.className("the_quote")).getText().contains("450"));
	}
	
	@Test
	void selectAPhoneThenSwitchBrand() throws InterruptedException {
		driver.get("https:www.bestbuy.ca/en-ca");
    	driver.manage().window().maximize();
    	driver.findElement(By.cssSelector("li:nth-child(4) button > .white_3qh7k")).click();
        {
          WebElement element = driver.findElement(By.cssSelector("li:nth-child(4) button > .white_3qh7k"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element).perform();
        }
        {
          WebElement element = driver.findElement(By.tagName("body"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.linkText("Trade-In Program")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".container_23b42:nth-child(1) > .col-xs-4_1EA1G:nth-child(2) .link_ldnKD")));
        if(driver.findElement(By.className("title_3A6Uh")).getText().contains("Trade-In Program")) {
        	System.out.println("Checkpoint 1 reached");
        }else {
        	fail("Checkpoint 1 not reached, expected Trade-In page, was elsewhere");
        }
        driver.findElement(By.cssSelector(".container_23b42:nth-child(1) > .col-xs-4_1EA1G:nth-child(2) .link_ldnKD")).click();
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        if(tabs.size()>1) {
        	System.out.println("Check point 2 reached, new tab opened");
        }else {
        	fail("Checkpoint 2 not reached, new tab not opened");
        }
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("Model")));
        Select drop = new Select(driver.findElement(By.name("Model")));
        drop.selectByVisibleText("IPHONE 12 128GB");
        drop = new Select(driver.findElement(By.name("Brand")));
        drop.selectByVisibleText("BLACKBERRY");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("Model")));
        Thread.sleep(1000);
        assertTrue("IPhone remained selected after brand was switched to Blackberry",driver.findElement(By.name("Model")).getText().contains("--Select Phone Model"));
	}

}
