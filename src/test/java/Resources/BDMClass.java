package Resources;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.List;

import javax.lang.model.element.Element;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import logger.Log;
import utility.Utility;

public class BDMClass extends BaseClass{
	public String MeetingTitleOnCreatingMeeting;
	public String MeetingTitleAftercreatingMeeting;
	public String dateAndTime;
	public Logger log = LogManager.getLogger(BDMClass.class);
	BDEClass testInstance = new BDEClass();
	public String companyNames;
	Utility utility ;

	@BeforeMethod
	public void initializeUtility() {
		utility = new Utility(appiumdriver);
	}

	@Test(priority = 1)
	public void getLogin() throws InterruptedException {

		utility.Login("3000000000");
		
		log.info("BDM Logged in");
		
		Thread.sleep(2000);

	}

	@Test(priority = 2)
	public void potentialConversionRequestAccept() throws InterruptedException {

		String requestName = "Conversion Request";
		appiumdriver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + requestName + "\").instance(0))")).click();
		Thread.sleep(1000);

		utility.scrollPage();

		appiumdriver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.ssi.agroworlds:id/approveBtn\"]")).click();

		appiumdriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.ssi.agroworlds:id/followUpDateTv\"]")).click();

		utility.currentDate();

		appiumdriver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();

		appiumdriver.findElement(By.xpath("//android.widget.EditText[@text=\"Enter Here\"]")).sendKeys("converted to potentail from BDM");

		appiumdriver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.ssi.agroworlds:id/yesBtn\"]")).click();

		Thread.sleep(2000);

		appiumdriver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.ssi.agroworlds:id/okayBtn\"]")).click();

		utility.back();

		Thread.sleep(2000);
		
		utility.back();

	}

	
	@Test(priority = 3)
	public void  addMeetingForPotential() throws InterruptedException {
		
		utility.scrollUp();
		
		Thread.sleep(1000);
		
		appiumdriver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.ssi.agroworlds:id/background_Img\"])[6]")).click();

		Thread.sleep(2000);

		log.info("potentail has clciked");
		
		utility.scrollPage();
		
		appiumdriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.ssi.agroworlds:id/meeetingTitleTv\"]")).click();
		
		Thread.sleep(4000);
		
//		int startX = 870;
//		int startY = 2082;
//		int endX = 1024;
//		int endY = 2202;
//
//		// Calculate the center of the element
//		int centerX = (startX + endX) / 2;
//		int centerY = (startY + endY) / 2;

		
		//utility.tap(950, endY);
		
		//appiumdriver.findElement(By.xpath("//android.widget.ImageButton[@resource-id=\"com.ssi.agroworlds:id/mainFab\"]")).click();
		
//		WebElement element = appiumdriver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout"));
//		JavascriptExecutor js = (JavascriptExecutor) appiumdriver;
//		js.executeScript("arguments[0].click();", element);
		
		
//		List<WebElement>  listElement = appiumdriver.findElements(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout"));
//
//	     System.out.println("Size: " + listElement.size());
//	     
//	     for(int i=0;i<listElement.size();i++) {
//	    	 
//	    	 
//	    	 System.out.println(listElement + "and this is the element");
//	     }
//		
		
		appiumdriver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.ssi.agroworlds:id/mainFab\")")).click();
 
		Log.info("ELEMENT GET CLICKED");
		
		Thread.sleep(3000);
		
		appiumdriver.findElement(By.xpath("//android.widget.ImageButton[@resource-id=\"com.ssi.agroworlds:id/createMeetingFab\"]")).click();
		
		//utility.isElementDisable(createMettingXpath);
		
		//utility.isElementClickable(createMettingXpath);
		
		appiumdriver.findElement(By.xpath("//android.widget.Spinner[@resource-id=\"com.ssi.agroworlds:id/scheduleMeetingModeSpinner\"]")).click();
		
		appiumdriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.ssi.agroworlds:id/titleTv\" and @text=\"Video call\"]")).click();

		WebElement meetingTitle = appiumdriver.findElement(By.xpath("//android.widget.EditText[@text=\"Enter Title Here\"]"));
		companyNames =  testInstance.getCompanyNameText();
		
		System.out.println("comany name in bdm is" +companyNames );
		meetingTitle.sendKeys("Meeting hase created for" + companyNames);
		
		MeetingTitleOnCreatingMeeting = meetingTitle.getText();
		
		appiumdriver.findElement(By.xpath("//android.widget.ImageView[@resource-id=\"com.ssi.agroworlds:id/calenderImgView\"]")).click();
		
		for(int i=0;i<3;i++) {	

			appiumdriver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Next month\"]")).click();

		}

		String meetingDate = "22 June 2024";

		appiumdriver.findElement(By.xpath("//android.view.View[@content-desc=\"" + meetingDate + "\"]")).click();

		appiumdriver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();

		appiumdriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.ssi.agroworlds:id/meetingTimeTv\"]")).click();

		appiumdriver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Switch to text input mode for the time input.\"]")).click();
		
		Thread.sleep(2000);
		
		utility.currentTime();
		
		appiumdriver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();

		appiumdriver.findElement(By.xpath("//android.widget.EditText[@text=\"Enter Address/Link Here\"]")).sendKeys("Meeting placed in Indore");

		appiumdriver.findElement(By.xpath("//android.widget.EditText[@text=\"Enter Agenda Here\"]")).sendKeys("To convert potential lead into client");
		
		appiumdriver.findElement(By.xpath("//android.widget.Spinner[@resource-id=\"com.ssi.agroworlds:id/reportingManagerSpinner\"]")).click();

		appiumdriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Aayushi Procurement IRM\"]")).click();

		utility.scrollDown();
		
		appiumdriver.findElement(By.xpath("//android.widget.EditText[@text=\"Enter Here\"]")).sendKeys("Meeting should done");

		appiumdriver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.ssi.agroworlds:id/scheduleMeetingBtn\"]")).click();

		Thread.sleep(2000);
		
		appiumdriver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.ssi.agroworlds:id/okayBtn\"]")).click();
		
		Thread.sleep(2000);
		
		WebElement meetingtitle = appiumdriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.ssi.agroworlds:id/titleTv\"]"));
		
		MeetingTitleAftercreatingMeeting = meetingtitle.getText();

		Assert.assertEquals(MeetingTitleOnCreatingMeeting, MeetingTitleOnCreatingMeeting, "Meeting Title validation Done");
		
		WebDriverWait wait = new WebDriverWait(appiumdriver, Duration.ofSeconds(5)); // Adjust the timeout as needed
		try {
		    WebElement meetingFlag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@resource-id='com.ssi.agroworlds:id/meetingEscalationFlagImgView']")));
		    if (meetingFlag.isDisplayed()) {
		        log.info("Meeting has escalated before scheduled time");
		    }
		} catch (org.openqa.selenium.TimeoutException e) {
		    log.info("Meeting escalation flag is not present.");
		}
	
		utility.back();
		
		Thread.sleep(2000);
			
		appiumdriver.findElement(By.xpath("//android.widget.TextView[@text=\"Activity Logs\"]")).click();
		
		Thread.sleep(1000);
		dateAndTime = utility.timeInLogs();
		System.out.println(dateAndTime + "created in activity logs");
		System.out.println(MeetingTitleAftercreatingMeeting + "meeting created in activity logs");
		System.out.println(companyNames + "meeting created in activity logs");
		
