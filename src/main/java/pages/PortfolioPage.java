package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class PortfolioPage {
    private WebDriver driver;
    public By consultingTab = By.xpath("//a[normalize-space()='Consulting']");

    public PortfolioPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAutomatisiertesTestenPageTitle() {
        return driver.getTitle();
    }

    public String getAutomatisiertesTestenPageUrl() {
        return driver.getCurrentUrl();
    }

    public String checkTabTextColor(By by) {
        String color = driver.findElement(by).getCssValue("color");
        return Color.fromString(color).asRgba();
    }

    public String checkTabBackgroundColor(By by) {
        return driver.findElement(by).getCssValue("background-color");
    }

}
