package com.ashors1102.artefact.appmanager;

import com.ashors1102.artefact.model.ExhibitionData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ExhibitionHelper extends HelperBase{

    public ExhibitionHelper(WebDriver wd) {
        super(wd);
    }

    public void initExhibitionCreation() {
        wd.findElement(By.id("add_btn_Project")).click();
    }

    public void saveAndExitExhibition() {
        wd.findElement(By.id("mainFormSubmit")).click();
    }

    public void deleteButton() {
        wd.findElement(By.xpath("//div[3]/div/span")).click();
    }

    public void selectExhibition() {
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Short Name of Exhibition'])[1]/preceding::div[1]")).click();
    }

    public void fillExhibitionForm(ExhibitionData exhibitionData) {
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
}
