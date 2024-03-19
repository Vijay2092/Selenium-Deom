package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class facebookByDataProvider {

    @Test(dataProvider = "testData")
    public void checkData(String uname, String password) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.facebook.com");

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(uname);
        Thread.sleep(2000);

        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(password);
        Thread.sleep(2000);


        driver.quit();
    }

    @DataProvider(name = "testData")
    public Object[][] testDataFeed() {
        Object[][] facebook = new Object[2][2];
        facebook[0][0] = "user1@gmail.com";
        facebook[0][1] = "pass1";

        facebook[1][0] = "user2@gmail.com";
        facebook[1][1] = "pass2";

        return facebook;
    }
}
