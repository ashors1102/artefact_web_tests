package com.ashors1102.artefact.tests;

import com.ashors1102.artefact.model.ExhibitionData;
import org.junit.Test;

public class ExhibitionCreationTest extends TestBase{

  @Test
  public void testExhibitionCreation() throws Exception {
    app.exhibition().initExhibitionCreation();
    app.exhibition().fillExhibitionForm(new ExhibitionData("Short Name of Exhibition", "Full Name of Exhibition", "Short brief", "Москва"));
    app.exhibition().saveAndExitExhibition();
  }

}
