package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SubscriptionPage extends BasePage {


    public SubscriptionPage(WebDriver driver) {
        super(driver);
    }


    private static final By CONFIRMATION_MESSAGE = By.cssSelector(".alert.alert-success");
    private static final By SUBSCRIPTION_EMAIL_FIELD = By.xpath("//div[contains(@class,'block_newsletter')]//input[@name='email']");


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


}
