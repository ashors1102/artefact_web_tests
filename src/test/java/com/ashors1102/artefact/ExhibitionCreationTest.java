package com.ashors1102.artefact;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ExhibitionCreationTest {
  private WebDriver wd;

  @Before
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    gotoMainPage();
  }

  @Test
  public void testExhibitionCreation() throws Exception {
    gotoAdminPage();
    login("ashors1102@gmail.com", "Aa321369357");
    initExhibitionCreation();
    fillExhibitionForm(new ExhibitionData("Short Name of Exhibition", "Full Name of Exhibition", "Short brief", "Москва"));
    saveAndExitExhibition();
  }

  private void gotoMainPage() {
    wd.get("http://194.190.9.177/ru");
  }

  private void gotoAdminPage() {
    wd.findElement(By.linkText("Вход для музеев")).click();
  }

  private void initExhibitionCreation() {
    wd.findElement(By.id("add_btn_Project")).click();
  }

  private void fillExhibitionForm(ExhibitionData exhibitionData) {
    wd.findElement(By.name("title.ru")).click();
    wd.findElement(By.name("title.ru")).clear();
    wd.findElement(By.name("title.ru")).sendKeys(exhibitionData.getShortName());
    wd.findElement(By.name("longTitle.ru")).click();
    wd.findElement(By.name("longTitle.ru")).clear();
    wd.findElement(By.name("longTitle.ru")).sendKeys(exhibitionData.getFullName());
    wd.findElement(By.name("lead.ru")).click();
    wd.findElement(By.name("lead.ru")).clear();
    wd.findElement(By.name("lead.ru")).sendKeys(exhibitionData.getBrief());
    wd.findElement(By.id("select2--container")).click();
    wd.findElement(By.xpath("//span/input")).clear();
    wd.findElement(By.xpath("//span/input")).sendKeys(exhibitionData.getCity());
    wd.findElement(By.xpath("//span/input")).sendKeys(Keys.ENTER);
  }

  private void saveAndExitExhibition() {
    wd.findElement(By.id("mainFormSubmit")).click();
  }

  private void login(String email, String password) {
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(email);
    wd.findElement(By.xpath("//form[@id='login']/div[3]")).click();
    wd.findElement(By.name("password")).click();
    wd.findElement(By.name("password")).clear();
    wd.findElement(By.name("password")).sendKeys(password);
    wd.findElement(By.xpath("//button[@type='submit']")).click();
  }

  private void delogin() {
    wd.findElement(By.linkText("Алексей Шоршин")).click();
  }

  @After
  public void tearDown() throws Exception {
    delogin();
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
