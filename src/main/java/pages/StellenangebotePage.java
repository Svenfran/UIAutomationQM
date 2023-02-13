package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StellenangebotePage {
    private WebDriver driver;
    public By stellenangebote = By.className("awsm-job-listings");
    public By stellenangebot = By.xpath("//a[@class='awsm-job-item']");
    public By stellenangebotFullStack = By.xpath("//a[@href='https://qualityminds.com/de/stellenangebote/senior-full-stack-entwickler-in-m-w-d/']");

    public StellenangebotePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getStellenangebotePageTitle() {
        return driver.getTitle();
    }

    public String getStellenangebotePageUrl() {
        return driver.getCurrentUrl();
    }

    public KontaktFormular clickOnStellenangebotFullStack(By by) {
        driver.findElement(by).click();
        return new KontaktFormular(driver);
    }

    public KontaktFormular clickOnStellenangebot(By by, int vacancyCount) {
        String href = getHrefOfStellenangebot(by, vacancyCount);
        driver.findElement(By.xpath("//a[@href='" + href + "']")).click();
        return new KontaktFormular(driver);
    }

    private String getHrefOfStellenangebot(By by, int i) {
        WebElement parentElement = driver.findElement(by);
        List<WebElement> alleStellenangebote = parentElement.findElements(stellenangebot);
        return alleStellenangebote.get(i - 1).getAttribute("href");
    }
}
