import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FilterByColor {
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
        driver.findElement(By.xpath("//*[text()='Apparel ']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/apparel");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()=' Shoes ']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/shoes");
        Thread.sleep(2000);
        driver.findElement(By.id("attribute-option-15")).click();
        Thread.sleep(2000);

        String expecetedResult = "adidas Consortium Campus 80s Running Shoes";
        String actualResult =driver.findElement(By.xpath("//*[text()='adidas Consortium Campus 80s Running Shoes']")).getText();
        Assert.assertEquals(actualResult.contains(expecetedResult),true);

    }

    @Test
    public void INvalidData  () throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//*[text()='Apparel ']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/apparel");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()=' Shoes ']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/shoes");
        Thread.sleep(2000);
        driver.findElement(By.id("attribute-option-15")).click();
        Thread.sleep(2000);

        String expecetedResult = "Nike Floral Roshe Customized Running Shoes";
        String actualResult =driver.findElement(By.xpath("//*[text()='adidas Consortium Campus 80s Running Shoes']")).getText();
        Assert.assertEquals(actualResult.contains(expecetedResult),false);

    }



    @AfterTest
    public void closeDriver () {
        //  driver.close();
        driver.quit();
    }


}
