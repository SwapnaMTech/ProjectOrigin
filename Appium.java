package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class flipkartFlow {
    public static AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
//        startAppiumService(String.valueOf(portNumber));
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "ANDROID");
        cap.setCapability("appium:platformVersion", "12.0");
        cap.setCapability("appium:deviceName", "Android phone");
        cap.setCapability("appium:udid", "RZCWA29JEJK");
        cap.setCapability("appium:automationName", "UiAutomator2");
//       cap.setCapability("app","C:\\Users\\aramesh\\Downloads\\AmazonShopping.apk");
        cap.setCapability("appium:appPackage", "com.flipkart.android");
        cap.setCapability("appium:appActivity", "com.flipkart.android.activity.HomeFragmentHolderActivity");
//            cap.setCapability("orientation", "landscape");
        cap.setCapability("noReset","true");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4724/wd/hub"), cap);
//        driver.quit();
//        mCurrentFocus=Window{22c16fc u0 com.amazon.mShop.android.shopping/com.amazon.mShop.navigation.MainActivity}
    }


//    @Test
//    public void Login() throws InterruptedException {
//        //Choose language on first launch
//        driver.findElement(By.xpath("(//android.widget.RelativeLayout[@resource-id=\"com.flipkart.android:id/locale_icon_layout\"])[4]")).click();
//        driver.findElement(By.id("com.flipkart.android:id/select_btn")).click();
//        //Login
//        driver.findElement(By.id("com.flipkart.android:id/phone_input")).sendKeys("9743656885");
//        driver.findElement(By.id("com.flipkart.android:id/button")).click();
//        Thread.sleep(10000);
//        driver.findElement(By.id("com.flipkart.android:id/button\n")).click();

//    }

    @Test
    public void ProductSearch() throws InterruptedException {
//        Thread.sleep(3000);
        // Wait for the element to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        WebElement ProductSearchBar = driver.findElement(By.xpath("//android.view.ViewGroup/android.widget.ImageView"));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"tv\"]/android.view.ViewGroup/android.widget.ImageView")));
        element.click();
//        element.sendKeys("Iphone 14");
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.xpath("//android.widget.EditText[@text=\"tv\"]"));
        search.sendKeys("iphone");
//        search.sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        //Notification permission
        driver.findElement(By.id("com.flipkart.android:id/not_now_button")).click();

        //3rd product
        driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup")).click();

        //buy product
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"Buy now\"]\n")).click();


    }
}