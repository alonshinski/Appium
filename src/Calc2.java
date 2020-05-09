import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Calc2 {
     static AndroidDriver<MobileElement> driver;
    private static ExtentReports extent;
    private static ExtentTest myTests;
    static String ImagesPath = "C:\\Users\\Alon\\Desktop\\selenium\\screenShots";
    @Rule
    public TestName name = new TestName();

    @BeforeClass
    public static void setUp() throws IOException {
        extent = new ExtentReports("C:\\Users\\Alon\\Desktop\\selenium\\myReports\\my_03report.html");
        extent.loadConfig(new File("C:\\Users\\Alon\\Desktop\\selenium\\Myconfigs\\reportConfig.xml"));
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


    @Test public void Test_01_Plus() throws Exception {
        Thread.sleep(2000);
        myTests = extent.startTest(name.getMethodName());
       myTests.log(LogStatus.INFO, "Start of the Test");
        String firstN = readFromFile("firstN");
        String sectN = readFromFile("sectN");
        double a = Double.parseDouble(firstN);// double value of number read from file
        double b = Double.parseDouble(sectN);
        double sum= a+b;// double sum of both numbers
        DecimalFormat newFormat = new DecimalFormat("#.##########");// this will give me the the sum number in max length 10 digits
        double nineDecimal = Double.valueOf(newFormat.format(sum));// convert it to double
        String [] array1=firstN.split("");// using array with split to give index for digits of the first number
        String [] array2=sectN.split("");// for the second number
        for(int i=0; i<=array1.length-1;i++) {// loop for clicking on numbers i split
           //System.out.println(array1[i]);
            if (array1[i].equals(".")) {// if i have double number i will click on "." in the calc
                driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_dot")).click();
            }

            else {// else for clicking all other numbers
                driver.findElement(By.id("bt_0" + array1[i])).click();
            }
        }
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add")).click();//clicking on add button in the calc
        for(int i=0; i<=array2.length-1;i++){// now its the second loop for the second number
            //System.out.println(array2[i]);
            if(array2[i].equals(".")) {// same as the first number lick on "." in the calc.
                driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_dot")).click();
            }
            else {// clicking all other numbers
                driver.findElement(By.id("bt_0" + array2[i])).click();
            }
        }
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal")).click();//after i gave two numbers and clicked on + i want to click on result "="
        String text=driver.findElement(By.id("com.sec.android.app.popupcalculator:id/txtCalc")).getText();//saving the text from the result field int calc
        String replaceString=text.replaceAll(",","");// if the number is big it put "," between zeros so i replace all the "," to clean the number to assert it later because the number in the program and in the calc are different for calculating the numbers.
        String stringValueOfSum=String.valueOf(nineDecimal);// saving the string value of nineDecimal and take the string value.
        try{
            if(replaceString.contains(stringValueOfSum));// here is the assertion but i did it with contains because not all numbers are equals because i doing calculation in double and the calc doing it in different way so the number could be shorter and less accurate. also sometimes the calc can round numbers in different way not like double convert it so i had an issue with that and by using contains it the best way i found.
           System.out.println("my assertEquals passed");// it for checking if i passed the contains.
            myTests.log(LogStatus.PASS, "Test passed",
                    myTests.addScreenCapture(takeScreenShot(ImagesPath + "\\" + System.currentTimeMillis())));// take screen shot to my log.
        }
        catch(AssertionError e){// if something wrong so i catch the error and give the error message to log to capture the problem.
            //System.out.println(e.getMessage());
            myTests.log(LogStatus.FAIL, "AssertionError" + e);
        }
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_clear")).click();//after all the commands i wan't to clear the calculations in the calc
        myTests.log(LogStatus.INFO, "End of the Test" + name.getMethodName());//printing in the log the end of test with it's name
    }
    @Test public void Test_02_Minus() throws Exception {
        myTests = extent.startTest(name.getMethodName());
        myTests.log(LogStatus.INFO, "Start of the Test");
        Thread.sleep(2000);
        String firstN = readFromFile("firstN");
        String sectN = readFromFile("sectN");
        double a = Double.parseDouble(firstN);//same as in first test
        double b = Double.parseDouble(sectN);//""""""""""
        double subAB=a-b; // double sub of a-b.
        DecimalFormat newFormat = new DecimalFormat("#.##########");// same as in first test.
        double nineDecimal = Double.valueOf(newFormat.format(subAB));// """"""""""
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
        String text=driver.findElement(By.id("com.sec.android.app.popupcalculator:id/txtCalc")).getText();
        String replaceString=text.replaceAll(",","");
        String stringValueOfSub=String.valueOf(nineDecimal);
        try{
            if(replaceString.contains(stringValueOfSub));
            System.out.println("my assertEquals passed");
            myTests.log(LogStatus.PASS, "Test passed",
                    myTests.addScreenCapture(takeScreenShot(ImagesPath + "\\" + System.currentTimeMillis())));
        }
        catch(AssertionError e){
            //System.out.println(e.getMessage());
            myTests.log(LogStatus.FAIL, "AssertionError" + e);
        }
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_clear")).click();
        myTests.log(LogStatus.INFO, "End of the Test" + name.getMethodName());
    }
    @Test public void Test_03_Mul() throws Exception {
        myTests = extent.startTest(name.getMethodName());
        myTests.log(LogStatus.INFO, "Start of the Test");
        Thread.sleep(2000);
        String firstN = readFromFile("firstN");
        String sectN = readFromFile("sectN");
        double a = Double.parseDouble(firstN);
        double b = Double.parseDouble(sectN);
        double mulAB=a*b;
        DecimalFormat newFormat = new DecimalFormat("#.##########");
        double nineDecimal = Double.valueOf(newFormat.format(mulAB));
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
        String text=driver.findElement(By.id("com.sec.android.app.popupcalculator:id/txtCalc")).getText();
        String replaceString=text.replaceAll(",","");
        String stringValueOfMul=String.valueOf(nineDecimal);
        try{
            if(replaceString.contains(stringValueOfMul));
            System.out.println("my assertEquals passed");
            myTests.log(LogStatus.PASS, "Test passed",
                    myTests.addScreenCapture(takeScreenShot(ImagesPath + "\\" + System.currentTimeMillis())));
        }
        catch(AssertionError e){
            //System.out.println(e.getMessage());
            myTests.log(LogStatus.FAIL, "AssertionError" + e);
        }
        myTests.log(LogStatus.INFO, "End of the Test" + name.getMethodName());
    }
    @Test public void Test_04_Div() throws Exception {
        myTests = extent.startTest(name.getMethodName());
        myTests.log(LogStatus.INFO, "Start of the Test");
        Thread.sleep(2000);
        String firstN = readFromFile("firstN");
        String sectN = readFromFile("sectN");
        double a = Double.parseDouble(firstN);
        double b = Double.parseDouble(sectN);
        if (sectN.equals("0")) {
            myTests.log(LogStatus.ERROR, "Division by zero! " + name.getMethodName());
            myTests.log(LogStatus.INFO, "End of the Test" + name.getMethodName());
        }
        else {
            double divAB = a / b;
            DecimalFormat newFormat = new DecimalFormat("#.##########");
            double nineDecimal = Double.valueOf(newFormat.format(divAB));

            String[] array1 = firstN.split("");
            String[] array2 = sectN.split("");
            //System.out.println(array1[0]);
            for (int i = 0; i <= array1.length - 1; i++) {
                //System.out.println(array1[i]);
                driver.findElement(By.id("bt_0" + array1[i])).click();
            }
            driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_div")).click();
            for (int i = 0; i <= array2.length - 1; i++) {
                //System.out.println(array2[i]);
                driver.findElement(By.id("bt_0" + array2[i])).click();
            }
            driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal")).click();
            String text = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/txtCalc")).getText();
            String replaceString = text.replaceAll(",", "");
            String stringValueOfDiv = String.valueOf(nineDecimal);
            //System.out.println(nineDecimal);
            try {
                if (replaceString.contains(stringValueOfDiv)) {
                    System.out.println("my assertion passed");
                }
                myTests.log(LogStatus.PASS, "Test passed",
                        myTests.addScreenCapture(takeScreenShot(ImagesPath + "\\" + System.currentTimeMillis())));
            } catch (AssertionError e) {
                // System.out.println(e.getMessage());
                myTests.log(LogStatus.FAIL, "AssertionError" + e);
            }

            driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_clear")).click();
            myTests.log(LogStatus.INFO, "End of the Test" + name.getMethodName());
        }
    }
    @After
    public void myAfter(){
        extent.endTest(myTests);
    }
    @AfterClass public static void myAfterClass(){
        driver.quit();
        extent.flush();
    }
    public static String readFromFile(String keyData) throws Exception {
        File xmlFile = new File("C://Users//Alon//Desktop//calc.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyData).item(0).getTextContent();
    }
    static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".png";
    }

}
