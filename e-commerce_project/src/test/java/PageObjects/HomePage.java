package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class HomePage extends BasePage {

    private By PRODUCT_ADDED_CONFIRMATION = By.xpath("//h4[contains(text(), 'Product successfully added to your shopping cart')]");
    private By ADD_TO_CART = By.xpath("//button[@class='btn btn-primary add-to-cart']");

    private By CHECKOUT_BUTTON = By.cssSelector("div.cart-content-btn a.btn-primary");

    private By BLOUSE_LINK = By.xpath("//a[contains(@href, 'rewrite=blouse')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToHomePage() {
        driver.get("http://3.11.77.136/index.php");
    }

    public void clickOnProduct() {
        WebElement blouseImage = driver.findElement(By.xpath("//img[@alt='Blouse']"));
        blouseImage.click();
    }

    public void addToCart() {
        WebElement addButton = driver.findElement(ADD_TO_CART);
        addButton.click();
    }

    public void productAddedConfirmation() {
        WebElement addedConfirmation = driver.findElement(PRODUCT_ADDED_CONFIRMATION);
        assertTrue(addedConfirmation.isDisplayed());

    }

    public void clickProceedToCheckout() {
        waitAndClick(CHECKOUT_BUTTON);
    }

    public void checkOutPageConfirmation() {
        WebElement addedConfirmation = driver.findElement(BLOUSE_LINK);
        assertTrue(addedConfirmation.isDisplayed());

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