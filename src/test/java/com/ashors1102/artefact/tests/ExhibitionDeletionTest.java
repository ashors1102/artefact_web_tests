package com.ashors1102.artefact.tests;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ExhibitionDeletionTest extends TestBase{

    @Test
    public void testExhibitionDeletion() throws Exception {
        app.exhibition().selectExhibition();
        app.exhibition().deleteButton();
        assertTrue(closeAlertAndGetItsText().matches("^Удалить 1 документ\\(a, ов\\)[\\s\\S]$"));
    }
}
