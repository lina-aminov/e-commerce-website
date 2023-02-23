package PageObjects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SubscribeForNewsletterPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(SubscribeForNewsletterPage.class);

    private static final By CONFIRMATION_MESSAGE = By.cssSelector(".alert.alert-success");
    private static final By SUBSCRIPTION_EMAIL_FIELD = By.xpath("//div[contains(@class,'block_newsletter')]//input[@name='email']");
    private static final By ERROR_MESSAGE = By.cssSelector(".alert.alert-danger");
    private static final By INVALID_EMAIL_MESSAGE = By.cssSelector(".alert.alert-danger");

    public SubscribeForNewsletterPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmailToSubscriptionField(String email) {
        logger.info("Enter email to subscription field");
        inputText(SUBSCRIPTION_EMAIL_FIELD,email);
    }

    public void clickSubscribeButton() {
        logger.info("Click subscribe button");
        WebElement subscribeButton = driver.findElement(By.name("submitNewsletter"));
        subscribeButton.click();
    }

    public String getConfirmationMessage() {
        logger.info("Get confirmation message");
        return driver.findElement(CONFIRMATION_MESSAGE).getText();
    }
    public void enterSubscribedEmailToSubscriptionField(String subscribedEmail) {
        logger.info("Enter subscribed email to subscription field");
        findAndType(SUBSCRIPTION_EMAIL_FIELD, subscribedEmail);
    }

    public String getErrorMessage() {
        logger.info("Get error message");
        return driver.findElement(INVALID_EMAIL_MESSAGE).getText();
    }

    public String getInvalidEmailMessage() {
        logger.info("Get invalid email message");
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
