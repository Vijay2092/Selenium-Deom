package Practice;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.google.common.annotations.VisibleForTesting;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class FirstSeleniumScript {
    @Test
     public void test() throws InterruptedException {
         WebDriver driver = new ChromeDriver();
       //  WebDriver driver1 = new FirefoxDriver();
        // driver1.get("https://www.facebook.com/");
         //for scroll down and up
        JavascriptExecutor js = (JavascriptExecutor) driver;

         driver.get("https://www.amazon.in");
         String title = driver.getTitle();
         Assert.assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", title);
         driver.manage().deleteAllCookies();
         driver.manage().window().maximize();
         Thread.sleep(1000);
         driver.findElement(By.id("twotabsearchtextbox")).sendKeys("poco f1");
         Thread.sleep(3000);
         driver.findElement(By.id("nav-search-submit-button")).click();
         Thread.sleep(2000);


         //driver.navigate().to("https://www.google.com");
        // driver.navigate().back();
        //Thread.sleep(2000);
//         driver.findElement(By.name("field-keywords")).click();
//        Thread.sleep(2000);
        driver.findElement(By.linkText("Fresh")).click();
        Thread.sleep(2000);
        //driver.findElement(By.id("GLUXZipUpdateInput")).sendKeys("425001");
   //     driver.findElement(By.className("a-button-input")).click();
       driver.findElement(By.xpath("//*[@data-action='a-popover-close']")).click();
       js.executeScript("window.scrollBy(0,1200)");

       driver.navigate().to("https://www.facebook.com/");

        WebElement firstname = driver.findElement(By.name("email"));
        WebElement lastname = driver.findElement(By.name("pass"));
        sendKeys(driver, firstname, 10, "hii");
        Thread.sleep(1000);
        sendKeys(driver, lastname, 20, "bye");
        Thread.sleep(1000);

         System.out.println(driver.getTitle());
         driver.quit();

       //  driver.switchTo().alert().accept();
     }
     public static void sendKeys(WebDriver driver1 , WebElement element, int timeOut , String value){
       new WebDriverWait(driver1, Duration.ofSeconds(timeOut)).until(ExpectedConditions.visibilityOf(element));
       element.sendKeys(value);
     }

   //  @Test
     public void dragandDrop() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("http://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        WebElement  source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
         Actions action = new Actions(driver);
         try {
             Thread.sleep(2000);
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
         action.dragAndDrop(source,target).build().perform();
         Thread.sleep(3000);
         driver.quit();
     }

     @Test
     public void amazonProductChekout() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in");
         driver.manage().deleteAllCookies();
         String title = driver.getTitle();
         while (!"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in".equals(title)){
             driver.get("https://www.amazon.in");
             title = driver.getTitle();
         }

         driver.manage().window().maximize();
         Thread.sleep(1000);
         driver.findElement(By.id("twotabsearchtextbox")).sendKeys("deo");
         Thread.sleep(2000);
         driver.findElement(By.id("nav-search-submit-button")).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath("//section[ @aria-label=\"4 Stars & Up\"]")).click();
         Thread.sleep(2000);
        // try {

             driver.findElement(By.xpath("(//div[@class='a-section a-spacing-base'])[4]")).click();
             Thread.sleep(5000);
//         }catch (Exception e){
//             System.out.println("product not found");
//         }
         String curr = driver.getWindowHandle();
         Set<String> store = driver.getWindowHandles();
         for(String s : store){
             if(s!=curr){
                 driver.switchTo().window(s);
             }
         }
         driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
         Thread.sleep(1000);

         driver.findElement(By.xpath("//a[contains(text(),'Go to Cart')]")).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']")).click();
         Thread.sleep(3000);

         driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("patilvijaysing2092@gmail.com");
         driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
         Thread.sleep(3000);
         driver.findElement(By.id("ap_password")).sendKeys("Vijay@6767");
         driver.findElement(By.id("signInSubmit")).click();
        // driver.findElement(By.className("a-button-text")).click();
//         driver.close();
//         driver.switchTo().window(curr);
     }

     @Test
    public void Practice(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.instagram.com/");
        String expectedTitle = "Instagram";
        String actualTitle = driver.getTitle();
        Assert.assertEquals("Title is not correct",expectedTitle,actualTitle);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        //wait.until(ExpectedConditions.titleIs());
     }

     @Test
    public  void  paractice2login() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.browserstack.com/users/sign_up");

         driver.findElement(By.id("user_full_name")).sendKeys("username"); driver.findElement(By.id("user_email_login")).sendKeys("username.xyz.net");
         driver.findElement(By.id("user_password")).sendKeys("Your_Password");
         //input[@id='tnc_checkbox']
         driver.findElement(By.id("//input[@id='tnc_checkbox']")).click();
         driver.findElement(By.id("user_submit")).click();

         Thread.sleep(5000);

         Alert alert = driver.switchTo().alert(); // switch to alert

         String alertMessage= driver.switchTo().alert().getText(); // capture alert message

         System.out.println(alertMessage); // Print Alert Message
         Thread.sleep(5000);
         alert.accept();
     }

     @Test
     public void test2(){
         WebDriver driver = new ChromeDriver();
         Actions builder = new Actions(driver);
         JavascriptExecutor js = (JavascriptExecutor) driver;


         // Open Amazon website
         driver.get("https://www.amazon.com");
         String title = driver.getTitle();
         while (!"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in".equals(title)){
             driver.get("https://www.amazon.in");
             title = driver.getTitle();
         }
//
        WebElement account = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        builder.moveToElement(account).perform();

        driver.findElement(By.xpath("(//a[contains(text(), 'Start here')])[1]")).click();

//         js.executeScript("window.scrollBy(0,1200)");
//          driver.findElement(By.cssSelector("div > a[href='https://www.amazon.in/ap/register?openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fref%3Drhf_sign_in&openid.assoc_handle=inflex']")).click();
//
////
//         WebElement startHere = driver.findElement(By.linkText("Start here."));
//         startHere.click();

         // Fill out registration form
         WebElement nameField = driver.findElement(By.id("ap_customer_name"));
         nameField.sendKeys("Vijay");

         WebElement mobile = driver.findElement(By.id("ap_phone_number"));
         mobile.sendKeys("9175110533");

         WebElement passwordField = driver.findElement(By.id("ap_password"));
         passwordField.sendKeys("YourPassword");


         // Wait for the registration process to complete
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nav-link-accountList")));

         // Close the browser
         driver.quit();
     }

}


