package PageObjects;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;



public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void enterAccountDetails(DataTable accountDetails){
        Map<String, String> accountDetailsMap = accountDetails.asMap();
        for (Map.Entry<String, String> entry : accountDetailsMap.entrySet()) {
            if (entry.getKey().equals("Social title")) {
                WebElement socialTitle = (driver.findElement(By.xpath("//input[@name='id_gender']")));
                socialTitle.click();
            } else {
                String fieldName = entry.getKey().toLowerCase().replace(" ", "");
                WebElement inputField = driver.findElement(By.name(fieldName));
                inputField.clear();
                inputField.sendKeys(entry.getValue());
            }
        }
    }
    public void clickSaveButton() {
        WebElement saveButton = driver.findElement(By.cssSelector(".form-control-submit"));
        saveButton.click();
    }
}

