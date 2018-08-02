package testPackage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pagesPackage.AboutPage;
import pagesPackage.EditProfilePage;
import pagesPackage.ShareSkillPage;
import utilityPackage.ExcelDataConfig;

public class TestClass extends BaseClass {

    //A simple test to click on the shareskill
    @Test(description = "Edit Profile")
    public void EditProfile() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        ExcelDataConfig excel = new ExcelDataConfig( "./TestData/TestData.xlsx" );
//        excel.getData( "Login", 1, 0 )


        //perform login steps//Click on the Shareskill button
//        ShareSkillPage obj = new ShareSkillPage();
//        obj.ClickSkill();

//        softAssert.assertEquals( true, true, "Test failed after launching url" );
        AboutPage aboutPage = new AboutPage();
        EditProfilePage editProfilePage = aboutPage.Edit();
        editProfilePage.WorkType( excel.getData( "EditProfile", 1, 0 ) );


        softAssert.assertAll();

    }


}
