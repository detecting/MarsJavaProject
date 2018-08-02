package pagesPackage;

import helperPackage.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilityPackage.CustomWait;

import java.util.List;

public class EditProfilePage {
    public EditProfilePage() {
        PageFactory.initElements( BrowserFactory.driver, this );
    }

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

    public void WorkType(String workType) {

        ArrowWorkType.click();
        CustomWait.WaitForElements( "/html[1]/body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]" );
        List<WebElement> lists = DdlWorkType.findElements( By.tagName( "div" ) );
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get( i ).getText()==workType){
                lists.get( i ).click();
                break;
            }

        }


//        Select lists = new Select( DdlWorkType );
//        List<WebElement> webElements = lists.getOptions();
//        for (WebElement webElement : webElements) {
//            if (webElement.getText()==workType){
//                webElement.click();
//            }
//        }
//        lists.selectByVisibleText( workType );

    }


}
