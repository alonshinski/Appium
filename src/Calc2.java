import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Calc2 {
    static AndroidDriver<MobileElement> driver;

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
    @Test public void myTestPlus() throws Exception {
        Thread.sleep(2000);
        String firstN = readFromFile("firstN");
        String sectN = readFromFile("sectN");
        String [] array1=firstN.split("");
        String [] array2=sectN.split("");
        //System.out.println(array1[0]);
        for(int i=0; i<=array1.length-1;i++){
            System.out.println(array1[i]);
            driver.findElement(By.id("bt_0" + array1[i])).click();
        }
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add")).click();
        for(int i=0; i<=array2.length-1;i++){
            //System.out.println(array2[i]);
            driver.findElement(By.id("bt_0" + array2[i])).click();
        }
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal")).click();
    }
    @Test public void myTestMinus() throws Exception {
        Thread.sleep(2000);
        String firstN = readFromFile("firstN");
        String sectN = readFromFile("sectN");
        String [] array1=firstN.split("");
        String [] array2=sectN.split("");
        //System.out.println(array1[0]);
        for(int i=0; i<=array1.length-1;i++){
            System.out.println(array1[i]);
            driver.findElement(By.id("bt_0" + array1[i])).click();
        }
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_sub")).click();
        for(int i=0; i<=array2.length-1;i++){
            //System.out.println(array2[i]);
            driver.findElement(By.id("bt_0" + array2[i])).click();
        }
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal")).click();
    }
    @Test public void myTestMul() throws Exception {
        Thread.sleep(2000);
        String firstN = readFromFile("firstN");
        String sectN = readFromFile("sectN");
        String [] array1=firstN.split("");
        String [] array2=sectN.split("");
        //System.out.println(array1[0]);
        for(int i=0; i<=array1.length-1;i++){
            System.out.println(array1[i]);
            driver.findElement(By.id("bt_0" + array1[i])).click();
        }
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_mul")).click();
        for(int i=0; i<=array2.length-1;i++){
            //System.out.println(array2[i]);
            driver.findElement(By.id("bt_0" + array2[i])).click();
        }
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal")).click();
    }
    @Test public void myTestDiv() throws Exception {
        Thread.sleep(2000);
        String firstN = readFromFile("firstN");
        String sectN = readFromFile("sectN");
        String [] array1=firstN.split("");
        String [] array2=sectN.split("");
        //System.out.println(array1[0]);
        if(sectN.equals("0")) {
            throw new ArithmeticException("Division by zero!");
        }
        for(int i=0; i<=array1.length-1;i++){
            System.out.println(array1[i]);
            driver.findElement(By.id("bt_0" + array1[i])).click();
        }
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_div")).click();
        for(int i=0; i<=array2.length-1;i++){
            //System.out.println(array2[i]);
            driver.findElement(By.id("bt_0" + array2[i])).click();
        }
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal")).click();
    }
    public static String readFromFile(String keyData) throws Exception {
        File xmlFile = new File("C://Users//Alon//Desktop//calc.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyData).item(0).getTextContent();
    }
}
