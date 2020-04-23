import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Main {
    //private static AndroidDriver<MobileElement> driver;
    static AndroidDriver<MobileElement> driver;
    //public static MobileElement mobileElement;
  //static  boolean isElementPresent;
    @BeforeClass
    public static void setUp() throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Device");
        capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
        capabilities.setCapability("newCommandTimeout", 120);
        capabilities.setCapability("unicodekeyboard", true);
        capabilities.setCapability("resetkeyboard", true);
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

   @Test
    public void myTest() throws InterruptedException {

       Thread.sleep(2000);
       driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_03")).click();
       driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_mul")).click();
       driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_02")).click();
       driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal")).click();
     String text=driver.findElement(By.id("com.sec.android.app.popupcalculator:id/txtCalc")).getText();

       try{
           Assert.assertEquals("6",text);
           System.out.println("my assertEquals passed");
       }
       catch(AssertionError e){
           System.out.println(e.getMessage());
       }

       Thread.sleep(2000);
       driver.quit();
   }

    }

/*

DesiredCapabilities capabilities = new DesiredCapabilities(); capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Device");
        capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
        capabilities.setCapability("newCommandTimeout", 120);
        capabilities.setCapability("unicodekeyboard", true);
        capabilities.setCapability("resetkeyboard", true);
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/


   /* public static boolean waitForPresence(AndroidDriver driver, int timeLimitInSeconds, String targetResourceId) {


        try {
            mobileElement = (MobileElement) driver.findElementByAndroidUIAutomator(" UiSelector().resourceId(\"" + targetResourceId + "\")");
            WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
            wait.until(ExpectedConditions.visibilityOf(mobileElement));
            isElementPresent = mobileElement.isDisplayed();
            return isElementPresent;
        } catch (Exception e) {
            isElementPresent = false;
            System.out.println(e.getMessage());
            return isElementPresent;
        }
    }

}
*/