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
    public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}
@After
    public void tearDown(){
    driver.quit();
}
@Test
    public void test01(){

    // Testin ilerleyen asamalarinda
    // yeniden amazon sayfasina donmek gerekiyorsa
    // bu sayfadayken bu window ;un window handle degerini kaydetmeliyiz
    driver.get("https://www.amazon.com");
    String amazonHandleDegeri=driver.getWindowHandle();

    // yeni tab da wisequarter.com 'a gidip test edin
    driver.switchTo().newWindow(WindowType.TAB);
    driver.get("https://www.wisequarter.com");
    String expectedUrl="wisequarter";
    String actualUrl=driver.getCurrentUrl();
    Assert.assertTrue(actualUrl.contains(expectedUrl));


    // wiseuarter  testini yaptiktan sonra yeniden amazon' un acik oldugu Taba gecin ve
    driver.switchTo().window(amazonHandleDegeri);
    // amazon anasayfanin acik oldugunu test edin
    String expectedAmazonUrl="amazon";
    String actualAmazonUrl=driver.getCurrentUrl();
    Assert.assertTrue(actualAmazonUrl.contains(expectedAmazonUrl));
    }
}
