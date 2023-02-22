package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllProductsPage extends BasePage {

    private static final By LINK_TO_WOMEN_SECTION = By.xpath("//*[@id=\"category-3\"]/a");

    private List<Double> beforeFilterPriceList;
    private List<Double> afterFilterPriceList;

    public AllProductsPage(WebDriver driver) {
        super(driver);
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
