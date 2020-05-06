import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EnterChromeApp {
    static AndroidDriver<MobileElement> driver;
    @BeforeClass
    public static void setUp() throws IOException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Device");
        capabilities.setCapability("appPackage", "com.android.chrome");
        capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        capabilities.setCapability("newCommandTimeout", 120);
        //capabilities.setCapability("platformVersion", "8.1.0");
        //capabilities.setCapability("unicodekeyboard", true);
        // capabilities.setCapability("resetkeyboard", true);
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(3000);
    }
   @Test
       public void test_01_ChromeApp() throws InterruptedException {
       driver.findElement(By.id("com.android.chrome:id/terms_accept")).click();
       driver.findElement(By.id("com.android.chrome:id/positive_button")).click();
       String pageSource = driver.getPageSource();
       Thread.sleep(3000);
       List<MobileElement> listOfClickableElements = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)");
       for (MobileElement element:
               listOfClickableElements){
           System.out.println(element.getLocation());
       }
    /* System.out.println(pageSource);
       String str = pageSource;
       String findStr = "clickable=\"true\"";
       int lastIndex = 0;
       int count = 0;
       while(lastIndex != -1){
           lastIndex = str.indexOf(findStr,lastIndex);
           if(lastIndex != -1){
               count ++;
               lastIndex += findStr.length();
           }
       }
       System.out.println(count);*/
       String someText=driver.findElement(By.xpath("//android.widget.TextView[@text='Facebook']")).getText();
       System.out.println(someText);
   }
   @Test public void test_02_EnterChromeApp(){
       Dimension elmentSize= driver.findElement(By.className("android.widget.FrameLayout")).getSize();
       System.out.println(elmentSize);
       int locationX=driver.findElement(By.className("android.widget.FrameLayout")).getLocation().x;
       int locationY=driver.findElement(By.className("android.widget.FrameLayout")).getLocation().y;
       System.out.println(locationX);
       System.out.println(locationY);
   }


   @Test public void test_03_Banana() throws InterruptedException {
       /*driver.findElement(By.id("com.android.chrome:id/terms_accept")).click();
       driver.findElement(By.id("com.android.chrome:id/positive_button")).click();*/
       driver.findElement(By.id("com.android.chrome:id/search_box_text")).click();
       driver.pressKey(new KeyEvent(AndroidKey.B));
       driver.pressKey(new KeyEvent(AndroidKey.A));
       driver.pressKey(new KeyEvent(AndroidKey.N));
       driver.pressKey(new KeyEvent(AndroidKey.A));
       driver.pressKey(new KeyEvent(AndroidKey.N));
       driver.pressKey(new KeyEvent(AndroidKey.A));
       driver.pressKey(new KeyEvent(AndroidKey.ENTER));
       Thread.sleep(3000);
      // driver.findElement(By.id("com.android.chrome:id/infobar_close_button")).click();
   }
   @AfterClass public static void myAfter(){

        driver.closeApp();
   }
}
