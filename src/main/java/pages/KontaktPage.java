package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KontaktPage {

    private WebDriver driver;
    public By bodyText = By.tagName("body");
    public By email = By.xpath("//a[normalize-space()='hello@qualityminds.de']");

    public KontaktPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getKontaktPageUrl() {
        return driver.getCurrentUrl();
    }

    public String getKontaktPageTitle() {
        return driver.getTitle();
    }

    public String getBodyText(By by) {
        return driver.findElement(by).getText();
    }

    public boolean displayCheckEmail(By by) {
        return driver.findElement(by).isDisplayed();
    }

    public String getEmailText(By by) {
        return driver.findElement(by).getText();
    }

    public void navigateBack() {
        driver.navigate().back();
    }
}
