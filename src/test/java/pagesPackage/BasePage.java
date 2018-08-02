package pagesPackage;

import helperPackage.BrowserFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public BasePage() {
        BrowserFactory.driver.manage().timeouts().implicitlyWait( 50, TimeUnit.SECONDS );
    }

    public static String GetDateAndTime() {
        return new SimpleDateFormat( "yyyy-MM-dd_HH-mm-ss" ).format( new Date() );
    }

}
