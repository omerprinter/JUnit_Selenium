package day07_dropdown_jsAlerts;

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

public class C04_IFrame {
    //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
    // 2 ) Bir metod olusturun: iframeTest
    // - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
    // - Text Box’a “Merhaba Dunya!” yazin.
    // - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.

    static WebDriver driver;
    @Before
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @After
    public static void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement actualSayfaYazisiElementi=driver.findElement(By.tagName("h3"));

        Assert.assertTrue(actualSayfaYazisiElementi.isEnabled());
        Thread.sleep(1000);

        WebElement iframeWebElementi= driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));

        driver.switchTo().frame(iframeWebElementi);

        WebElement yaziKutuElementi=driver.findElement(By.xpath("//body[@id='tinymce']"));

         yaziKutuElementi.clear();
        yaziKutuElementi.sendKeys("Merhaba Dunya!");
        Thread.sleep(1000);

        // - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
        // IFrame'den cik demezsek driver Iframe 'de kalir.
        // Iframe'den cikmak icin :

        driver.switchTo().parentFrame(); // bir ust html sayfasina gider. ic icer iframe lerde tercih edilir
        driver.switchTo().defaultContent(); // ana sayfaya gecis yapar

        WebElement elementalSeleniumLinkElementi=driver.findElement(By.xpath("//div[text()=‘Powered by ’]"));
        Assert.assertTrue(elementalSeleniumLinkElementi.isDisplayed());
        System.out.println(elementalSeleniumLinkElementi.getText());

    }
}
