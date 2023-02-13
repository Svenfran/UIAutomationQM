package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    private WebDriver driver;
    public By kontaktNavbar = By.xpath("//a[contains(text(), 'KONTAKT')]");
    public By kontaktFooter = By.xpath("//a[normalize-space()='Kontakt']");
    public By karriere = By.xpath("//a[contains(text(), 'KARRIERE')]");
    public By portfolio = By.xpath("//a[normalize-space()='PORTFOLIO']");
    public By subMenu = By.className("sub-menu");
    public By automatisiertesTesten = By.xpath("//a[normalize-space()='Automatisiertes Testen']");
    public By rejectCookiesBtn = By.xpath("//button[@class='cmplz-btn cmplz-deny']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public String getHomePageUrl() {
        return driver.getCurrentUrl();
    }

    public KontaktPage clickOnHomePageElement(By by) {
        driver.findElement(by).click();
        return new KontaktPage(driver);
    }

    public void rejectCookies(By by) {
        driver.findElement(by).click();
    }

    public void mouseHover(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).perform();
    }

    public boolean displayCheckOfHomePageElement(By by) {
        return driver.findElement(by).isDisplayed();
    }

    public PortfolioPage clickOnAutomatisiertesTesten(By by) {
        driver.findElement(by).click();
        return new PortfolioPage(driver);
    }

    public KarrierePage clickOnKarriereInNavbar(By by) {
        driver.findElement(by).click();
        return new KarrierePage(driver);
    }

}
