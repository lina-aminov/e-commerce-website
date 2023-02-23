package PageObjects;


import io.cucumber.datatable.DataTable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;


public class RegistrationPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(RegistrationPage.class);

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }


    private static final By FULL_NAME_HEADER = By.xpath("//a[@class='account']/span");
    private static final By INVALID_NAME_MESSAGE = By.cssSelector(".alert.alert-danger");
    private static final By INVALID_EMAIL_FORMAT_MESSAGE = By.cssSelector(".alert.alert-danger");
    private static final By ALREADY_REGISTERED_MESSAGE = By.cssSelector(".alert.alert-danger");


    public void enterAccountDetails(DataTable accountDetails) {
        logger.info("Enter account details");
        Map<String, String> accountDetailsMap = accountDetails.asMap();
        for (Map.Entry<String, String> entry : accountDetailsMap.entrySet()) {
            if (entry.getKey().equals("Social title")) {
                WebElement socialTitle = (driver.findElement(By.xpath("//input[@name='id_gender']")));
                socialTitle.click();
            } else {
                String fieldName = entry.getKey().toLowerCase().replace(" ", "");
                inputText(By.name(fieldName), entry.getValue());
            }
        }
    }

    public void clickSaveButton() {
        logger.info("Click save button");
        WebElement saveButton = driver.findElement(By.cssSelector(".form-control-submit"));
        saveButton.click();
    }

    public String getFullName() {
        return driver.findElement(FULL_NAME_HEADER).getText();
    }

    public String getInvalidNameMessage() {
        return driver.findElement(INVALID_NAME_MESSAGE).getText();
    }

    public String getInvalidFormatMessage() {
        return driver.findElement(INVALID_EMAIL_FORMAT_MESSAGE).getText();
    }

    public String getAlreadyRegisteredMessage() {
        return driver.findElement(ALREADY_REGISTERED_MESSAGE).getText();
    }
}

