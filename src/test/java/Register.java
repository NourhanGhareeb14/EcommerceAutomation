import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Register {

 WebDriver driver=null;
  RegisterPage register;
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
         register=new RegisterPage(driver);

    }
    @Test
    public void validData  () throws InterruptedException {
        driver.navigate().to("https://garnell-fe.vercel.app/signup");
         register.RegisterSteps("nyrra","nayra@qpix.io","01110811111","12345678","12345678");
        driver.findElement(By.name("accept")).isSelected();
        //button//driver.findElement(By.className("jss57 jss58"));
         Thread.sleep(4000);
        //Assert.assertEquals(driver.getCurrentUrl(),"https://garnell-fe.vercel.app/");

    }
// Verify invalid email address error.
@Test
    public void invalidEmail  () throws InterruptedException {
        driver.navigate().to("https://garnell-fe.vercel.app/signup");
         register.RegisterSteps("nyrra","nayra","01110811111","12345678","12345678");
        driver.findElement(By.name("accept")).isSelected();
        //button//driver.findElement(By.className("jss57 jss58"));
        Thread.sleep(4000);
        String expecetedResult ="Invalid email";
        String actualResult =driver.findElement(By.className("jss54")).getText();
        Assert.assertEquals(actualResult.contains(expecetedResult),true);
    }
    //Verify invalid phone address error.
    @Test
    public void invalidPhone  () throws InterruptedException {
        driver.navigate().to("https://garnell-fe.vercel.app/signup");
        register.RegisterSteps("nyrra","nayra@qpix.io","12","12345678","12345678");
        driver.findElement(By.name("accept")).isSelected();
        //button//driver.findElement(By.className("jss57 jss58"));
        Thread.sleep(4000);
        String expecetedResult ="Invalid phone number";
        String actualResult =driver.findElement(By.className("jss54")).getText();
        Assert.assertEquals(actualResult.contains(expecetedResult),true);
    }
    //Verify required filed error.
    @Test
    public void invalidRquiredFeiled  () throws InterruptedException {
        driver.navigate().to("https://garnell-fe.vercel.app/signup");
        register.RegisterSteps("","","","","");
        driver.findElement(By.name("accept")).isSelected();
        //button//driver.findElement(By.className("jss57 jss58"));
        Thread.sleep(4000);
         String expecetedResult ="Enter your name";
         String actualResult =driver.findElement(By.className("jss54")).getText();
         Assert.assertEquals(actualResult.contains(expecetedResult),true);
    }


    @AfterTest
    public void closeDriver () {
        //  driver.close();
        driver.quit();
    }
}
