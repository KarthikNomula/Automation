import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MobilePractise {


    public static void main(String args[]) throws MalformedURLException, InterruptedException {

        AppiumDriverLocalService service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\Evoke\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.01")
                .usingPort(4723).build();
//        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setUdid("RFCT909K84B");
        String filepath = System.getProperty("user.dir") + "\\Lib\\ApiDemos-debug.apk";
        options.setApp(filepath);
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.01:4723/wd/hub"), options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

 /*       driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        driver.findElement(By.id("android:id/edit")).sendKeys("Wifi");
        driver.findElement(By.id("android:id/button1")).click();
//        driver.findElements(AppiumBy.className("android.widget.Button")).get(2).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.BACK));*/

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
    /*    driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]")).click();
        WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),"duration",2000
        ));*/

       /* driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable (new UiSelector()).scrollIntoView(text(\"WebView\"));"));*/

        boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 200,
                "direction", "down",
                "percent", 3.0
        ));



        Thread.sleep(2000);





        driver.quit();
        service.stop();



    }
}