package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class automationExerciseTest {

    // Gerekli setup islemlerini kuralim
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

        // https://www.automationexercise.com/ sayfasina gidelim
        driver.get("https://www.automationexercise.com/");

        // signUp linkine tiklayalim
        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();

        String expectedDeger="https://www.automationexercise.com/login";
        String actualDeger=driver.getCurrentUrl();
        Assert.assertEquals(expectedDeger,actualDeger);

    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){


        // name ve email adress kismina bilgiler gondererek uye olalim
        WebElement nameBox= driver.findElement(By.xpath("//input[@type='text']"));
        nameBox.sendKeys("ozgur");

        WebElement emailBox= driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        emailBox.sendKeys("ozgur@gmail.com");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        // uye olundugunu test edelim
        WebElement enterAccountTest=driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        Assert.assertTrue(enterAccountTest.isDisplayed());
    }

    @Test
    public void TestNegative(){
        // name ve email adress kismina bilgiler gondererek uye olalim
        WebElement nameBox= driver.findElement(By.xpath("//input[@type='text']"));
        nameBox.sendKeys("as");

        WebElement emailBox= driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        emailBox.sendKeys("ozgur.gmail.com");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

       WebElement newUserText= driver.findElement(By.xpath("//*[text()='New User Signup!']"));
       Assert.assertTrue(newUserText.isDisplayed());

    }


}












