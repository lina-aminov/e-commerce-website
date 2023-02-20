package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToHomePage() {
        driver.get("http://3.11.77.136/index.php");
    }

    public void clickSignIn() {
        WebElement signInButton = driver.findElement(By.xpath("//div[@class='user-info']/a"));
        signInButton.click();
    }
    public void clickSignUpLink() {
        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(@href,'authentication')]"));
        signUpLink.click();
    }
}