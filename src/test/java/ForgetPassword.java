import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ForgetPassword {
    WebDriver driver = null;

 ForgetPasswordModal forgetPassword;
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
        forgetPassword= new ForgetPasswordModal(driver);

    }
    @Test
    public void validData  () throws InterruptedException {
        driver.navigate().to("https://garnell-fe-git-search-notfound-id-clevershop.vercel.app/");
        driver.findElement(By.className("jss41")).click();
        Thread.sleep(4000);
        forgetPassword.forgetSteps("nourhanghareeb1@gmail.com");

        Thread.sleep(4000);
      //  Assert.assertEquals(driver.getCurrentUrl(),"https://garnell-fe.vercel.app/");
        String expecetedResult ="Verification Code Sent";
        String actualResult =driver.findElement(By.id("notistack-snackbar")).getText();
        Assert.assertEquals(actualResult.contains(expecetedResult),true);

    }
    @AfterTest
    public void closeDriver () {
        //  driver.close();
        driver.quit();
    }
}
