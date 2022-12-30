package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_newWindow {
    // https://the-internet.herokuapp.com/windows
    /*
    Selenium 4 ile beraber window konusunda yeni ozellik geldi
    istersek kontrollu olarak driver icin yeni bir window veya TAB olusturabiliriz.
    Bu durumda driver'imiz yeni syafaya gecmis olur.

    Testin ilerleyen asamalarinda yeniden eski sayfalara donus gorevi varsa
    o  sayfada iken o sayfanin window Handle Degeri alinip kaydedilir ve
    o sayafaya gecmek istendiginde
    driver.switchTo().window(istenen windowHandleDegeri)
    kodu ile o sayfaya gecis yapilir.
     */

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
       driver.get("https://www.amazon.com");
        Thread.sleep(1000);

        // Testin ilerleyen asamalarinda
        // yeniden amazon sayfasina donmek gerekiyorsa
        // bu sayfadayken bu window ;un window handle degerini kaydetmeliyiz
        String ilkSayfaHandleDegeri= driver.getWindowHandle();

        // yeni tab da wisequarter.com 'a gidip test edin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");

        String actualUrl= driver.getCurrentUrl();
        String expectedKelime="wisequarter";
        Assert.assertTrue(actualUrl.contains(expectedKelime));
        Thread.sleep(1000);

        // wiseuarter  testini yaptiktan sonra yeniden amazon' un acik oldugu Taba gecin ve
        // amazon anasayfanin acik oldugunu test edin.
        driver.switchTo().window(ilkSayfaHandleDegeri);
        actualUrl= driver.getCurrentUrl();
        expectedKelime="amazon";
        Assert.assertTrue(actualUrl.contains(expectedKelime));
        Thread.sleep(1000);

    }




}
