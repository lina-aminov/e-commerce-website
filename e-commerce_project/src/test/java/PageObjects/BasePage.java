package PageObjects;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitAndClick(By selector) {
        wait.until(ExpectedConditions.elementToBeClickable(selector)).click();
    }

    public WebElement waitUntilVisible(By selector) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public void waitAndClickForStale(By selector) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selector));
        element.click();
        wait.until(ExpectedConditions.stalenessOf(element));


    }


}
