import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ForgetPasswordModal {



    WebDriver driver;
    //constructor to avoid redundancey of passing driver
    public ForgetPasswordModal(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }



    public WebElement emailElement ( ) {
        By email=By.id("forgotForm");
        WebElement emailElement=  driver.findElement(email);
        return emailElement;
    }
    public void forgetSteps( String email ){

        ////// //Enter all values using design Pom
        emailElement().sendKeys(email);

      //  emailElement().clear();


        emailElement().sendKeys(Keys.ENTER);




    }

}
