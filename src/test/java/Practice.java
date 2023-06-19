import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Practice {


    public static void main(String args[]) throws InterruptedException, IOException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();

        /*driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
        Select select = new Select(dropdown);
        List<WebElement> options  = select.getOptions();
        for(WebElement s : options){
            System.out.println(s.getText());
        }
        select.selectByIndex(2);

        driver.findElement(By.id("autocomplete")).sendKeys("Ind");
        List<WebElement> option = driver.findElements(By.cssSelector(".ui-menu-item-wrapper"));
        for(WebElement op : option){

            String country = op.getText();
            if(country.equalsIgnoreCase("India")){
                op.click();
            }
        }
        Thread.sleep(2000);
       WebElement radio = driver.findElement(By.xpath("//input[@value='radio2']"));
       radio.click();
       Boolean check = radio.isEnabled();
       System.out.println(check);
       WebElement checkbox = driver.findElement(By.cssSelector("#checkBoxOption2"));
       checkbox.click();
       Boolean ischeck = checkbox.isSelected();
       System.out.println(ischeck);
       driver.findElement(By.id("name")).sendKeys("Karthik");
       driver.findElement(By.cssSelector("#confirmbtn")).click();
       driver.switchTo().alert().accept();*/


/*        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

       List<String> vegeies = new ArrayList<>();
       vegeies.add("Tomato");
       vegeies.add("Potato");
       int vegSize = vegeies.size();
       int v =0;
       List<WebElement> vegetables = driver.findElements(By.tagName("h4"));
       for(int i =0; i<vegetables.size(); i++){

           String[] getVegName = vegetables.get(i).getText().split("-");
           String getShortName = getVegName[0].trim();
           if(vegeies.contains(getShortName)){
               v++;
               driver.findElements(By.cssSelector(".product-action")).get(i).click();
               Thread.sleep(2000);
               if(v==vegSize){
                   break;
               }
           }

       }
       driver.findElement(By.cssSelector(".cart-icon")).click();
       driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
       driver.findElement(By.cssSelector(".promoCode")).sendKeys("Karthik");
       driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
        String promoMessage = driver.findElement(By.cssSelector(".promoInfo")).getText();
        System.out.println(promoMessage);
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();*/



//        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

 /*       driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> windowIds = driver.getWindowHandles();
        Iterator<String> ids = windowIds.iterator();
        String parentId = ids.next();
        String childId = ids.next();
        driver.switchTo().window(childId);
        Thread.sleep(5000);
       String email = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1];
       String emailAddress = email.trim().split(" ")[0];
       System.out.println(email);
       System.out.println(emailAddress);*/

        Actions ac = new Actions(driver);
        WebElement ele = driver.findElement(By.cssSelector(".gf-t"));
        ac.moveToElement(ele).build().perform();

        List<WebElement> footers = driver.findElements(By.xpath("(//table[@class='gf-t'])//td[1]/ul/li/a"));
        SoftAssert sa = new SoftAssert();

        for(WebElement e : footers){
//             ac.moveToElement(e).keyDown(Keys.CONTROL).click().build().perform();
            String url = e.getAttribute("href");
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("HEAD");
            con.connect();
            int code =  con.getResponseCode();
            System.out.println(code);
            sa.assertTrue(code<400,"BrokenLinkFound" + code);
        }


        driver.quit();



    }


}
