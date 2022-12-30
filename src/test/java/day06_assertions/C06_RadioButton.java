package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_RadioButton {
    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    // a. Verilen web sayfasına gidin.
    //     https://facebook.com
    // b. Cookies’i kabul edin   //button[@title=‘Only allow essential cookies’]


    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        //driver.close();
    }
@Test
    public void test01() throws InterruptedException {
    // a. Verilen web sayfasına gidin.
    //     https://facebook.com
    driver.get("https://facebook.com");
    // b. Cookies’i kabul edin   //button[@title=‘Only allow essential cookies’]
// c. Create an account buton’una basin  //a[@class=‘_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy’]
   driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

    // d. Radio button elementlerini locate edin ve size uygun olani secin

    driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
    Thread.sleep(1000);

    }

}
