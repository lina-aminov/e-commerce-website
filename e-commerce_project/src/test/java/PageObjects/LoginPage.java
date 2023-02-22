package PageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By AUTHENTICATION_FAILED_MESSAGE = By.cssSelector(".alert.alert-danger");


    public void clickSignUpLink() {
        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(@href,'authentication')]"));
        signUpLink.click();
    }
    public void clickSignInButton() {
        WebElement signInButton = driver.findElement(By.xpath("//div[@id='content-wrapper']//button[@class='btn btn-primary']"));
        signInButton.click();
    }

    public String getAuthenticationFailedMessage() {
        return driver.findElement(AUTHENTICATION_FAILED_MESSAGE).getText();
    }


}

