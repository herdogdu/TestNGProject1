package Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Test1 extends BaseClass {

    /*
deneme Halit
        https://app.hubspot.com/login

        Enter username and password
        Click on login button
        Click on contacts dropdown (on left top)
        Click on contacts button
        Click on create contact button
        Enter email
        Enter First name
        Enter Last name
        Click on Create Contact button
        Verify email and first name as entered
        Click on actions dropdown
        Click on delete button
        Click on Delete contact button

     */
    //Enter username and password
    public static void main(String[] args) throws InterruptedException {
        driver.navigate().to("https://app.hubspot.com/login");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Thread.sleep(4000);
        //WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("haliterdogdu@hotmail.com");
        WebElement password = driver.findElement(By.cssSelector("input[id='password']"));
        password.sendKeys("GAAtl12@");
        //Click on login button
        WebElement loginButton=driver.findElement(By.xpath("//button[@data-test-id='password-login-button']"));
        loginButton.click();

       // Click on contacts dropdown (on left top)
       // Click on contacts button
       // Click on create contact button


        //*[@id="nav-primary-contacts-branch"]/svg
        WebElement contacts=driver.findElement(By.xpath("//*[@id='nav-primary-contacts-branch']/svg"));
        contacts.click();
    }

}
