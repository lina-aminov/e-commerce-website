package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(CartPage.class);

    private static final By DELETE_ITEM_BTN = By.cssSelector("a.remove-from-cart");
    private static final By NO_ITEM_MSG = By.cssSelector("span.no-items");
    private static final By QUANTITY_ITEM_UP = By.xpath("//button[@type ='button']//i[@class='material-icons touchspin-up']");
    private static final By QUANTITY_ITEM_DOWN = By.xpath("//button[@type ='button']//i[@class='material-icons touchspin-down']");
    private static final By QUANTITY_FIELD = By.xpath("//input[@class='js-cart-line-product-quantity form-control']");
    private static final By PRODUCT_PRICE = By.xpath("//div[@class='cart-overview js-cart']//span[@class='product-price']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void checkEmptyCartMSG(String message) {
        logger.info("Check empty cart");
        Assertions.assertEquals(message, waitUntilVisible(NO_ITEM_MSG).getText());
    }

    public void clickDeleteItemBtn() {
        logger.info("Click delete items");
        driver.findElement(DELETE_ITEM_BTN).click();
    }

    public void clickChangeQuantity(int quantity) {
        logger.info("Click change quantity");
        for (int i = 1; i <= quantity; i++) {
            //click the button
            waitAndClickForStale(QUANTITY_ITEM_UP);
        }
    }

    public void clickOnDownButton(int quantity) {
        logger.info("Click on down button");
        for (int i = 0; i <= 1; i++) {
            //click the button
            driver.findElement(QUANTITY_ITEM_DOWN);
            waitAndClick(QUANTITY_ITEM_DOWN);
        }
    }

    public void checkItemQuantity(int quantity) {
        logger.info("Click item quantity");
        String quantityField = driver.findElement(QUANTITY_FIELD).getAttribute("value");
        Assertions.assertEquals(Integer.toString(quantity), quantityField);
    }

    public void addManuallyQuantity(int num) {
        logger.info("Add manually quantity");
        WebElement element = driver.findElement(QUANTITY_FIELD);
        element.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), Integer.toString(num));
        //quantity field requires clicking off-input
        waitAndClick(PRODUCT_PRICE);
    }

}
