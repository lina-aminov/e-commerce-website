package PageObjects;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.cucumber.datatable.DataTable;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class AllProductsPage extends BasePage {

    private static final By ALL_PRODUCTS_BTN = By.xpath("//a[contains(@href,'category=2&controller=category')]");

    public AllProductsPage(WebDriver driver) {
        super(driver);
    }

    public void clickAllProductsBtn() {
        waitUntilVisible(ALL_PRODUCTS_BTN).click();
    }

    public void selectFilter(String key, String value) {
        WebElement selectFilter = driver.findElement(By.xpath("//h1[text()='" + key + "']/parent::section//li//a[contains(text(),'" + value + "')]"));
        selectFilter.click();
    }

    public void chooseFilters(DataTable filters) {
        Map<String, String> filtersMap = filters.asMap();
        for (Map.Entry<String, String> entry : filtersMap.entrySet()) {
            selectFilter(entry.getKey(), entry.getValue());
        }
    }

    public void checkFiltersDisplayed(String filter) {
        driver.findElement(By.cssSelector(".filter-block")).getText();
//        Assertions.assertEquals();
    }
}
