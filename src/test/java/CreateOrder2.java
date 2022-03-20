import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateOrder2 {
    WebDriver driver = null;

    @BeforeTest
    public void openBrowser () throws InterruptedException {
        //1.bridge between test script and browser
        String chromPath =System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromPath);
        System.setProperty("webdriver.chrome.driver", chromPath);
        //2. create new obj of brwoser
        //////////wrong/////// WebDriver driver= new ChromeDriver();
        driver= new ChromeDriver();

        //3.Navigate to url, and maxmize the view and stay for 3 second
        driver.manage().window().maximize();
        Thread.sleep(4000);


    }
    @Test
    public void validData  () throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/");

         driver.findElement(By.cssSelector("a[href=\"/login?returnUrl=%2F\"]")).click();


        driver.findElement(By.id("Email")).sendKeys("n.ghareeb@qpix.io");
        driver.findElement(By.id("Password")).sendKeys("12345678");
       driver.findElement(By.id("Password")).sendKeys(Keys.ENTER);
        driver.navigate().to("https://demo.nopcommerce.com/apple-macbook-pro-13-inch");
        //https://demo.nopcommerce.com/apple-macbook-pro-13-inch
      driver.findElement(By.xpath("//*[text()='Add to cart']")).click();
        Thread.sleep(3000);
        driver.navigate().to("https://demo.nopcommerce.com/cart");
       driver.findElement(By.id("termsofservice")).click();
        Thread.sleep(3000);
       driver.findElement(By.id("checkout")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/onepagecheckout#opc-billing");
        driver.findElement(By.name("save")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/onepagecheckout#opc-shipping_method");
        driver.findElement(By.id("shipping-method-buttons-container")).click();
        Thread.sleep(3000);
         driver.findElement(By.id("payment-method-buttons-container")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("payment-info-buttons-container")).click();
        Thread.sleep(3000);
       driver.findElement(By.id("confirm-order-buttons-container")).click();
        Thread.sleep(3000);






    }



    @AfterTest
    public void closeDriver () {
        //  driver.close();
        driver.quit();
    }

}
