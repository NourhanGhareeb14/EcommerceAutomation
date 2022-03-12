import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Login {
    WebDriver driver = null;

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
        login =new LoginPage(driver);

    }

    @Test
    public void validData  () throws InterruptedException {
        driver.navigate().to("https://garnell-fe.vercel.app/login");
        login.loginSteps("nourhanghareeb1@gmail.com","123456");
        Thread.sleep(4000);
         Assert.assertEquals(driver.getCurrentUrl(),"https://garnell-fe.vercel.app/");

    }
    @Test
    public void invalidData () throws InterruptedException {
        driver.navigate().to("https://garnell-fe.vercel.app/login");
        login.loginSteps("nourhan@gmail.com","123456");
        Thread.sleep(4000);

        Assert.assertEquals(driver.getCurrentUrl(),"https://garnell-fe.vercel.app/login");

       String expecetedResult ="invalid credentials";
        String actualResult =driver.findElement(By.className("SnackbarItem-message")).getText();
        Assert.assertEquals(actualResult.contains(expecetedResult),true);

    }
    @AfterTest
    public void closeDriver () {
        //  driver.close();
        driver.quit();
    }
}









