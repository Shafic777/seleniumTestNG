import com.paypal.selion.annotations.WebTest;
import completeActions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Created by User on 17/9/2018.
 */
public class FunctionTest extends Actions  {
    private static Logger LOG = LoggerFactory.getLogger(FunctionTest.class);
    @Test
    @WebTest
    public void scenerioOne(){
        LOG.info("inside test method");
        login();
        searchOnHomePage("srp_help_a9b5@testng.com");
        clickOnSearchRecord();
        hoverOnTopLinkByName("Opportunities");
        hoverOnTopLinkByName("Program Admission Documents");
        LOG.info("");
    }
}
