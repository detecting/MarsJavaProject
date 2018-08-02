package utilityPackage;

import java.security.PublicKey;
import java.time.Duration;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import com.google.common.base.Function;

import helperPackage.BrowserFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWait {
    //Method to FluentWait
//    public static void FluentWait(final String xPath, int timeout, int pollingtime) {
    public static void FluentWait(final String xPath) {
        Wait<WebDriver> fluentWait = new FluentWait<>( BrowserFactory.driver ).withTimeout( Duration.ofSeconds( 20 ) )
                .pollingEvery( Duration.ofMillis( 200 ) ).ignoring( NoSuchElementException.class );

//        WebElement elementName = fluentWait.until((Function<WebDriver, WebElement>) driver -> driver.findElement(By.xpath(xPath)));
        WebElement element = fluentWait.until( new Function<WebDriver, WebElement>() {
            @NullableDecl
            @Override
            public WebElement apply(@NullableDecl WebDriver webDriver) {
                return BrowserFactory.driver.findElement( By.xpath( xPath ) );
            }
        } );
    }

    public static void WaitForElements(String xPath) {
        WebElement element = (new WebDriverWait( BrowserFactory.driver, 20 )).until( ExpectedConditions.presenceOfElementLocated( By.xpath( xPath ) ) );
    }

    public static void WaitForUrl(String url) throws InterruptedException {
        while (!(BrowserFactory.driver.getCurrentUrl().contains( url ))) {
            Thread.sleep( 200 );
        }
    }
}


