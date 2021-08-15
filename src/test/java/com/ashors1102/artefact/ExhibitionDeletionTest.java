package com.ashors1102.artefact;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class ExhibitionDeletionTest extends TestBase{

    @Test
    public void testExhibitionDeletion() throws Exception {
        gotoAdminPage();
        login("ashors1102@gmail.com", "Aa321369357");
        selectExhibition();
        deleteButton();
        assertTrue(closeAlertAndGetItsText().matches("^Удалить 1 документ\\(a, ов\\)[\\s\\S]$"));
    }
}
