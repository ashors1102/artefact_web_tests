package com.ashors1102.artefact.tests;

import com.ashors1102.artefact.appmanager.ApplicationManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;

public class TestBase {
    private boolean acceptNextAlert = true;

    protected static final ApplicationManager app = new ApplicationManager();


    @Before
    public void setUp() throws Exception {
      app.init();
    }

    @After
    public void tearDown() throws Exception {
      app.session().delogin();
      app.stop();
    }

    protected boolean isElementPresent(By by) {
      try {
        app.wd.findElement(by);
        return true;
      } catch (NoSuchElementException e) {
        return false;
      }
    }

    protected boolean isAlertPresent() {
      try {
        app.wd.switchTo().alert();
        return true;
      } catch (NoAlertPresentException e) {
        return false;
      }
    }

    protected String closeAlertAndGetItsText() {
        try {
            Alert alert = app.wd.switchTo().alert();
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
