package com.ashors1102.artefact.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoAdminPage() {
        wd.findElement(By.linkText("Вход для музеев")).click();
    }
}
