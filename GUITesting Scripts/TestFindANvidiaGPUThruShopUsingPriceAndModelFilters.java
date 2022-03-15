package guiTesting;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.Duration;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

class TestFindANvidiaGPUThruShopUsingPriceAndModelFilters {

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
    void idealPathTest() throws InterruptedException {
//    	fail();
    	driver.get("https:www.bestbuy.ca/en-ca");
    	driver.manage().window().maximize();
        driver.findElement(By.cssSelector("li:nth-child(1) button > .white_3qh7k")).click();
        {
          WebElement element = driver.findElement(By.cssSelector("li:nth-child(1) button > .white_3qh7k"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element).perform();
        }
        {
          WebElement element = driver.findElement(By.tagName("body"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.linkText("Computers, Tablets & Accessories")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".container_23b42:nth-child(1) > .col-xs-4_1EA1G:nth-child(13) .link_ldnKD")));
        if(driver.findElement(By.className("title_3A6Uh")).getText().contains("Computers & Tablets")) {
        	System.out.println("Checkpoint 1 reached");
        }else {
        	fail("Checkpoint 1 not reached, expected Computers & Tablets page, was elsewhere");
        }
        driver.findElement(By.cssSelector(".container_23b42:nth-child(1) > .col-xs-4_1EA1G:nth-child(13) .link_ldnKD")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".columnContentRow_16zNr:nth-child(2) > .column_3St0Y:nth-child(3) span")));
        if(driver.findElement(By.className("title_3A6Uh")).getText().contains("PC Components")) {
        	System.out.println("Checkpoint 2 reached");
        }else {
        	fail("Checkpoint 2 not reached, expected PC components page, was elsewhere");
        }
        driver.findElement(By.cssSelector(".columnContentRow_16zNr:nth-child(2) > .column_3St0Y:nth-child(3) span")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".col-xs-4_1EA1G:nth-child(1) .link_ldnKD")));
        if(driver.findElement(By.className("title_3A6Uh")).getText().contains("Graphics Cards")) {
        	System.out.println("Checkpoint 3 reached");
        }else {
        	fail("Checkpoint 3 not reached, expected Graphics cards page, was elsewhere");
        }
        driver.findElement(By.cssSelector(".col-xs-4_1EA1G:nth-child(1) .link_ldnKD")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".container_3BQfa:nth-child(8) > .button_2xI6P")));
        if(driver.findElement(By.className("title_3A6Uh")).getText().contains("Graphics Cards with NVIDIA Chipset")) {
        	System.out.println("Checkpoint 4 reached");
        }else {
        	fail("Checkpoint 4 not reached, expected NVidida Graphics cards page, was elsewhere");
        }
        driver.findElement(By.cssSelector(".container_3BQfa:nth-child(8) > .button_2xI6P")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("facetFilter-GeForce RTX 3090")));
        driver.findElement(By.id("facetFilter-GeForce RTX 3090")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".container_3BQfa:nth-child(6) > .button_2xI6P")));
        driver.findElement(By.cssSelector(".container_3BQfa:nth-child(6) > .button_2xI6P")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("price-search-bar-min-input")));
        driver.findElement(By.id("price-search-bar-min-input")).clear();
        driver.findElement(By.id("price-search-bar-min-input")).sendKeys("2500");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("price-search-bar-max-input")));
        driver.findElement(By.id("price-search-bar-max-input")).clear();
        driver.findElement(By.id("price-search-bar-max-input")).sendKeys("4000");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("priceButtonFlexContainer_1-pxl")));
        driver.findElement(By.className("priceButtonFlexContainer_1-pxl")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".col-xs-12_198le:nth-child(1) .productItemName_3IZ3c")));
        driver.findElement(By.cssSelector(".col-xs-12_198le:nth-child(1) .productItemName_3IZ3c")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("productName_2KoPa")));
        assertTrue("Wrong product displayed, should have been a MSI RTX 3090",driver.findElement(By.className("productName_2KoPa")).getText().contains("RTX 3090 SUPRIM X"));
    }
    
    @Test
    void enterCharIntoNumFieldTest () throws InterruptedException {
//    	fail();
    	driver.get("https:www.bestbuy.ca/en-ca");
    	driver.manage().window().maximize();
        driver.findElement(By.cssSelector("li:nth-child(1) button > .white_3qh7k")).click();
        {
          WebElement element = driver.findElement(By.cssSelector("li:nth-child(1) button > .white_3qh7k"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element).perform();
        }
        {
          WebElement element = driver.findElement(By.tagName("body"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.linkText("Computers, Tablets & Accessories")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".container_23b42:nth-child(1) > .col-xs-4_1EA1G:nth-child(13) .link_ldnKD")));
        if(driver.findElement(By.className("title_3A6Uh")).getText().contains("Computers & Tablets")) {
        	System.out.println("Checkpoint 1 reached");
        }else {
        	fail("Checkpoint 1 not reached, expected Computers & Tablets page, was elsewhere");
        }
        driver.findElement(By.cssSelector(".container_23b42:nth-child(1) > .col-xs-4_1EA1G:nth-child(13) .link_ldnKD")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".columnContentRow_16zNr:nth-child(2) > .column_3St0Y:nth-child(3) span")));
        if(driver.findElement(By.className("title_3A6Uh")).getText().contains("PC Components")) {
        	System.out.println("Checkpoint 2 reached");
        }else {
        	fail("Checkpoint 2 not reached, expected PC components page, was elsewhere");
        }
        driver.findElement(By.cssSelector(".columnContentRow_16zNr:nth-child(2) > .column_3St0Y:nth-child(3) span")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".col-xs-4_1EA1G:nth-child(1) .link_ldnKD")));
        if(driver.findElement(By.className("title_3A6Uh")).getText().contains("Graphics Cards")) {
        	System.out.println("Checkpoint 3 reached");
        }else {
        	fail("Checkpoint 3 not reached, expected Graphics cards page, was elsewhere");
        }
        driver.findElement(By.cssSelector(".col-xs-4_1EA1G:nth-child(1) .link_ldnKD")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".container_3BQfa:nth-child(8) > .button_2xI6P")));
        if(driver.findElement(By.className("title_3A6Uh")).getText().contains("Graphics Cards with NVIDIA Chipset")) {
        	System.out.println("Checkpoint 4 reached");
        }else {
        	fail("Checkpoint 4 not reached, expected NVidida Graphics cards page, was elsewhere");
        }
        driver.findElement(By.cssSelector(".container_3BQfa:nth-child(8) > .button_2xI6P")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("facetFilter-GeForce RTX 3090")));
        driver.findElement(By.id("facetFilter-GeForce RTX 3090")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".container_3BQfa:nth-child(6) > .button_2xI6P")));
        driver.findElement(By.cssSelector(".container_3BQfa:nth-child(6) > .button_2xI6P")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("price-search-bar-min-input")));
        driver.findElement(By.id("price-search-bar-min-input")).clear();
        driver.findElement(By.id("price-search-bar-min-input")).sendKeys("aefr");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("price-search-bar-max-input")));
        driver.findElement(By.id("price-search-bar-max-input")).clear();
        driver.findElement(By.id("price-search-bar-max-input")).sendKeys("-yrfdg");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("priceButtonFlexContainer_1-pxl")));
        driver.findElement(By.className("priceButtonFlexContainer_1-pxl")).click();
        Thread.sleep(1000);
        assertFalse("Price search button is enabled when it shouldn't be",driver.findElement(By.cssSelector(".priceButtonFlexContainer_1-pxl > .button_E6SE9")).isEnabled());
    }
    
    @Test
    void enterInvalidRangeIntoNumFieldTest () throws InterruptedException {
//    	fail();
    	driver.get("https:www.bestbuy.ca/en-ca");
    	driver.manage().window().maximize();
        driver.findElement(By.cssSelector("li:nth-child(1) button > .white_3qh7k")).click();
        {
          WebElement element = driver.findElement(By.cssSelector("li:nth-child(1) button > .white_3qh7k"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element).perform();
        }
        {
          WebElement element = driver.findElement(By.tagName("body"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.linkText("Computers, Tablets & Accessories")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".container_23b42:nth-child(1) > .col-xs-4_1EA1G:nth-child(13) .link_ldnKD")));
        if(driver.findElement(By.className("title_3A6Uh")).getText().contains("Computers & Tablets")) {
        	System.out.println("Checkpoint 1 reached");
        }else {
        	fail("Checkpoint 1 not reached, expected Computers & Tablets page, was elsewhere");
        }
        driver.findElement(By.cssSelector(".container_23b42:nth-child(1) > .col-xs-4_1EA1G:nth-child(13) .link_ldnKD")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".columnContentRow_16zNr:nth-child(2) > .column_3St0Y:nth-child(3) span")));
        if(driver.findElement(By.className("title_3A6Uh")).getText().contains("PC Components")) {
        	System.out.println("Checkpoint 2 reached");
        }else {
        	fail("Checkpoint 2 not reached, expected PC components page, was elsewhere");
        }
        driver.findElement(By.cssSelector(".columnContentRow_16zNr:nth-child(2) > .column_3St0Y:nth-child(3) span")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".col-xs-4_1EA1G:nth-child(1) .link_ldnKD")));
        if(driver.findElement(By.className("title_3A6Uh")).getText().contains("Graphics Cards")) {
        	System.out.println("Checkpoint 3 reached");
        }else {
        	fail("Checkpoint 3 not reached, expected Graphics cards page, was elsewhere");
        }
        driver.findElement(By.cssSelector(".col-xs-4_1EA1G:nth-child(1) .link_ldnKD")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".container_3BQfa:nth-child(8) > .button_2xI6P")));
        if(driver.findElement(By.className("title_3A6Uh")).getText().contains("Graphics Cards with NVIDIA Chipset")) {
        	System.out.println("Checkpoint 4 reached");
        }else {
        	fail("Checkpoint 4 not reached, expected NVidida Graphics cards page, was elsewhere");
        }
        driver.findElement(By.cssSelector(".container_3BQfa:nth-child(8) > .button_2xI6P")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("facetFilter-GeForce RTX 3090")));
        driver.findElement(By.id("facetFilter-GeForce RTX 3090")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".container_3BQfa:nth-child(6) > .button_2xI6P")));
        driver.findElement(By.cssSelector(".container_3BQfa:nth-child(6) > .button_2xI6P")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("price-search-bar-min-input")));
        driver.findElement(By.id("price-search-bar-min-input")).clear();
        driver.findElement(By.id("price-search-bar-min-input")).sendKeys("4000");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("price-search-bar-max-input")));
        driver.findElement(By.id("price-search-bar-max-input")).clear();
        driver.findElement(By.id("price-search-bar-max-input")).sendKeys("2500");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("priceButtonFlexContainer_1-pxl")));
        driver.findElement(By.className("priceButtonFlexContainer_1-pxl")).click();
        Thread.sleep(1000);
        try {
        	assertTrue(driver.findElement(By.className("noResultMessageContainer_1fah3")).isDisplayed());
        }catch(NoSuchElementException e) {
        	fail("enterInvalidRangeIntoNumFieldTest: failed noResultMessage was not displayed");
        }
    }

}