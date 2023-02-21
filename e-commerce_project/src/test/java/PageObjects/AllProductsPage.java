package PageObjects;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllProductsPage extends BasePage{

    private static final By ALL_PRODUCTS_BTN = By.xpath("//a[contains(@href,'category=2&controller=category')]");

    public AllProductsPage(WebDriver driver) {
        super(driver);
    }

    public void clickAllProductsBtn(){
        waitUntilVisible(ALL_PRODUCTS_BTN).click();
    }

    public void clickColorFilter(String color) {
        WebElement selectColor = driver.findElement(By.xpath("//a[contains(text(),'"+color+"')]"));
        selectColor.click();
    }
}
