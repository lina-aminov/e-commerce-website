package PageObjects;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
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

    BasePage(WebDriver driver){
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

    public void inputText(By locator, String text) {
        WebElement inputField = driver.findElement(locator);
        inputField.clear();
        if (text.equals("UNIQUE_EMAIL")) {
            text = "registrationemail" + getRandomNumber() + "@test" + getRandomNumber() + ".com";
        }
        inputField.sendKeys(text);
    }

    public int getRandomNumber() {
        int min = 1;
        int max = 100000;
        int range = max - min + 1;
        return (int) (Math.random() * range) + min;
    }

    void findAndType(By elementSelector, String inputString) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementSelector));
        element.sendKeys(inputString);
    }

    public void waitUntilStale(WebElement element) {
        wait.until(ExpectedConditions.stalenessOf(element));
    }

}
