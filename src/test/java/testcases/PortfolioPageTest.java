package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PortfolioPage;
import testdata.TestData;

public class PortfolioPageTest extends BaseTest {

    PortfolioPage portfolioPage;

    @Test
    public void testPortfolioPage() {
        Assert.assertEquals(homePage.getHomePageTitle(), TestData.homePageTitle);
        Assert.assertEquals(homePage.getHomePageUrl(), TestData.homePageUrl);
        homePage.mouseHover(homePage.portfolio);
        Assert.assertEquals(homePage.displayCheckOfHomePageElement(homePage.subMenu), true);
        portfolioPage = homePage.clickOnAutomatisiertesTesten(homePage.automatisiertesTesten);
        Assert.assertEquals(portfolioPage.getAutomatisiertesTestenPageTitle(), TestData.automatisiertesTestenPageTitle);
        Assert.assertEquals(portfolioPage.getAutomatisiertesTestenPageUrl(), TestData.automatisiertesTestenPageUrl);
        Assert.assertEquals(portfolioPage.checkTabTextColor(portfolioPage.consultingTab), TestData.tabColor );
        Assert.assertEquals(portfolioPage.checkTabBackgroundColor(portfolioPage.consultingTab), TestData.tabBackgroundColor );

    }
}
