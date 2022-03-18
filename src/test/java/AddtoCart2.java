import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddtoCart2 {
    WebDriver driver=null;

    LoginPage login;

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

        //4. create new object
        login=new LoginPage(driver);

    }

    @Test
    public void validData  () throws InterruptedException {

        driver.navigate().to("https://demo.nopcommerce.com/apple-macbook-pro-13-inch ");
      driver.findElement(By.xpath("//*[text()='Add to cart']")).click();
        Thread.sleep(3000);
        driver.navigate().to("https://demo.nopcommerce.com/cart");
        Thread.sleep(2000);
        String expecetedResult ="Apple MacBook Pro 13-inch";
        String actualResult = driver.findElement(By.className("product-name")).getText();
        System.out.println( driver.findElement(By.className("product-name")).getText());

        Assert.assertEquals(actualResult.contains(expecetedResult),true);

    }
    @AfterTest
    public void closeDriver () {
        //  driver.close();
        driver.quit();
    }

}
