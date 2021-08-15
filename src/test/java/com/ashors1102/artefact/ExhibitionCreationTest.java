package com.ashors1102.artefact;

import org.junit.Test;

public class ExhibitionCreationTest extends TestBase{

  @Test
  public void testExhibitionCreation() throws Exception {
    gotoAdminPage();
    login("ashors1102@gmail.com", "Aa321369357");
    initExhibitionCreation();
    fillExhibitionForm(new ExhibitionData("Short Name of Exhibition", "Full Name of Exhibition", "Short brief", "Москва"));
    saveAndExitExhibition();
  }

}
