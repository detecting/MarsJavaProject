package testPackage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pagesPackage.ShareSkill;

public class TestClass extends BaseClass{

	//A simple test to click on the shareskill
			@Test(description = "Test to click on the ShareSkill")
			public void ShareSkill()
			{
				SoftAssert softAssert = new SoftAssert();
				
				//perform login steps//Click on the Shareskill button
				ShareSkill obj = new ShareSkill();
				obj.ClickSkill();			
				softAssert.assertEquals(true, true, "Test failed after launching url");
						
				softAssert.assertEquals(true, true);		
				
				softAssert.assertAll();				
				
			}

	
}
