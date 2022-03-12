import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchProductPage {
    WebDriver driver;
    //constructor to avoid redundancey of passing driver
    public SearchProductPage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

//site-search
    public WebElement nameElement ( ) {
        By name=By.id("site-search");
        WebElement  nameElement=  driver.findElement(name);
        return nameElement;
    }



    public void SearchSteps( String name ){

        ////// //Enter all values using design Pom

        nameElement().sendKeys(name);



    }
}
