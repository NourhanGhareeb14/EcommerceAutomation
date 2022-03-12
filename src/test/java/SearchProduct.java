import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchProduct {
    WebDriver driver = null;

 SearchProductPage SearchProduct;

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
        SearchProduct =new SearchProductPage(driver);

    }
    @Test
    public void validData  () throws InterruptedException {
        driver.navigate().to("https://garnell-fe.vercel.app/");
        Thread.sleep(4000);

        driver.findElement(By.className("jss36")).click();
        SearchProduct.SearchSteps("Hot Dynamite Roll");

        String productName =  driver.findElement(By.className("jss36")).getText();
        String searchProductName =driver.findElement(By.xpath("//div[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-5 MuiGrid-grid-md-5 MuiGrid-grid-lg-5 css-1gp5d55')]/h3")).getText();
         Assert.assertEquals(searchProductName.contains(productName),true);
        Thread.sleep(4000);
       // Assert.assertEquals(driver.getCurrentUrl(),"https://garnell-fe.vercel.app/");

    }
@Test
    public void invalidData  () throws InterruptedException {
        driver.navigate().to("https://garnell-fe-git-search-notfound-id-clevershop.vercel.app/");
        Thread.sleep(4000);
        driver.findElement(By.className("jss36")).click();
        SearchProduct.SearchSteps("Hot Dynamite Roll k");
    Thread.sleep(4000);
       String expecetedResult ="please try searching using another term.";
        ///String productName =  driver.findElement(By.className("jss36")).getText();
        //String searchProductName =driver.findElement(By.className("jss93")).getText();
        String notFound= driver.findElement(By.id("searchNotFound")).getText();
      // String notFound=driver.findElement(By.className("jss96")).getText();
        Assert.assertEquals(notFound.contains(expecetedResult),true);
        Thread.sleep(4000);
        // Assert.assertEquals(driver.getCurrentUrl(),"https://garnell-fe.vercel.app/");

    }



    @AfterTest
    public void closeDriver () {
        //  driver.close();
        driver.quit();
    }


}
