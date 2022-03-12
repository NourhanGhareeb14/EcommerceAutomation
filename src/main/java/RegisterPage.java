import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {


    WebDriver driver;
    //constructor to avoid redundancey of passing driver
    public RegisterPage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    public WebElement nameElement ( ) {
        By name=By.name("name");
        WebElement  nameElement=  driver.findElement(name);
        return nameElement;
    }

    public WebElement emailElement ( ) {
        By email=By.name("email");
        WebElement emailElement=  driver.findElement(email);
        return emailElement;
    }

    public WebElement phoneElement ( ) {
        By phone=By.name("phone");
        WebElement phoneElement=  driver.findElement(phone);
        return phoneElement;
    }
    public WebElement passwordElement ( ) {
        By password=By.name("password");
        WebElement passwordElement=  driver.findElement(password);
        return passwordElement;
    }
    public WebElement password2Element ( ) {
        By password2=By.name("password2");
        WebElement password2Element=  driver.findElement(password2);
        return password2Element;
    }
//    public WebElement acceptElement ( ) {
//        By accept=By.name("accept");
//        WebElement acceptElement=  driver.findElement(accept);
//        return acceptElement;
//    }

     public void RegisterSteps( String name, String email ,String phone,String password, String password2){

        ////// //Enter all values using design Pom

        nameElement().sendKeys(name);
        emailElement().sendKeys(email);
        phoneElement().sendKeys(phone);
        passwordElement().sendKeys(password);
        password2Element().sendKeys(password2);
        //////Enter password using design Pom
         passwordElement().sendKeys(Keys.ENTER);
       // acceptElement().click();


    }
}
