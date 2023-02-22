package PageObjects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    private static final By AUTHENTICATION_FAILED_MESSAGE = By.cssSelector(".alert.alert-danger");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickSignUpLink() {
        logger.info("Click sign up link");
        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(@href,'authentication')]"));
        signUpLink.click();
    }

    public void clickSignInButton() {
        logger.info("Click sign in button");
        WebElement signInButton = driver.findElement(By.xpath("//div[@id='content-wrapper']//button[@class='btn btn-primary']"));
        signInButton.click();
    }

    public String getAuthenticationFailedMessage() {
        logger.info("Get authentication failed message");
        return driver.findElement(AUTHENTICATION_FAILED_MESSAGE).getText();
    }

}

