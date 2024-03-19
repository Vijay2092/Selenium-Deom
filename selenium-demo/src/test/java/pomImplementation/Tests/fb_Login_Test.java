package pomImplementation.Tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import pomImplementation.pages.fbHomePage;
import pomImplementation.pages.fbLoginPage;


public class fb_Login_Test extends TestBase {

    @Test
    public void allAndOperation() throws InterruptedException {
        fbLoginPage loginPage = new fbLoginPage(driver);
        loginPage.setEmail("abc@gmail.com");
        Thread.sleep(2000);
        loginPage.setPassword("abcd");
        Thread.sleep(2000);
        loginPage.clickLoginButton();
       // fbHomePage homepage = PageFactory.initElements(driver, fbHomePage.class);
    }
}
