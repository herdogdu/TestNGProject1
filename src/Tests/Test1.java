package Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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

    @Test
    @Parameters({"email","firstName","lastName"})
    public void createContact(String email, String firstName, String lastName) throws InterruptedException {
        t

       // Click on contacts dropdown (on left top)
       // Click on contacts button
       // Click on create contact button


        //*[@id="nav-primary-contacts-branch"]/svg
        WebElement contacts=driver.findElement(By.xpath("//a[@id='nav-primary-contacts-branch'][1]"));
        contacts.click();
        WebElement contacts2=driver.findElement(By.xpath("//div[@style='color:inherit'][1]"));
        contacts2.click();
        WebElement createContact=driver.findElement(By.xpath("//span[text()='Create contact']"));
        createContact.click();
        //        Enter email
        //        Enter First name
        //        Enter Last name
        //        Click on Create Contact button
        driver.findElement(By.cssSelector("input[data-field='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[data-field='firstname']")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input[data-field='lastname']")).sendKeys(lastName);
       driver.findElement(By.xpath("//span[@class='private-loading-button__content private-button--internal-spacing'][1]")).click();
        //Verify email and first name as entered
        String getEmail=driver.findElement(By.xpath("//div[@data-selenium-test='property-input-email']")).getText();
        Assert.assertEquals(getEmail,email);
        String getName=driver.findElement(By.xpath("//span[@data-selenium-test='highlightTitle']")).getText();
        System.out.println(getEmail+getName);
        Assert.assertTrue(getName.startsWith(firstName));
        //Click on actions dropdown
        //Click on delete button
        //Click on Delete contact button
        driver.findElement(By.xpath("//span[@class='uiDropdown__buttonCaret private-dropdown__caret'][1]")).click();
        driver.findElement(By.xpath("//button[@data-selenium-test='profile-settings-profileSettings.delete']")).click();
        driver.findElement(By.xpath("//button[@data-selenium-test='delete-dialog-confirm-button']")).click();
    }

}
