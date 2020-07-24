package Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test2 extends BaseClass {


    /*
        https://app.hubspot.com/login

        Enter username and password
        Click on login button
        Click on contacts dropdown (on left top)
        Click on companies button
        Click on create companies button
        Enter the company domain
        Enter the name
        Click on Create company button
        Verify company domain as entered
        Click on actions dropdown
        Click on delete button
        Click on Delete contact button

     */

    @Test
    @Parameters({"domain","companyName"})
    void createCompany(String domain, String companyName) throws InterruptedException{
       // driver.navigate().to("https://app.hubspot.com/login");
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));


        // Enter username and password
        //Click on login button
        //Click on contacts dropdown (on left top)
        //Click on companies button
        //Click on create companies button
       /*
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("haliterdogdu@hotmail.com");
        WebElement password = driver.findElement(By.cssSelector("input[id='password']"));
        password.sendKeys("GAAtl12@");
        WebElement loginButton = driver.findElement(By.xpath("//button[@data-test-id='password-login-button']"));
        loginButton.click();

        */
        WebElement contacts = driver.findElement(By.xpath("//a[@id='nav-primary-contacts-branch'][1]"));
        contacts.click();
       WebElement addCompany = driver.findElement(By.xpath("//a[@id='nav-secondary-companies'][1]"));
       addCompany.click();
       WebElement createCompany = driver.findElement(By.xpath("//span[text()='Create company']"));
      createCompany.click();
      /*
         Enter the company domain
        Enter the name
        Click on Create company button
        Verify company domain as entered
       */
        driver.findElement(By.cssSelector("input[data-field='domain']")).sendKeys(domain);
        driver.findElement(By.xpath("//input[@data-selenium-test='property-input-name']")).clear();
        driver.findElement(By.xpath("//input[@data-selenium-test='property-input-name']")).sendKeys(companyName);
//span[text()='Create contact']  //span[text()='Create company'][2]
        WebDriverWait wait = new WebDriverWait(driver , 20);

        WebElement confirmComp=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-selenium-test='base-dialog-confirm-btn']")));
        confirmComp.click();

        //Get the company domain

        WebElement getDomain =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test-id='domain-input']")));

       System.out.println("MY DOMAIN IS: "+getDomain.getText());


        Assert.assertEquals(getDomain.getText(),domain);
        /*
           Click on actions dropdown
           Click on delete button
           Click on Delete contact button
        */

WebElement actions=driver.findElement(By.xpath("//button[@data-selenium-test='profile-settings-actions-btn']"));
actions.click();

WebElement deleteButton=driver.findElement(By.cssSelector("button[data-selenium-test='profile-settings-profileSettings.delete']"));
deleteButton.click();

WebElement deleteConfirm=driver.findElement(By.cssSelector("[data-selenium-test='delete-dialog-confirm-button']"));
deleteConfirm.click();


    }

}