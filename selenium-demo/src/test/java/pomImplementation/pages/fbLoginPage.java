package pomImplementation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class fbLoginPage {

    WebDriver driver;
   WebDriverWait wait;
    public  fbLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
  //  WebDriver driver = new ChromeDriver();

    @FindBy(xpath = "//input[@class='inputtext _55r1 _6luy']")
    WebElement emailTextBox;
    @FindBy(id ="pass") WebElement passTextBox;
    @FindBy(xpath = "//button[@class='_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy']") WebElement signInButton;


    public void setEmail(String mail){
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(emailTextBox));
       emailTextBox.sendKeys(mail);
    }
    public void setPassword(String pass){
        passTextBox.sendKeys(pass);
    }
    public void clickLoginButton(){
        signInButton.click();
    }

}
