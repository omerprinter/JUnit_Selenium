package practice;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

public class Q1 extends TestBase {

    @Test
    public void test01() throws InterruptedException {
       //BeforeClass ile driver'i olusturun ve class icinde static yapin
        //    Maximize edin ve 10 sn bekletin
        //    http://www.google.com adresine gidin
        driver.get("http://www.google.com");

        //    arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@title='Ara']"));
        aramaKutusu.sendKeys("The Lord of the Rings"+ Keys.ENTER);
        WebElement aramaSonucElementi= driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(aramaSonucElementi.getText()); // Yaklaşık 304.000.000 sonuç bulundu (0,64 saniye)

        //    arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
        WebElement aramaKutusu2= driver.findElement(By.xpath("//input[@aria-label='Ara']"));
        aramaKutusu2.clear();
        aramaKutusu2.sendKeys("Brave Heart"+Keys.ENTER);
        WebElement sonucElementiBaveHeart= driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucElementiBaveHeart.getText()); // Yaklaşık 236.000.000 sonuç bulundu (0,57 saniye)

        //    arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
        WebElement aramaKutusu3= driver.findElement(By.xpath("//input[@aria-label='Ara']"));
        aramaKutusu3.clear();
        aramaKutusu3.sendKeys("Harry Potter"+Keys.ENTER);
WebElement sonucElementiHarryP=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucElementiHarryP.getText()); // Yaklaşık 508.000.000 sonuç bulundu (0,61 saniye)

        //    AfterClass ile kapatin

    }



}
