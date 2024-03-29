package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @Test
    public void LoginTest1(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/webOrders/login.aspx");
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']")).sendKeys("Tester2");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("tes2t"+ Keys.ENTER);
        String errorMsg=driver.findElement(By.id("ctl00_MainContent_status")).getText();
        Assert.assertEquals(errorMsg,"Invalid Login or Password.");
    }
    @Test
    public void loginOut(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/webOrders/login.aspx");
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"+ Keys.ENTER);
        driver.findElement(By.id("ct100_logout")).click();
        Assert.assertEquals(driver.getTitle(),"Web Orders Login");
    }
    @AfterMethod
    public void Logout(){
        driver.close();


    }
}















