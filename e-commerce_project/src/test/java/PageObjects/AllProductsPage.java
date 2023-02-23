package PageObjects;

import io.cucumber.datatable.DataTable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class AllProductsPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(AllProductsPage.class);

    private static final By ALL_PRODUCTS_BTN = By.xpath("//a[contains(@href,'category=2&controller=category')]");
    private static final By FILTER_TAGS_SECTION = By.xpath("//section[@id='js-active-search-filters']/ul");
    private static final ArrayList<String> expectedFilters = new ArrayList<>();
    private static final ArrayList<String> actualFilters = new ArrayList<>();

    private static final By LINK_TO_WOMEN_SECTION = By.xpath("//*[@id=\"category-3\"]/a");

    private List<Double> beforeFilterPriceList;
    private List<Double> afterFilterPriceList;

    public AllProductsPage(WebDriver driver) {
        super(driver);
    }

    public void clickAllProductsBtn() {
        waitUntilVisible(ALL_PRODUCTS_BTN).click();
    }

    public void selectFilter(String key, String value) {
        logger.info("Select filter");
        WebElement filter = driver.findElement(By.xpath("//h1[text()='" + key + "']/parent::section//li//a[contains(text(),'" + value + "')]"));
        filter.click();
        waitUntilStale(filter);
    }


    public void chooseFilters(DataTable filters) {
        logger.info("Map filters");
        Map<String, String> filtersMap = filters.asMap();
        for (Map.Entry<String, String> entry : filtersMap.entrySet()) {
            selectFilter(entry.getKey(), entry.getValue());
            expectedFilters.add(entry.getKey() + ": " + entry.getValue() + "\n" +
                    "\uE5CD");
        }

    }

    public void checkFiltersDisplayed() {
        logger.info("Filter display");
        WebElement liElements = waitUntilVisible(FILTER_TAGS_SECTION);
        List<WebElement> ListFilters = liElements.findElements(By.tagName("li"));
        for (WebElement element : ListFilters) {
            actualFilters.add(element.getText());
        }

        for (String filter : expectedFilters) {
            Assertions.assertTrue(actualFilters.contains(filter), "filter: " + filter + " was not found in the filter list");
        }
    }


    public void captureProductPageValue() {
        //capture the values first
        List<WebElement> beforeTheFilterPrice = driver.findElements(By.xpath("//*[@id=\"js-product-list\"]/div/article//span[@class=\"price\"]"));
        // remove the dollar sign from the price and convert to string to double
        beforeFilterPriceList = new ArrayList<>();

        for (WebElement p : beforeTheFilterPrice) {
            beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
        }

        // print the captured values
        System.out.println("Before filter prices: " + beforeFilterPriceList);
    }

    public void filterFromLowToHigh() {
        //click the dropdown button to show the options
        WebElement dropdownButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-unstyle.select-title")));
        dropdownButton.click();

        //select the "Price, low to high" option
        WebElement lowToHighOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class, \"js-search-link\") and contains(., \"Price, low to high\")]")));
        lowToHighOption.click();

        //After filter capture the prices
        List<WebElement> afterFilterPrice = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".product-price-and-shipping .price")));

        //remove $ symbol from the price and convert the string to double
        afterFilterPriceList = new ArrayList<>();
        for (WebElement p : afterFilterPrice) {
            afterFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
        }

        // print out the sorted values
        Collections.sort(afterFilterPriceList);
        System.out.println("After filter prices: " + afterFilterPriceList);
    }


    public void assertTheValues() {
        //Assert the values
        Collections.sort(beforeFilterPriceList); // it will sort the values of the list
        Assert.assertEquals(beforeFilterPriceList, afterFilterPriceList);
    }

    public void clickOnTheLink() {
        waitAndClick(LINK_TO_WOMEN_SECTION);
        waitUntilVisible(By.cssSelector("h1.h1"));


    }

}
