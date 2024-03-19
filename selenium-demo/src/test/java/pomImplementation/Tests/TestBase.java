package pomImplementation.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;

    @BeforeSuite
    public void intitalize() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://www.facebook.com");

    }

    @AfterSuite
    public void LastStep() {
        driver.quit();
    }
}
