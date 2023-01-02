package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C02_WindowHandles {

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
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedText="Opening a new window";
        String actualText=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(actualText,expectedText);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle=driver.getTitle();
        String expectedTitle="The Internet";
        Assert.assertEquals(actualTitle,expectedTitle);
        String ilkSayfaHandleDegeri=driver.getWindowHandle();

        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
         /*
               Kontrolsuz acilan tab'a gecis yapmak icin
               1- ilk sayfada iken o sayfanin WHD alip kaydedin
               2- 2.sayfa acildiktan sonra getWindowhandles() kullanarak
                  acik olan tum sayfalarin WH degerlerini bir Set olarak kaydedin
               3- su anda elimizde 2 elementli bir Set var,
                  elementlerden bir tanesi 1.sayfanin WHD
                  1.sayfanin WHD'ine esit olmayan ise 2.sayfanin WHD olur
               4- bu sekilde 2.sayfanin WHD elde edildikten sonra
                  WHD'leri kullanilarak sayfalar arasinda gecis yapilabilir
         */
        Set<String> windowHanleDegerleri=driver.getWindowHandles();
        String ikinciSayfaHandleDegeri="";
        for (String eachWHD:windowHanleDegerleri) {
            if (!eachWHD.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaHandleDegeri=eachWHD;
            }
        }
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        String expectedTitle2="New Window";
        String actualTitle2=driver.getTitle();
        Assert.assertEquals(expectedTitle2,actualTitle2);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String expctedTxt2="New Window";
        String actualTxt2=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expctedTxt2,actualTxt2);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaHandleDegeri);
        actualTitle=driver.getTitle();
        expectedTitle="The Internet";
        Assert.assertEquals(actualTitle,expectedTitle);

        driver.switchTo().window(ikinciSayfaHandleDegeri);

    }

}
