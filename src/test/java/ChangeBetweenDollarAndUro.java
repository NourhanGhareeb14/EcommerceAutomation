import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChangeBetweenDollarAndUro {

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

        //4. create new object
        //login =new LoginPage(driver);

    }
    @Test
    public void validData  () throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/");
        Select Currency = new Select(driver.findElement(By.id("customerCurrency")));
        Currency.selectByVisibleText("Euro");
        Thread.sleep(2000);

        Select Currency2 = new Select(driver.findElement(By.id("customerCurrency")));
        Currency2.selectByVisibleText("US Dollar");
        Thread.sleep(2000);
      //  Assert.assertEquals(driver.getCurrentUrl(),"https://garnell-fe.vercel.app/");

    }



    @AfterTest
    public void closeDriver () {
        //  driver.close();
        driver.quit();
    }


}
