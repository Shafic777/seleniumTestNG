package pages;

import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by User on 20/9/2018.
 */
public class HomePageSearchResult extends CommonFunctions {
    @FindBy(xpath = "//div[@id='Contact_body']")
    private WebElement searchResult;
    private List<WebElement> searchResultList;
    private WebElement searchResultRecord;

    public HomePageSearchResult(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public int getNumberOfSearchResult() {
        searchResultList = searchResult.findElements(By.xpath(".//tr[contains(@class,'dataRow')]"));
        isDisplayed(searchResultList);
        return searchResultList.size();
    }

    /**
     *  After calling this method this will give you the access to the row of a record
     * @param rowIndex this will start from 1. 0 is not valid row
     * @return
     */
    public RowRecord getRowByIndex(int rowIndex) {
        if (rowIndex<=0){
            rowIndex=1;
        }
        searchResultRecord = searchResult.findElement(By.xpath(".//tr[contains(@class,'dataRow')][position()=" + rowIndex + "]"));
        return new RowRecord(searchResultRecord);
    }

    public class RowRecord {
        private WebElement searchResultRow;
        private WebElement cellValue;

        /**
         ** Constructor. don't think too much Shafic :P let me know when you read this
         * @param row
         */
        public RowRecord(WebElement row) {
            this.searchResultRow = row;
        }

        /**
         * This will perform the click on search result table's cell e.g Edit, University Name
         * @param columName Name of Column e.g Action , Name
         */
        public void clickOnCellByColumnName(String columName) {
            click(getCellTdElement(columName));
        }

        /**
         * this will return you the value of a table cell e.g phone number or email
         * @param columnName This should be the exact name of table column
         * @return will return the value of cell
         */

        public String cellValueByColumnName(String columnName) {
            return getText(getCellTdElement(columnName));
        }

        private WebElement getCellTdElement(String columName) {
            switch (columName) {
                case "Action":
                    cellValue = searchResultRow.findElement(By.xpath(".//td[contains(@class,'actionColumn')]"));
                    break;
                case "Name":
                    cellValue = searchResultRow.findElement(By.xpath(".//th[contains(@class,'dataCell')]"));
                    break;
                case "Organization Name":
                    cellValue = searchResultRow.findElement(By.xpath(".//td[contains(@class,'dataCell')][position()=2]"));
                    break;
                case "Email":
                    cellValue = searchResultRow.findElement(By.xpath(".//td[contains(@class,'dataCell')][position()=3]"));
                    break;
                case "Phone":
                    cellValue = searchResultRow.findElement(By.xpath(".//td[contains(@class,'dataCell')][position()=4]"));
                    break;
                case "Student ID":
                    cellValue = searchResultRow.findElement(By.xpath(".//td[contains(@class,'dataCell')][position()=5]"));
                    break;
                case "Mobile":
                    cellValue = searchResultRow.findElement(By.xpath(".//td[contains(@class,'dataCell')][position()=6]"));
                    break;
                case "Home Phone":
                    cellValue = searchResultRow.findElement(By.xpath(".//td[contains(@class,'dataCell')][position()=7]"));
                    break;
                case "Work Phone":
                    cellValue = searchResultRow.findElement(By.xpath(".//td[contains(@class,'dataCell')][position()=8]"));
                    break;
            }
            return cellValue;
        }

    }
}
