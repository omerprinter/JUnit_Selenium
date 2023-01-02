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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class kiwiTest {

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
       // driver.close();
    }
    @Test
    public void test01(){
        // https://www.kiwi.com sayfasina gidin
        driver.get("https://www.kiwi.com");

        // Cookies i reddedin
        driver.findElement(By.xpath("(//div[@class='ButtonPrimitiveContent__StyledButtonPrimitiveContent-sc-1r81o9a-0 ULnUg'])[1]")).click();

        // Kayfa basliginin "kiwi" icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Kiwi"));

        // Sag ust kisimdan dil ve para birimi secenegini Turkiye ve TL olarak secin
        //driver.findElement(By.xpath("(//div[@class='ButtonPrimitiveContent__StyledButtonPrimitiveContent-sc-1r81o9a-0 ZYrQU'])[7]")).click();
        driver.findElement(By.xpath("//*[text()='TRY']")).click();
        WebElement dilBox= driver.findElement(By.xpath("//*[@data-test='LanguageSelect']"));
        Select selectDil=new Select(dilBox);
        selectDil.selectByVisibleText("Türkçe");

       // driver.findElement(By.xpath("//*[@data-test='CurrencySelect']")).click();
        WebElement currencyBox=driver.findElement(By.xpath("//*[@data-test='CurrencySelect']"));
        Select selectCurrency=new Select(currencyBox);
        selectCurrency.selectByVisibleText("Turkish lira - TRY");

        // Sectiginiz dil ve para birimini dogrulayin
        driver.findElement(By.xpath("//*[text()='Kaydet ve devam et']")).click();


        // Ucus secenegi olarak tek yon secelim
        // Kalkis ve varis boxlarini temizleyerek kalkis ve varis ulkesini kendimiz belirleyelim
        // Gidis tarihi kismina erisim saglayarak gidecegimiz gunu secelim ve booking i iptal edelim
        // Sadece aktarmasiz ucuslar olarak filtreleme yapalim ve en ucuz secenegine tiklayalim
        // Filtreleme yaptigimiz en ucuz ucusun fiyatini getirerek 5000 tl den kucuk oldgunu dogurlayalim

    }

}
