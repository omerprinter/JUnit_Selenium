package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_AssertionMethodlari {

    // @BeforeClass ve @AfterClass notasyonu kullanan method'lar
    // static olmak zorundadir
    // 1.method'da amazon'a gidip, amazona gittigimizi test edin
    // 2.method'da amazon'da nutella aratip, sonuclarin nutella icerdigini test edin
    // 3.method'da nutella arama sonuc sayisinin 50'den fazla oldugunu test edin

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        System.out.println("setup worked");
    }
    @AfterClass
    public static void teardown(){
        driver.close();
        System.out.println("teardown worked");
    }
    // 1.method'da amazon'a gidip, amazona gittigimizi test edin
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        String expectedKelime="Amazon";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedKelime));
    }
    // 2.method'da amazon'da nutella aratip, sonuclarin nutella icerdigini test edin
    @Test
    public void test02(){
        WebElement searcBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searcBox.sendKeys("Nutella"+ Keys.ENTER);
        String expectedKelime="Nutella";
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//*[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String sonucYaziStr=sonucYaziElementi.getText();
        Assert.assertTrue(sonucYaziStr.contains(expectedKelime));
    }
    // 3.method'da nutella arama sonuc sayisinin 50'den fazla oldugunu test edin
   @Test
            public void test03(){
       WebElement sonucYaziElementi= driver.findElement(By.xpath("//*[@class='a-size-base s-desktop-toolbar a-text-normal']"));
       String sonucYaziStr=sonucYaziElementi.getText();
       String [] sonucArr=sonucYaziStr.split(" ");
       String sonucAdediYazisi=sonucArr[2];
       int actualSonucAdedi=Integer.parseInt(sonucAdediYazisi);
       int expectedSonucSayisi=50;
       Assert.assertTrue(actualSonucAdedi>expectedSonucSayisi);
   }


}
