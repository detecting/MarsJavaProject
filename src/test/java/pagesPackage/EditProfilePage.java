package pagesPackage;

import helperPackage.BrowserFactory;
import org.apache.poi.hssf.record.PageBreakRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilityPackage.CustomWait;

import javax.swing.*;
import java.util.List;

public class EditProfilePage extends BasePage {
    public EditProfilePage() {
        PageFactory.initElements( BrowserFactory.driver, this );
    }

    //Input Work Type
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]")
    @CacheLookup
    private WebElement InputWorkType;
    //Work type DdlSelection
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/i[1]")
    @CacheLookup
    private WebElement ArrowWorkType;

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]")
    @CacheLookup
    private WebElement DdlWorkType;
    //Work Hours
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/i[1]")
    @CacheLookup
    private WebElement DdlWorkHours;
    //Work Payment
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[4]/div[1]/i[1]")
    @CacheLookup
    private WebElement DdlWorkPayment;

    public void WorkType(String workType) throws InterruptedException {

        Actions actions = new Actions( BrowserFactory.driver );

        actions.moveToElement( InputWorkType ).build().perform();
        CustomWait.WaitForElements( "/html[1]/body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]" );
        List<WebElement> lists = DdlWorkType.findElements( By.tagName( "div" ) );

//        for (int i = 0; i < lists.size(); i++) {
//            Thread.sleep( 500 );
//            if (lists.get( i ).getText().equals( workType.trim() )) {
//                ((JavascriptExecutor) BrowserFactory.driver).executeScript( "arguments[0].click();", lists.get( i ) );
//                break;
//            }
//        }
        for (WebElement webElement : DdlWorkType.findElements( By.tagName( "div" ) )) {
            Thread.sleep( 500 );
            if (webElement.getText().trim().equals( workType.trim() )) {
                ((JavascriptExecutor) BrowserFactory.driver).executeScript( "arguments[0].click();", webElement );
            }
        }

    }
}
