package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SubscribeForNewsletterPage extends BasePage {


    public SubscribeForNewsletterPage(WebDriver driver) {
        super(driver);
    }


    private static final By CONFIRMATION_MESSAGE = By.cssSelector(".alert.alert-success");
    private static final By SUBSCRIPTION_EMAIL_FIELD = By.xpath("//div[contains(@class,'block_newsletter')]//input[@name='email']");
    private static final By ERROR_MESSAGE = By.cssSelector(".alert.alert-danger");
    private static final By INVALID_EMAIL_MESSAGE = By.cssSelector(".alert.alert-danger");


    public void enterEmailToSubscriptionField(String email) {
        inputText(SUBSCRIPTION_EMAIL_FIELD,email);
    }

    public void clickSubscribeButton() {
        WebElement subscribeButton = driver.findElement(By.name("submitNewsletter"));
        subscribeButton.click();
    }

    public String getConfirmationMessage() {
        return driver.findElement(CONFIRMATION_MESSAGE).getText();
    }
    public void enterSubscribedEmailToSubscriptionField(String subscribedEmail) {
        findAndType(SUBSCRIPTION_EMAIL_FIELD, subscribedEmail);
    }



    public String getErrorMessage() {
        return driver.findElement(INVALID_EMAIL_MESSAGE).getText();
    }

    public String getInvalidEmailMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
