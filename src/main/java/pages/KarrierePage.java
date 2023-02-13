package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class KarrierePage {
    private WebDriver driver;
    public By bewirbDichJetztButton = By.xpath("//a[contains(text(), 'Bewirb dich jetzt!')]");
    public By schauenSieSichStellenangeboteAnButton = By.xpath("//a[@class='et_pb_button et_pb_button_0 et_pb_bg_layout_light']");
    public By stellenangeboteButtonNavbar = By.xpath("//a[normalize-space()='Stellenangebote']");
    public By karriere = By.xpath("//a[contains(text(), 'KARRIERE')]");

    public KarrierePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getKarrierePageTitle() {
        return driver.getTitle();
    }

    public String getKarrierePageUrl() {
        return driver.getCurrentUrl();
    }

    public StellenangebotePage clickOnStellenangeboteInNavbar(By by) {
        driver.findElement(by).click();
        return new StellenangebotePage(driver);
    }

    public void mouseHover(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).perform();
    }

    public KontaktFormular clickOnApplyButton(By by) {
        driver.findElement(by).click();
        return new KontaktFormular(driver);
    }

}
