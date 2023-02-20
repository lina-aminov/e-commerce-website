package StepDefinitions;

import PageObjects.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver driver;

    @BeforeAll
    public static void beforeAll(){
        System.out.println("I am a before all");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Before
    public void before(){
        System.out.println("I am running before each scenario");

    }

    @After
    public void after(){
        System.out.println("I am running after each scenario");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("I am an after all");
//        driver.quit();
        driver = null;
    }
}
