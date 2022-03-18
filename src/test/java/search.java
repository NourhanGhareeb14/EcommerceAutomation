import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Locale;

public class search {
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
        driver.findElement(By.id("small-searchterms")).click();
        driver.findElement(By.id("small-searchterms")).sendKeys("book");
        driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]")).click();
        Thread.sleep(4000);

        int count= driver.findElements(By.cssSelector("h2[class=\"product-title\"] a")).size();
        System.out.println(count);
        Assert.assertTrue(count>0);
        ArrayList   <String>  prodList=new ArrayList<String>();
        for(int x=0;x<count;x++){
            System.out.println(driver.findElements(By.cssSelector("h2[class=\"product-title\"] a")).get(x).getText());
            prodList.add(driver.findElements(By.cssSelector("h2[class=\"product-title\"] a")).get(x).getText());
             Assert.assertTrue(driver.findElements(By.cssSelector("h2[class=\"product-title\"] a")).get(x).getText().toLowerCase( ).contains("book"));
        }
        System.out.println(prodList);

    }




    @AfterTest
    public void closeDriver () {
        //  driver.close();
        driver.quit();
    }


}
