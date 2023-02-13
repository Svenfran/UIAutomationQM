package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KarrierePage;
import pages.KontaktFormular;
import pages.StellenangebotePage;
import testdata.TestData;

public class KarrierePageTest extends BaseTest {

    KarrierePage karrierePage;
    KontaktFormular kontaktFormular;
    StellenangebotePage stellenangebotePage;

    @Test
    public void testKarrierePage() {
        homePage.rejectCookies(homePage.rejectCookiesBtn);

        Assert.assertEquals(homePage.getHomePageTitle(), TestData.homePageTitle);
        Assert.assertEquals(homePage.getHomePageUrl(), TestData.homePageUrl);
        karrierePage = homePage.clickOnKarriereInNavbar(homePage.karriere);
        Assert.assertEquals(karrierePage.getKarrierePageUrl(), TestData.karrierePageUrl);
        Assert.assertEquals(karrierePage.getKarrierePageTitle(), TestData.karrierePageTitle);
        karrierePage.mouseHover(karrierePage.karriere);
        stellenangebotePage = karrierePage.clickOnStellenangeboteInNavbar(karrierePage.stellenangeboteButtonNavbar);
        Assert.assertEquals(stellenangebotePage.getStellenangebotePageUrl(), TestData.stellenangebotePageUrl);
        Assert.assertEquals(stellenangebotePage.getStellenangebotePageTitle(), TestData.stellenangebotePageTitle);
        kontaktFormular = stellenangebotePage.clickOnStellenangebotFullStack(stellenangebotePage.stellenangebotFullStack);
        Assert.assertEquals(kontaktFormular.getKontaktFormularPageUrl(), TestData.fullStackKontaktFormularPageUrl);
        Assert.assertEquals(kontaktFormular.getKontaktFormularPageTitle(), TestData.fullStackKontaktFormularPageTitle);
        kontaktFormular.clickApplyNowButton(kontaktFormular.applyNowButton);
        Assert.assertEquals(kontaktFormular.getValidationMessage(kontaktFormular.validationMsgNameField), TestData.commonValidationMessage);
        Assert.assertEquals(kontaktFormular.getValidationMessage(kontaktFormular.validationMsgEmailField), TestData.commonValidationMessage);
        Assert.assertEquals(kontaktFormular.getValidationMessage(kontaktFormular.validationMsgPhoneField), TestData.commonValidationMessage);
        Assert.assertEquals(kontaktFormular.getValidationMessage(kontaktFormular.validationMsgCoverLetterField), TestData.commonValidationMessage);
        Assert.assertEquals(kontaktFormular.getValidationMessage(kontaktFormular.validationMsgCheckbox), TestData.commonValidationMessage);
        kontaktFormular.setFieldValue(kontaktFormular.nameField, TestData.name);
        kontaktFormular.setFieldValue(kontaktFormular.phoneField, TestData.phoneNr);
        kontaktFormular.setFieldValue(kontaktFormular.coverLetterField, TestData.coverLetter);
        Assert.assertEquals(kontaktFormular.getFieldValue(kontaktFormular.nameField), TestData.name);
        Assert.assertEquals(kontaktFormular.getFieldValue(kontaktFormular.phoneField), TestData.phoneNr);
        Assert.assertEquals(kontaktFormular.getFieldValue(kontaktFormular.coverLetterField), TestData.coverLetter);
        kontaktFormular.clickApplyNowButton(kontaktFormular.applyNowButton);
        Assert.assertEquals(kontaktFormular.getValidationMessage(kontaktFormular.validationMsgEmailField), TestData.commonValidationMessage);
        Assert.assertEquals(kontaktFormular.getValidationMessage(kontaktFormular.validationMsgCheckbox), TestData.commonValidationMessage);
        kontaktFormular.setFieldValue(kontaktFormular.emailField, TestData.invalidEmail);
        Assert.assertEquals(kontaktFormular.getFieldValue(kontaktFormular.emailField), TestData.invalidEmail);
        Assert.assertEquals(kontaktFormular.getValidationMessage(kontaktFormular.validationMsgEmailField), TestData.ValidationMessageEmail);
        kontaktFormular.clickApplyNowButton(kontaktFormular.applyNowButton);
        kontaktFormular.uploadFile(kontaktFormular.uploadFile);
        Assert.assertEquals(kontaktFormular.getFileName(kontaktFormular.fileName), TestData.fileName);
        kontaktFormular.clickCheckBox(kontaktFormular.checkbox);
        Assert.assertEquals(kontaktFormular.getCheckboxState(kontaktFormular.checkboxState), true);

    }
}
