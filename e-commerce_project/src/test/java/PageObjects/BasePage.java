package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract class BasePage {

    private static final Logger logger = LogManager.getLogger(BasePage.class);

    WebDriver driver;
    WebDriverWait wait;

    BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitAndClick(By selector) {
        logger.info("Wait and click");
        wait.until(ExpectedConditions.elementToBeClickable(selector)).click();
    }
    public WebElement waitUntilVisible(By selector) {
        logger.info("Wait until visible");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public void inputText(By locator, String text) {
        logger.info("Input text email");
        WebElement inputField = driver.findElement(locator);
        inputField.clear();
        if (text.equals("UNIQUE_EMAIL")) {
            text = "registrationemail" + getRandomNumber() + "@test" + getRandomNumber() + ".com";
        }
        inputField.sendKeys(text);
    }

    public int getRandomNumber() {
        logger.info("get random number");
        int min = 1;
        int max = 100000;
        int range = max - min + 1;
        return (int) (Math.random() * range) + min;
    }

    void findAndType(By elementSelector, String inputString) {
        logger.info("Find and type");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementSelector));
        element.sendKeys(inputString);
    }

    public void waitUntilStale(WebElement selector) {
        logger.info("Wait until Stale");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selector));
        element.click();
        wait.until(ExpectedConditions.stalenessOf(element));
    }

}
