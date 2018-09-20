package pages;

//import org.openqa.selenium.support.PageFactory;


import common.CommonFunctions;
import org.openqa.selenium.WebDriver;;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by User on 17/9/2018.
 */
public class LoginPage extends CommonFunctions {
    WebDriver driver;
    @FindBy(id = "username")
    private WebElement userName;
    @FindBy (id = "password")
    private WebElement password;
    @FindBy (id="Login")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }

    public void enterUserName(String userName){
        sendKeys(this.userName,userName);
    }

    public void enterPassword(String password){

        sendKeys(this.password, password);
    }

    public void  clickOnLoginBtn(){
        click(this.loginBtn);
    }
}
