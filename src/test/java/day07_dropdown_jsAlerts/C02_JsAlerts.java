package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_JsAlerts {


    // Gerekli ayarlamalari yapip
    // https://the-internet.herokuapp.com/javascript_alerts   adresine gidip
    // 3 test methodu olusturup her method'da bir JsAlert'e basin
    // ilgili methodlari kulanin

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @AfterClass
    public static void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // 1. alert'e basalim
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        // Alertteki zinin "I am a JS Alert"  oldugunu test edelim

        String actualAlertYazisi=driver.switchTo().alert().getText();
        String expectedAlertYazisi= "I am a JS Alert";
        Thread.sleep(1000);
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        // OK tusuna basalim
        driver.switchTo().alert().accept();

    }

    @Test
    public void test02() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // 2. alert e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();

        // cancel a basip cikan yazinin "You clicked: Cansel"  oldugunu test edin
        Thread.sleep(1000);
        driver.switchTo().alert().dismiss();

       String actualSonucYazisi=driver.findElement(By.xpath("//*[text()='You clicked: Cancel']")).getText();

       String expectedSonucYazisi="You clicked: Cancel";

       Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);

    }

    @Test
    public void test03() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // 3. alert e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();


        // cikan ekrana "Abdullah"  yazdiralim  ve OK 'a basarak Alert  i kapatalim
        driver.switchTo().alert().sendKeys("Abdullah");
        Thread.sleep(1000);

        driver.switchTo().alert().accept();

        // cikan sonuc yazisinin Abdullah icerdigini test edelim
        String actualSonucYazisi=driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedKelime="Abdullah";

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
    }

}









