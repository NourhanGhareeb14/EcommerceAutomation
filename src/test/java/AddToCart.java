import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddToCart {

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
    //logged user can add to cart
    @Test
    public void validData  () throws InterruptedException {
        driver.navigate().to("https://garnell-fe.vercel.app/login");

        login.loginSteps("nourhanghareeb1@gmail.com","123456");
        Thread.sleep(4000);

         driver.navigate().to("https://garnell-fe.vercel.app/product/61f9118eb90e7e51297b5fba");
        Thread.sleep(2000);
         driver.findElement(By.id("addtoCart_productDetails")).click();
        Thread.sleep(2000);
        String expecetedResult ="Item added to cart successfully";
        String actualResult =driver.findElement(By.id("notistack-snackbar")).getText();
        Assert.assertEquals(actualResult.contains(expecetedResult),true);
        driver.findElement(By.className( "rc-input-number-handler-down")).click();
        Thread.sleep(2000);
        String expecetedResult2 ="Item removed from cart successfully";
        Thread.sleep(4000);
        String actualResult2 =driver.findElement(By.id("notistack-snackbar")).getText();
        System.out.println(actualResult2);
        Assert.assertEquals(actualResult2.contains(expecetedResult2),true);

        //  Thread.sleep(2000);


         //Assert.assertEquals(driver.getCurrentUrl(),"https://garnell-fe.vercel.app/");

    }

    @AfterTest
    public void closeDriver () {
        //  driver.close();
        driver.quit();
    }

}
