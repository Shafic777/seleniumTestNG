package common;

import com.paypal.selion.annotations.WebTest;
import com.paypal.selion.platform.grid.Grid;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Created by User on 20/9/2018.
 */
public class BaseClass {
    protected static WebDriverWait wait;
    public static RemoteWebDriver driver;
    public static int explictWait =20; // This will be moved to property File
    public RemoteWebDriver getWebDriver(){
        driver = Grid.driver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,explictWait);
        return Grid.driver();
    }
}