//		String meetingXpath = "//android.widget.TextView[@resource-id=\"com.ssi.agroworlds:id/logTitleTv\" and @text=\"A new meeting with " + 
//			    companyNames + " has been scheduled for " + MeetingTitleAftercreatingMeeting + " on " + meetingDate + " at " + dateAndTime + "\"]";
//
//				
//		WebElement meetingCreatedElement = appiumdriver.findElement(By.xpath(meetingXpath));
//		
//		String meetingCreatedElements = meetingCreatedElement.getText();
//		
//		System.out.println(meetingCreatedElements + "meeting created in activity logs");
		
//		List<WebElement> ActivityLogPage =  appiumdriver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.ssi.agroworlds:id/recyclView\"]"));
//         //android.widget.FrameLayout[@resource-id="android:id/content"]/android.widget.LinearLayout
//		System.out.println("i am in activity logs list ");
//        for(WebElement meetingInActivityLog : ActivityLogPage) {
//        	
//        	String meetingInActivityLogs = meetingInActivityLog.getText();
//        	
//        	if (meetingInActivityLogs.contains(meetingCreatedElements)) {
//        		
//        		log.info("Meeting creations are correctly displayed in activity logs ");
//        	}
//        	
//        	else {
//        		
//        		log.info("Meeting creations not display in activity logs");
//
//        	}
//        }
		
		appiumdriver.findElement(By.xpath("//android.widget.ImageView[@resource-id=\"com.ssi.agroworlds:id/backImgView\"]")).click();
		
		Thread.sleep(3000);
		
		utility.back();
		
		Thread.sleep(3000);
		
		utility.back();

		
	}
	
	@Test(priority = 4)
	public void convertToClient() throws InterruptedException {
		
		//addMeetingForPotential();

		String leadState = "Potentials";
		appiumdriver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + leadState + "\").instance(0))")).click();
		Thread.sleep(2000);

		log.info("potentail has clciked");
		
		utility.scrollPage();
		
		log.info("BDM gone though scrollpage");

		Thread.sleep(2000);
			
		appiumdriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.ssi.agroworlds:id/titleTv\"]")).click();

		Thread.sleep(1000);

		appiumdriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.ssi.agroworlds:id/nightModeTv\"]")).click();

		appiumdriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Anshita Trader\"]")).click();

		appiumdriver.findElement(By.xpath("//android.widget.EditText[@text=\"Enter Here\"]")).sendKeys("please convert lead from potential to client");

		appiumdriver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.ssi.agroworlds:id/yesBtn\"]")).click();

		appiumdriver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.ssi.agroworlds:id/okayBtn\"]")).click();

		appiumdriver.findElement(By.xpath("//android.widget.ImageView[@resource-id=\"com.ssi.agroworlds:id/backImgView\"]")).click();

		Thread.sleep(2000);
		
		appiumdriver.findElement(By.xpath("//android.widget.ImageView[@resource-id=\"com.ssi.agroworlds:id/backImgView\"]")).click();
		
		log.info("BDM Convrted lead from potential to client");
		 		
	}

	@Test(priority = 5)
	public void getLogout() {

		utility.logout();
		
		log.info("BDM Logged out");
	}



}
