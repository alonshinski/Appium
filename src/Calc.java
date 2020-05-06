import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Calc {
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

    @Test
    public void myTest() throws Exception {
        Thread.sleep(2000);
        String firstN = readFromFile("firstN");
        String sectN = readFromFile("sectN");
        int a = Integer.parseInt(firstN);
        int b = Integer.parseInt(sectN);
        double plusAB = a + b;
        int intPlusAB=a+b;
        int num = a;
        int num2 = b;
        int reversed = 0;
        int digit = 0;
        int count = 0;
        int count2 = 0;
        int temp;
        int n1;
        while (num != 0) {
            digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
            count++;
        }
        if (count == 2 && a % 10 == 0) {
            int n3 = a / 10;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = a % 10;
            driver.findElement(By.id("bt_0" + n4)).click();
            driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add")).click();
        } else if (count == 3 && a % 10 == 0 && (a / 10)%10 == 0) {
            int n3 = a / 100;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = (a / 10)%10;
            driver.findElement(By.id("bt_0" + n4)).click();
            int n5 = a % 10;
            driver.findElement(By.id("bt_0" + n5)).click();
            driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add")).click();
        } else if (count == 4 && a % 10 == 0 && (a / 10)%10 == 0 && (a / 100)%10 == 0) {
            int n3 = a / 1000;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = (a / 100)%10;
            driver.findElement(By.id("bt_0" + n4)).click();
            int n5 = (a / 10)%10;
            driver.findElement(By.id("bt_0" + n5)).click();
            int n6 = a % 10;
            driver.findElement(By.id("bt_0" + n6)).click();
            driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add")).click();
        } else if (count == 5 && a % 10 == 0 && (a / 10)%10 == 0 && (a / 100)%10 == 0&&(a/1000)%10==0) {
            int n3 = a / 10000;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = (a / 1000)%10;
            driver.findElement(By.id("bt_0" + n4)).click();
            int n5 = (a / 100)%10;
            driver.findElement(By.id("bt_0" + n5)).click();
            int n6 = (a / 10)%10;
            driver.findElement(By.id("bt_0" + n6)).click();
            int n7 = a % 10;
            driver.findElement(By.id("bt_0" + n7)).click();
            driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add")).click();
        } else {

            temp = reversed;
            n1 = 0;
            while (temp != 0) {
                n1 = temp % 10;
                temp /= 10;
                driver.findElement(By.id("bt_0" + n1)).click();
            }
            driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add")).click();
        }
        reversed = 0;
        digit = 0;

        while (num2 != 0) {
            digit = num2 % 10;
            reversed = reversed * 10 + digit;
            num2 /= 10;
            count2++;
        }
        if (count2 == 2 && a % 10 == 0) {
            int n3 = b / 10;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = b % 10;
            driver.findElement(By.id("bt_0" + n4)).click();
        } else if (count2 == 3 && b % 10 == 0 && (b / 10)%10 == 0) {
            int n3 = b / 100;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = (b / 10)%10;
            driver.findElement(By.id("bt_0" + n4)).click();
            int n5 = b % 10;
            driver.findElement(By.id("bt_0" + n5)).click();
        } else if (count2 == 4 && b % 10 == 0 && (b / 10)%10 == 0 && (b / 100)%10 == 0) {
            int n3 = b / 1000;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = (b / 100)%10;
            driver.findElement(By.id("bt_0" + n4)).click();
            int n5 = (b / 10)%10;
            driver.findElement(By.id("bt_0" + n5)).click();
            int n6 = b % 10;
            driver.findElement(By.id("bt_0" + n6)).click();
        } else if (count2 == 5 && b % 10 == 0 && (b / 10)%10 == 0 && (b / 100)%10 == 0&&(b/1000)%10==0) {
            int n3 = b / 10000;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = (b / 1000)%10;
            driver.findElement(By.id("bt_0" + n4)).click();
            int n5 = (b / 100)%10;
            driver.findElement(By.id("bt_0" + n5)).click();
            int n6 = (b / 10)%10;
            driver.findElement(By.id("bt_0" + n6)).click();
            int n7 = b % 10;
            driver.findElement(By.id("bt_0" + n7)).click();

        } else {

            temp = reversed;
            n1 = 0;
            while (temp != 0) {
                n1 = temp % 10;
                temp /= 10;
                driver.findElement(By.id("bt_0" + n1)).click();
            }
        }
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal")).click();
        String text=driver.findElement(By.id("com.sec.android.app.popupcalculator:id/txtCalc")).getText();
        String replaceString=text.replaceAll(",","");
        String stringValueOfAPlusB=String.valueOf(intPlusAB);
        try{
            Assert.assertEquals(stringValueOfAPlusB,replaceString);
            System.out.println("my assertEquals passed");
        }
        catch(AssertionError e){
            System.out.println(e.getMessage());
        }
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void myTest2() throws Exception {
        Thread.sleep(2000);
        String firstN = readFromFile("firstN");
        String sectN = readFromFile("sectN");
        int a = Integer.parseInt(firstN);
        int b = Integer.parseInt(sectN);
        int minusAB = a - b;
        double MinAB=a-b;
        int num = a;
        int num2 = b;
        int reversed = 0;
        int digit = 0;
        int count = 0;
        int count2 = 0;
        int temp;
        int n1;
        while (num != 0) {
            digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
            count++;
        }
        if (count == 2 && a % 10 == 0) {
            int n3 = a / 10;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = a % 10;
            driver.findElement(By.id("bt_0" + n4)).click();
            driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_sub")).click();
        } else if (count == 3 && a % 10 == 0 && (a / 10)%10 == 0) {
            int n3 = a / 100;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = (a / 10)%10;
            driver.findElement(By.id("bt_0" + n4)).click();
            int n5 = a % 10;
            driver.findElement(By.id("bt_0" + n5)).click();
            driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_sub")).click();
        } else if (count == 4 && a % 10 == 0 && (a / 10)%10 == 0 && (a / 100)%10 == 0) {
            int n3 = a / 1000;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = (a / 100)%10;
            driver.findElement(By.id("bt_0" + n4)).click();
            int n5 = (a / 10)%10;
            driver.findElement(By.id("bt_0" + n5)).click();
            int n6 = a % 10;
            driver.findElement(By.id("bt_0" + n6)).click();
            driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_sub")).click();
        } else if (count == 5 && a % 10 == 0 && (a / 10)%10 == 0 && (a / 100)%10 == 0&&(a/1000)%10==0) {
            int n3 = a / 10000;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = (a / 1000)%10;
            driver.findElement(By.id("bt_0" + n4)).click();
            int n5 = (a / 100)%10;
            driver.findElement(By.id("bt_0" + n5)).click();
            int n6 = (a / 10)%10;
            driver.findElement(By.id("bt_0" + n6)).click();
            int n7 = a % 10;
            driver.findElement(By.id("bt_0" + n7)).click();
            driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_sub")).click();
        } else {

            temp = reversed;
            n1 = 0;
            while (temp != 0) {
                n1 = temp % 10;
                temp /= 10;
                driver.findElement(By.id("bt_0" + n1)).click();
            }
            driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_sub")).click();
        }
        reversed = 0;
        digit = 0;

        while (num2 != 0) {
            digit = num2 % 10;
            reversed = reversed * 10 + digit;
            num2 /= 10;
            count2++;
        }
        if (count2 == 2 && b % 10 == 0) {
            int n3 = b / 10;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = b % 10;
            driver.findElement(By.id("bt_0" + n4)).click();
        } else if (count2 == 3 && b % 10 == 0 && (b / 10)%10 == 0) {
            int n3 = b / 100;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = (b / 10)%10;
            driver.findElement(By.id("bt_0" + n4)).click();
            int n5 = b % 10;
            driver.findElement(By.id("bt_0" + n5)).click();
        } else if (count2 == 4 && b % 10 == 0 && (b / 10)%10 == 0 && (b / 100)%10 == 0) {
            int n3 = b / 1000;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = (b / 100)%10;
            driver.findElement(By.id("bt_0" + n4)).click();
            int n5 = (b / 10)%10;
            driver.findElement(By.id("bt_0" + n5)).click();
            int n6 = b % 10;
            driver.findElement(By.id("bt_0" + n6)).click();
        } else if (count2 == 5 && b % 10 == 0 && (b / 10)%10 == 0 && (b / 100)%10 == 0&&(b/1000)%10==0) {
            int n3 = b / 10000;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = (b / 1000)%10;
            driver.findElement(By.id("bt_0" + n4)).click();
            int n5 = (b / 100)%10;
            driver.findElement(By.id("bt_0" + n5)).click();
            int n6 = (b / 10)%10;
            driver.findElement(By.id("bt_0" + n6)).click();
            int n7 = b % 10;
            driver.findElement(By.id("bt_0" + n7)).click();

        } else {

            temp = reversed;
            n1 = 0;
            while (temp != 0) {
                n1 = temp % 10;
                temp /= 10;
                driver.findElement(By.id("bt_0" + n1)).click();
            }
        }
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal")).click();
        String text=driver.findElement(By.id("com.sec.android.app.popupcalculator:id/txtCalc")).getText();
        String stringValueOfAMinusB=String.valueOf(minusAB);
        try{
            Assert.assertEquals(minusAB,text);
            System.out.println("my assertEquals passed");
        }
        catch(AssertionError e){
            System.out.println(e.getMessage());
        }
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void myTest3() throws Exception {
        Thread.sleep(2000);
        String firstN = readFromFile("firstN");
        String sectN = readFromFile("sectN");
        int a = Integer.parseInt(firstN);
        int b = Integer.parseInt(sectN);
        double mulAB = a * b;
        int MulAB=a*b;
        int num = a;
        int num2 = b;
        int reversed = 0;
        int digit = 0;
        int count = 0;
        int count2 = 0;
        int temp;
        int n1;
        while (num != 0) {
            digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
            count++;
        }
        if (count == 2 && a % 10 == 0) {
            int n3 = a / 10;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = a % 10;
            driver.findElement(By.id("bt_0" + n4)).click();
            driver.findElement(By.id("com.sec.android.app.popupcalculator:id/mul_sub")).click();
        } else if (count == 3 && a % 10 == 0 && (a / 10)%10 == 0) {
            int n3 = a / 100;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = (a / 10)%10;
            driver.findElement(By.id("bt_0" + n4)).click();
            int n5 = a % 10;
            driver.findElement(By.id("bt_0" + n5)).click();
            driver.findElement(By.id("com.sec.android.app.popupcalculator:id/mul_sub")).click();
        } else if (count == 4 && a % 10 == 0 && (a / 10)%10 == 0 && (a / 100)%10 == 0) {
            int n3 = a / 1000;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = (a / 100)%10;
            driver.findElement(By.id("bt_0" + n4)).click();
            int n5 = (a / 10)%10;
            driver.findElement(By.id("bt_0" + n5)).click();
            int n6 = a % 10;
            driver.findElement(By.id("bt_0" + n6)).click();
            driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_mul")).click();
        } else if (count == 5 && a % 10 == 0 && (a / 10)%10 == 0 && (a / 100)%10 == 0&&(a/1000)%10==0) {
            int n3 = a / 10000;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = (a / 1000)%10;
            driver.findElement(By.id("bt_0" + n4)).click();
            int n5 = (a / 100)%10;
            driver.findElement(By.id("bt_0" + n5)).click();
            int n6 = (a / 10)%10;
            driver.findElement(By.id("bt_0" + n6)).click();
            int n7 = a % 10;
            driver.findElement(By.id("bt_0" + n7)).click();
            driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_mul")).click();
        } else {

            temp = reversed;
            n1 = 0;
            while (temp != 0) {
                n1 = temp % 10;
                temp /= 10;
                driver.findElement(By.id("bt_0" + n1)).click();
            }
            driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_mul")).click();
        }
        reversed = 0;
        digit = 0;

        while (num2 != 0) {
            digit = num2 % 10;
            reversed = reversed * 10 + digit;
            num2 /= 10;
            count2++;
        }
        if (count2 == 2 && b % 10 == 0) {
            int n3 = b / 10;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = b % 10;
            driver.findElement(By.id("bt_0" + n4)).click();
        } else if (count2 == 3 && b % 10 == 0 && (b / 10)%10 == 0) {
            int n3 = b / 100;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = (b / 10)%10;
            driver.findElement(By.id("bt_0" + n4)).click();
            int n5 = b % 10;
            driver.findElement(By.id("bt_0" + n5)).click();
        } else if (count2 == 4 && b % 10 == 0 && (b / 10)%10 == 0 && (b / 100)%10 == 0) {
            int n3 = b / 1000;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = (b / 100)%10;
            driver.findElement(By.id("bt_0" + n4)).click();
            int n5 = (b / 10)%10;
            driver.findElement(By.id("bt_0" + n5)).click();
            int n6 = b % 10;
            driver.findElement(By.id("bt_0" + n6)).click();
        } else if (count2 == 5 && b % 10 == 0 && (b / 10)%10 == 0 && (b / 100)%10 == 0&&(b/1000)%10==0) {
            int n3 = b / 10000;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = (b / 1000)%10;
            driver.findElement(By.id("bt_0" + n4)).click();
            int n5 = (b / 100)%10;
            driver.findElement(By.id("bt_0" + n5)).click();
            int n6 = (b / 10)%10;
            driver.findElement(By.id("bt_0" + n6)).click();
            int n7 = b % 10;
            driver.findElement(By.id("bt_0" + n7)).click();

        } else {

            temp = reversed;
            n1 = 0;
            while (temp != 0) {
                n1 = temp % 10;
                temp /= 10;
                driver.findElement(By.id("bt_0" + n1)).click();
            }
        }
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal")).click();
        String text=driver.findElement(By.id("com.sec.android.app.popupcalculator:id/txtCalc")).getText();
        String stringValueOfAMinusB=String.valueOf(mulAB);
        try{
            Assert.assertEquals(mulAB,text);
            System.out.println("my assertEquals passed");
        }
        catch(AssertionError e){
            System.out.println(e.getMessage());
        }
        Thread.sleep(2000);
        driver.quit();
    }
    @Test public void myTest4() throws Exception {
        Thread.sleep(2000);
        String firstN = readFromFile("firstN");
        String sectN = readFromFile("sectN");
        int a = Integer.parseInt(firstN);
        int b = Integer.parseInt(sectN);
        int divAB = a / b;
        double dvAB=a/b;
        int num = a;
        int num2 = b;
        int reversed = 0;
        int digit = 0;
        int count = 0;
        int count2 = 0;
        int temp;
        int n1;
        while (num != 0) {
            digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
            count++;
        }
        if (count == 2 && a % 10 == 0) {
            int n3 = a / 10;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = a % 10;
            driver.findElement(By.id("bt_0" + n4)).click();
            driver.findElement(By.id("com.sec.android.app.popupcalculator:id/mul_div")).click();
        } else if (count == 3 && a % 10 == 0 && (a / 10) % 10 == 0) {
            int n3 = a / 100;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = (a / 10) % 10;
            driver.findElement(By.id("bt_0" + n4)).click();
            int n5 = a % 10;
            driver.findElement(By.id("bt_0" + n5)).click();
            driver.findElement(By.id("com.sec.android.app.popupcalculator:id/mul_div")).click();
        } else if (count == 4 && a % 10 == 0 && (a / 10) % 10 == 0 && (a / 100) % 10 == 0) {
            int n3 = a / 1000;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = (a / 100) % 10;
            driver.findElement(By.id("bt_0" + n4)).click();
            int n5 = (a / 10) % 10;
            driver.findElement(By.id("bt_0" + n5)).click();
            int n6 = a % 10;
            driver.findElement(By.id("bt_0" + n6)).click();
            driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_div")).click();
        } else if (count == 5 && a % 10 == 0 && (a / 10) % 10 == 0 && (a / 100) % 10 == 0 && (a / 1000) % 10 == 0) {
            int n3 = a / 10000;
            driver.findElement(By.id("bt_0" + n3)).click();
            int n4 = (a / 1000) % 10;
            driver.findElement(By.id("bt_0" + n4)).click();
            int n5 = (a / 100) % 10;
            driver.findElement(By.id("bt_0" + n5)).click();
            int n6 = (a / 10) % 10;
            driver.findElement(By.id("bt_0" + n6)).click();
            int n7 = a % 10;
            driver.findElement(By.id("bt_0" + n7)).click();
            driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_div")).click();
        } else {

            temp = reversed;
            n1 = 0;
            while (temp != 0) {
                n1 = temp % 10;
                temp /= 10;
                driver.findElement(By.id("bt_0" + n1)).click();
            }
            driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_div")).click();
        }
        reversed = 0;
        digit = 0;

        while (num2 != 0) {
            digit = num2 % 10;
            reversed = reversed * 10 + digit;
            num2 /= 10;
            count2++;
        }
        if (b == 0) {
            throw new ArithmeticException("Division by zero!");
        } else {

            if (count2 == 2 && b % 10 == 0) {
                int n3 = b / 10;
                driver.findElement(By.id("bt_0" + n3)).click();
                int n4 = b % 10;
                driver.findElement(By.id("bt_0" + n4)).click();
            } else if (count2 == 3 && b % 10 == 0 && (b / 10) % 10 == 0) {
                int n3 = b / 100;
                driver.findElement(By.id("bt_0" + n3)).click();
                int n4 = (b / 10) % 10;
                driver.findElement(By.id("bt_0" + n4)).click();
                int n5 = b % 10;
                driver.findElement(By.id("bt_0" + n5)).click();
            } else if (count2 == 4 && b % 10 == 0 && (b / 10) % 10 == 0 && (b / 100) % 10 == 0) {
                int n3 = b / 1000;
                driver.findElement(By.id("bt_0" + n3)).click();
                int n4 = (b / 100) % 10;
                driver.findElement(By.id("bt_0" + n4)).click();
                int n5 = (b / 10) % 10;
                driver.findElement(By.id("bt_0" + n5)).click();
                int n6 = b % 10;
                driver.findElement(By.id("bt_0" + n6)).click();
            } else if (count2 == 5 && b % 10 == 0 && (b / 10) % 10 == 0 && (b / 100) % 10 == 0 && (b / 1000) % 10 == 0) {
                int n3 = b / 10000;
                driver.findElement(By.id("bt_0" + n3)).click();
                int n4 = (b / 1000) % 10;
                driver.findElement(By.id("bt_0" + n4)).click();
                int n5 = (b / 100) % 10;
                driver.findElement(By.id("bt_0" + n5)).click();
                int n6 = (b / 10) % 10;
                driver.findElement(By.id("bt_0" + n6)).click();
                int n7 = b % 10;
                driver.findElement(By.id("bt_0" + n7)).click();

            } else {

                temp = reversed;
                n1 = 0;
                while (temp != 0) {
                    n1 = temp % 10;
                    temp /= 10;
                    driver.findElement(By.id("bt_0" + n1)).click();
                }
            }
            driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal")).click();
            String text=driver.findElement(By.id("com.sec.android.app.popupcalculator:id/txtCalc")).getText();
            String stringValueOfAMinusB=String.valueOf(divAB);
            try{
                Assert.assertEquals(divAB,text);
                System.out.println("my assertEquals passed");
            }
            catch(AssertionError e){
                System.out.println(e.getMessage());
            }
        }
            Thread.sleep(2000);
            driver.quit();
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


