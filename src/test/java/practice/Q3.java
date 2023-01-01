package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.*;

public class Q3 extends TestBase {

     /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully
     */
    @Test
    public void test01(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement logoTest =driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        assertTrue(logoTest.isDisplayed());

        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[text()=' Contact us']")).click();

        //5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouch= driver.findElement(By.xpath("//h2[text()='Get In Touch']"));
        assertTrue(getInTouch.isDisplayed());

        //6. Enter name, email, subject and message
        WebElement firstNameTexeBox=driver.findElement(By.xpath("//input[@name='name']"));
        Actions actions=new Actions(driver);
        actions.click(firstNameTexeBox)
                .sendKeys("Bulent").sendKeys(Keys.TAB).sendKeys("Bulent@gmail.com").sendKeys(Keys.TAB).
                sendKeys("otomasyon").sendKeys(Keys.TAB).sendKeys("*Hello New Year*").perform();

        //7. Upload file  //   C:\Users\PC\Desktop\MerhabaJava.docx
        WebElement dosyaSecButonu= driver.findElement(By.xpath("//input[@name='upload_file']"));
        String dosyaYlu=System.getProperty("user.home")+"\\Desktop\\MerhabaJava.docx";
        dosyaSecButonu.sendKeys(dosyaYlu);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        //9. Click OK button
        driver.switchTo().alert().accept();

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement actMessage=driver.findElement(By.xpath("//div[text()='Success! Your details have been submitted successfully.']"));
        assertTrue(actMessage.isDisplayed());

        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//a[text()=' Home'][1]")).click();

        driver.findElement(By.id("dismiss-button")).click();

    }
}
