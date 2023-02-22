package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class HomePage extends BasePage {
    private static final Logger logger = LogManager.getLogger(HomePage.class);

    private By PRODUCT_ADDED_CONFIRMATION = By.xpath("//h4[contains(text(), 'Product successfully added to your shopping cart')]");
    private By ADD_TO_CART = By.xpath("//button[@class='btn btn-primary add-to-cart']");

    private By CHECKOUT_BUTTON = By.cssSelector("div.cart-content-btn a.btn-primary");

    private By BLOUSE_LINK = By.xpath("//a[contains(@href, 'rewrite=blouse')]");
    private static final By PRODUCT = By.xpath("//img[@alt='Printed Dress']");

    private static final By QUANTITY_ITEM_UP = By.xpath("//button[@type ='button']//i[@class='material-icons touchspin-up']");
    private static final By INPUT_QUANTITY_BOX = By.xpath("//input[@name='qty']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToHomePage() {
        driver.get("http://3.11.77.136/index.php");
    }

    public void clickOnProduct() {
        logger.info("Clicking on product");
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
    public void clickOnThirdProduct(int model) {
        WebElement element = driver.findElement(PRODUCT);
        element.click();

    }

    public void clickChangeQuantityHomePage(int clicks) {
        for (int i = 0; i <= 9; i++){
            //click the button
             driver.findElement(QUANTITY_ITEM_UP).click();
            //wait 2 seconds
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
    public void addingProductQuantity(int product) {
        String element = driver.findElement(INPUT_QUANTITY_BOX).getAttribute("value");
        Assertions.assertEquals(Integer.toString(product), element);

    }
}
