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

    public WebElement usernameElement ( ) {
        By username=By.xpath("(//input[@type=\"email\"])");
        WebElement  usernameElement=  driver.findElement(username);
        return usernameElement;
    }


    public void forgetSteps( String email ){

        ////// //Enter all values using design Pom
         usernameElement().sendKeys(email);

      //  emailElement().clear();


        usernameElement().sendKeys(Keys.ENTER);




    }

}
