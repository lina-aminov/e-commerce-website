package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

abstract class BasePage {
    WebDriver driver;

    BasePage(WebDriver driver){
        this.driver = driver;
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

}
