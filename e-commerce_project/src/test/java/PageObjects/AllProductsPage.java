package PageObjects;

import io.cucumber.datatable.DataTable;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AllProductsPage extends BasePage {

    private static final By ALL_PRODUCTS_BTN = By.xpath("//a[contains(@href,'category=2&controller=category')]");
    private static final By FILTER_TAGS_SECTION = By.xpath("//section[@id='js-active-search-filters']/ul");
    private static final ArrayList<String> expectedFilters = new ArrayList<>();
    private static final ArrayList<String> actualFilters = new ArrayList<>();

    public AllProductsPage(WebDriver driver) {
        super(driver);
    }

    public void clickAllProductsBtn() {
        waitUntilVisible(ALL_PRODUCTS_BTN).click();
    }

    public void selectFilter(String key, String value) {
        WebElement filter = driver.findElement(By.xpath("//h1[text()='" + key + "']/parent::section//li//a[contains(text(),'" + value + "')]"));
        filter.click();
        waitUntilStale(filter);
    }


    public void chooseFilters(DataTable filters) {
        Map<String, String> filtersMap = filters.asMap();

        for (Map.Entry<String, String> entry : filtersMap.entrySet()) {
            selectFilter(entry.getKey(), entry.getValue());
            expectedFilters.add(entry.getKey() + ": " + entry.getValue() + "\n" +
                    "\uE5CD");
        }

    }

    public void checkFiltersDisplayed() {

        WebElement liElements =  waitUntilVisible(FILTER_TAGS_SECTION);
        List<WebElement> ListFilters = liElements.findElements(By.tagName("li"));
        for(WebElement element : ListFilters){
            actualFilters.add(element.getText());
        }

        for (String filter : expectedFilters) {
            Assertions.assertTrue(actualFilters.contains(filter),"filter: "+filter+" was not found in the filter list");
        }
    }

}
