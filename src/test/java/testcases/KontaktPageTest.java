package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KontaktPage;
import testdata.TestData;

public class KontaktPageTest extends BaseTest {

    KontaktPage kontaktPage;

    @Test
    public void testKontaktPage() {
        homePage.rejectCookies(homePage.rejectCookiesBtn);

        Assert.assertEquals(homePage.getHomePageTitle(), TestData.homePageTitle);
        Assert.assertEquals(homePage.getHomePageUrl(), TestData.homePageUrl);
        kontaktPage = homePage.clickOnHomePageElement(homePage.kontaktNavbar);
        Assert.assertEquals(kontaktPage.getKontaktPageUrl(), TestData.kontaktPageUrl);
        Assert.assertEquals(kontaktPage.getKontaktPageTitle(), TestData.kontaktPageTitle);
        Assert.assertEquals(kontaktPage.displayCheckEmail(kontaktPage.email), true);
        Assert.assertTrue(kontaktPage.getBodyText(kontaktPage.bodyText).contains(TestData.kontaktPageEmail), "Email does not exist on page");
        Assert.assertEquals(kontaktPage.getEmailText(kontaktPage.email), TestData.kontaktPageEmail);

        kontaktPage.navigateBack();
        Assert.assertEquals(homePage.getHomePageTitle(), TestData.homePageTitle);
        Assert.assertEquals(homePage.getHomePageUrl(), TestData.homePageUrl);

        kontaktPage = homePage.clickOnHomePageElement(homePage.kontaktFooter);
        Assert.assertEquals(kontaktPage.getKontaktPageUrl(), TestData.kontaktPageUrl);
        Assert.assertEquals(kontaktPage.getKontaktPageTitle(), TestData.kontaktPageTitle);
    }
}
