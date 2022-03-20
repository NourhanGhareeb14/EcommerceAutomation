import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChangeCategory {

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
        driver.findElement(By.xpath("//*[text()='Digital downloads ']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/digital-downloads");
        Thread.sleep(2000);
       // driver.navigate().to("https://demo.nopcommerce.com/");
       // Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Jewelry ']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/jewelry");

        //  Assert.assertEquals(driver.getCurrentUrl(),"https://garnell-fe.vercel.app/");   Jewelry

    }



    @AfterTest
    public void closeDriver () {
        //  driver.close();
        driver.quit();
    }

}