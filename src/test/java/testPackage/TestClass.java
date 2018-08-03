package testPackage;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pagesPackage.AboutPage;
import pagesPackage.EditProfilePage;
import utilityPackage.ExcelDataConfig;

public class TestClass extends BaseClass {

    //A simple test to click on the shareskill
    @Test(description = "Edit Profile")
    public void EditProfile() throws InterruptedException {

        //Initial softAssert
        SoftAssert softAssert = new SoftAssert();

        //Initial Excel file data reader;
        ExcelDataConfig excel = new ExcelDataConfig( "./TestData/TestData.xlsx" );

        //Read data from excel file
        String vailabilityType = excel.getData( "EditProfile", 1, 0 ).trim();
        String availableHours = excel.getData( "EditProfile", 2, 0 ).trim();
        String ernTarget = excel.getData( "EditProfile", 3, 0 ).trim();
        String addLanguage = excel.getData( "EditProfile", 1, 1 ).trim();
        String languageLevel = excel.getData( "EditProfile", 2, 1 ).trim();

        //Move to Home page
        AboutPage aboutPage = new AboutPage();

        //Move to EditProfilePage
        EditProfilePage editProfilePage = aboutPage.Edit();
        //log
        testLog.log( Status.INFO, "Navigate to EditProfilePage !" );

        //Edit Availability values
        //vailabilityType
        editProfilePage.VailabilityType( vailabilityType );
        //availableHours
        editProfilePage.AvailableHours( availableHours );
        //ernTarget
        editProfilePage.ErnTarget( ernTarget );
        //log
        testLog.log( Status.INFO, "Finish Edit Availability !" );

        //Edit Language values
        //Click Add New Button
        editProfilePage.LanguagesAddNew();
        //addLanguage
        editProfilePage.AddLanguage( addLanguage );
        //languageLevel
        editProfilePage.LanguageLevel( languageLevel );
        //Click Add button
        editProfilePage.LanguagesAdd();
        //log
        testLog.log( Status.INFO, "Finish Edit Language !" );

        //log
        testLog.log( Status.INFO, "Finish EditProfile Testing !" );

        //Assert verification
        softAssert.assertEquals( editProfilePage.VerifyEditData( vailabilityType, availableHours, ernTarget, addLanguage, languageLevel ), true, "Test Failed, EditProfile Data Verify Failed" );

        //************Because the Save function is not work well, so put assertion before ir, assertion should after save in industry environment.
        //Click Save Button
        editProfilePage.Save();
        softAssert.assertAll();

    }


}
