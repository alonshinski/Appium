import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchChrome {
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
    public void myTest() throws InterruptedException {
        driver.findElement(By.id("com.android.chrome:id/terms_accept")).click();
        driver.findElement(By.id("com.android.chrome:id/positive_button")).click();
        driver.findElement(By.id("com.android.chrome:id/search_box_text")).click();
        driver.pressKey(new KeyEvent(AndroidKey.F));
        driver.pressKey(new KeyEvent(AndroidKey.O));
        driver.pressKey(new KeyEvent(AndroidKey.X));
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        Thread.sleep(3000);
        driver.findElement(By.id("com.android.chrome:id/infobar_close_button")).click();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable( UiSelector().scrollable(true))"
                + ".scrollIntoView(new UiSelector().text(\"https://www.globes.co.il › פוקס פוקס - גלובס\"))"));
       // List<MobileElement> Totallinks = driver.findElementsByAndroidUIAutomator("UiSelector().textContains(\"https:\")");
        List<MobileElement> Totallinks = driver.findElements(By.partialLinkText("https"));
        for(MobileElement element : Totallinks) {
            System.out.println("Element - " + element.getText());
        }
        System.out.println(Totallinks.size());

    }
    }
