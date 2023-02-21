package PageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {


    private static final By DELETE_ITEM_BTN = By.cssSelector("a.remove-from-cart");
    private static final By NO_ITEM_MSG = By.cssSelector("span.no-items");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void checkEmptyCartMSG(String message) {
        Assertions.assertEquals(message, waitUntilVisible(NO_ITEM_MSG).getText());
    }

    public void clickDeleteItemBtn() {
        driver.findElement(DELETE_ITEM_BTN).click();

    }

}
