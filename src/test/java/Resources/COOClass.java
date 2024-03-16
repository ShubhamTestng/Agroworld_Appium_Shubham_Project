package Resources;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import utility.Utility;

public class COOClass extends BaseClass {
	public String companyNames;
	BDEClass testInstance = new BDEClass();
	public Logger log = LogManager.getLogger(COOClass.class);
	Utility utility ;

	@BeforeMethod
	public void initializeUtility() {
		utility = new Utility(appiumdriver);
	}

	@Test(priority = 1)
	public void getLogin() {

		utility.Login("2000000000");

		log.info("COO Logged IN");

		appiumdriver.findElement(By.xpath("//android.widget.TextView[@text=\"Business Development Module\"]")).click();

	}


	@Test(priority = 2)
	public void  CompleteMeeting() throws InterruptedException {

		appiumdriver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.ssi.agroworlds:id/background_Img\"])[6]")).click();

		utility.scrollPage();

		Thread.sleep(2000);

		log.info("potentail has clciked in COO Account");
		
		appiumdriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.ssi.agroworlds:id/meeetingTitleTv\"]")).click();

		companyNames =  testInstance.getCompanyNameText();
		
		System.out.println(companyNames + "this are comapnay name before going to list");
		
		List<WebElement> ActivityLogPage = appiumdriver.findElements(By.xpath("//android.widget.TextView[@resource-id=\"com.ssi.agroworlds:id/titleTv\"]"));

		
		System.out.println("i am in activity logs list ");
		for(WebElement meetingInActivityLog : ActivityLogPage) {

			System.out.println(meetingInActivityLog + "this are webelement the meeting created ");
			
			String meetingInActivityLogs = meetingInActivityLog.getText();
			
			System.out.println(meetingInActivityLogs + "this are string value");

			if (meetingInActivityLogs.toLowerCase().contains(companyNames.toLowerCase())) {
			    // Your code here
				log.info("Meeting creations are correctly displayed in activity logs ");

				appiumdriver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.ssi.agroworlds:id/dropdDownImgView\")")).click();

				appiumdriver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.ssi.agroworlds:id/startMeetingBtn\"]")).click();

                log.info("meeting start button clicked");
                
                Thread.sleep(2000);

				//appiumdriver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")).click();
				
				//Thread.sleep(1000);

				appiumdriver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.ssi.agroworlds:id/okayBtn\"]")).click();
				
				Thread.sleep(2000);

				appiumdriver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.ssi.agroworlds:id/dropdDownImgView\")")).click();


				appiumdriver.findElement(By.xpath("	//android.widget.Button[@resource-id=\"com.ssi.agroworlds:id/startMeetingBtn\"]")).click();

				Thread.sleep(2000);
			//	appiumdriver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.ssi.agroworlds:id/submitBtn\"]")).click();

				appiumdriver.findElement(By.xpath("(//android.widget.EditText[@text=\"Enter Text Here\"])[1]")).sendKeys("Meeting need to complete");

				appiumdriver.findElement(By.xpath("//android.widget.Spinner[@resource-id=\"com.ssi.agroworlds:id/clientBusinessTypeSpinner\"]")).click();

				appiumdriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.ssi.agroworlds:id/titleTv\" and @text=\"Importer\"]")).click();

				appiumdriver.findElement(By.xpath("//android.widget.Spinner[@resource-id=\"com.ssi.agroworlds:id/businessSizeSpinner\"]")).click();

				appiumdriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.ssi.agroworlds:id/titleTv\" and @text=\"20\"]")).click();
				Thread.sleep(2000);
				appiumdriver.findElement(By.xpath("//android.widget.Spinner[@resource-id='com.ssi.agroworlds:id/businessInterestSpinner']")).click();


				appiumdriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.ssi.agroworlds:id/titleTv\" and @text=\"High\"]")).click();
				
				Thread.sleep(2000);

				utility.scrollDown();

				// Define the resource ID and text of the target element
				String resourceId = "com.ssi.agroworlds:id/titleTv";
				String text = "Recommended by our current customers";

				// Use UiScrollable with UiSelector to scroll to the element and click it
				appiumdriver.findElement(new AppiumBy.ByAndroidUIAutomator(
				    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" +
				    "new UiSelector().resourceId(\"" + resourceId + "\").text(\"" + text + "\"))")).click();

				
				appiumdriver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.ssi.agroworlds:id/submitBtn\"]")).click();


				appiumdriver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.ssi.agroworlds:id/okayBtn\"]")).click();

				Thread.sleep(2000);

				utility.back();

				Thread.sleep(2000);

				utility.back();

				Thread.sleep(2000);

				utility.back();

			}

			else {

				log.info("Meeting creations not display in activity logs");

			}
		}

	}

	@Test(priority = 3)
	public void clientConversionRequestAccept() throws InterruptedException {

		String requestName = "Conversion Request";
		appiumdriver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + requestName + "\").instance(0))")).click();
		Thread.sleep(1000);

		utility.scrollPage();

		appiumdriver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.ssi.agroworlds:id/approveBtn\"]")).click();

		appiumdriver.findElement(By.xpath("//android.widget.EditText[@text=\"Enter Here\"]")).sendKeys("Request to Clinet is approved from COO");

		appiumdriver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.ssi.agroworlds:id/yesBtn\"]")).click();

		appiumdriver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.ssi.agroworlds:id/okayBtn\"]")).click();

		appiumdriver.findElement(By.xpath("//android.widget.ImageView[@resource-id=\"com.ssi.agroworlds:id/backImgView\"]")).click();

		log.info("Request to Clinet is approved from COO");

	}


	@Test(priority = 4)
	public void getLogout() {

		utility.logout();

		log.info("COO Logged OUT");
	}


}
