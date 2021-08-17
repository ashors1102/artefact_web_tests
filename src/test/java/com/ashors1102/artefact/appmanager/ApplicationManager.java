package com.ashors1102.artefact.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final Properties properties;
    public WebDriver wd;

    private ExhibitionHelper exhibitionHelper;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;

    public void init() throws IOException {
        properties.load(new FileReader(new File(String.format("src/test/resources/local.properties"))));
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        sessionHelper = new SessionHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        exhibitionHelper = new ExhibitionHelper(wd);

        wd.get(properties.getProperty("web.baseUrl"));
        navigationHelper.gotoAdminPage();
        sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword") );
    }

    public void stop(){
        wd.quit();
    }

    public ApplicationManager() {
        properties = new Properties();
    }

    public ExhibitionHelper exhibition() {
        return exhibitionHelper;
    }

    public SessionHelper session() {
        return sessionHelper;
    }

    public NavigationHelper navigation(){
        return navigationHelper;
    }
}
