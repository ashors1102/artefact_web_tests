package com.ashors1102.artefact.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{

    public SessionHelper(WebDriver wd){
        super(wd);
    }

    public void login(String email, String password) {
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(email);
        wd.findElement(By.xpath("//form[@id='login']/div[3]")).click();
        wd.findElement(By.name("password")).click();
        wd.findElement(By.name("password")).clear();
        wd.findElement(By.name("password")).sendKeys(password);
        wd.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void delogin() {
        wd.findElement(By.linkText("Алексей Шоршин")).click();
    }


}
