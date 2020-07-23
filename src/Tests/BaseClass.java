package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseClass {


    public static WebDriver driver;

    @BeforeClass
    void setup(){

        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @BeforeMethod
            void loginThePage() {
        driver.navigate().to("https://app.hubspot.com/login");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("haliterdogdu@hotmail.com");
        WebElement password = driver.findElement(By.cssSelector("input[id='password']"));
        password.sendKeys("GAAtl12@");
        //Click on login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@data-test-id='password-login-button']"));
        loginButton.click();
    }

}