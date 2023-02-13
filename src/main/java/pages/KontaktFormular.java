package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KontaktFormular {
    private WebDriver driver;
    public By applyNowButton = By.xpath("//input[@type='submit']");
    public By validationMsgNameField = By.id("awsm-applicant-name-error");
    public By validationMsgEmailField = By.id("awsm-applicant-email-error");
    public By validationMsgPhoneField = By.id("awsm-applicant-phone-error");
    public By validationMsgCoverLetterField = By.id("awsm-cover-letter-error");
    public By validationMsgCheckbox = By.id("awsm_form_privacy_policy-error");
    public By nameField = By.id("awsm-applicant-name");
    public By phoneField = By.id("awsm-applicant-phone");
    public By emailField = By.id("awsm-applicant-email");
    public By coverLetterField = By.id("awsm-cover-letter");
    public By uploadFile = By.id("awsm-application-file");
    public By fileName = By.xpath("//div[@class='custom-input']");
    public By checkbox = By.xpath("//label[@for='awsm_form_privacy_policy']");
    public By checkboxState = By.id("awsm_form_privacy_policy");

    public KontaktFormular(WebDriver driver) {
        this.driver = driver;
    }

    public String getKontaktFormularPageTitle() {
        return driver.getTitle();
    }

    public String getKontaktFormularPageUrl() {
        return driver.getCurrentUrl();
    }

    public void clickApplyNowButton(By by) {
        driver.findElement(by).click();
    }

    public String getValidationMessage(By by) {
        return driver.findElement(by).getText();
    }

    public void setFieldValue(By by, String value) {
        driver.findElement(by).sendKeys(value);
    }

    public String getFieldValue(By by) {
        return driver.findElement(by).getAttribute("value");
    }

    public void uploadFile(By by) {
        driver.findElement(by).sendKeys("C:\\Users\\Sven\\IdeaProjects\\UIAutomationQM\\files\\kalender-2021.jpg");
    }

    public String getFileName(By by) {
        return driver.findElement(by).getText();
    }

    public void clickCheckBox(By by) {
        driver.findElement(by).click();
    }

    public boolean getCheckboxState(By by) {
        return driver.findElement(by).isSelected();
    }
}
