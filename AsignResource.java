package org.automation.test2;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AsignResource {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://172.20.208.174:4042/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test (priority=1)
  public void test02AsignResource() throws Exception {
    driver.get(baseUrl + "/admin/#/login");
    driver.findElement(By.cssSelector("input[type=\"text\"]")).clear();
    driver.findElement(By.cssSelector("input[type=\"text\"]")).sendKeys("User");
    driver.findElement(By.cssSelector("input[type=\"password\"]")).clear();
    driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("PAss");
    WebElement element = (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));    
    driver.findElement(By.xpath("//button")).click();
    driver.findElement(By.linkText("Conference Rooms")).click();
    driver.findElement(By.xpath("//div[@id='roomsGrid']/div[2]/div/div[4]/div[3]/div[2]/div/span[2]")).click();
    driver.findElement(By.xpath("//div[@id='roomsGrid']/div[2]/div/div[4]/div[3]/div[2]/div/span[2]")).click();
    driver.findElement(By.linkText("Resource Associations")).click();
    driver.findElement(By.xpath("//div[20]/div[3]/button")).click();
    WebElement element2 = (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.info")));
    driver.findElement(By.cssSelector("button.info")).click();
    driver.findElement(By.xpath("//div[20]/span/span")).click();
    assertTrue(isElementPresent(By.cssSelector("div.animate-if.ng-scope > span.fa.fa-desktop")));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
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
} 