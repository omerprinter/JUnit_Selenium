package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class alibaba_com {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }
    @Test
    public void test() throws InterruptedException {
//https://www.alibaba.com/?spm=a2700.7699653.0.0.7bc23e5f7N3QQV
        driver.get("https://www.alibaba.com/?spm=a2700.7699653.0.0.7bc23e5f7N3QQV");
        String ilkSayfaHandle= driver.getWindowHandle();
        Thread.sleep(2000);

        //cookies i kabul edin veya reddedin
      //  driver.findElement(By.xpath("//*[text()='Reject']")).click();

//shipto kismina giderek ulke olarak turkiye yi secelim ve kaydedelim
        Actions actions=new Actions(driver);
        WebElement shipTo=driver.findElement(By.xpath("(//label[@class='ellipsis'])[3]"));

        actions.moveToElement(shipTo).clickAndHold(shipTo).perform();
        WebElement country= driver.findElement(By.xpath("//div[@data-role='select-country']"));
        actions.moveToElement(country).click(country).perform();

        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@placeholder='Enter keyword to search.']"));
        actions.sendKeys(aramaKutusu,"Turkey").perform();
        driver.findElement(By.xpath("(//li[@data-value='TR'])[1]")).click();
        driver.findElement(By.xpath("(//button[@data-role='save'])[3]")).click();

        //sayfanin en altina inerek dil olarak turkceyi secelim
        Thread.sleep(2000);
        actions.sendKeys(Keys.END).perform();
        driver.findElement(By.xpath("//a[text()='Türk']")).click();

        //categori kismina giderek tarim seceneginin ustune gelelim
        WebElement kategori= driver.findElement(By.xpath("(//h3[@class='header-category-trigger'])[2]"));
        actions.moveToElement(kategori).clickAndHold(kategori).perform();
        Thread.sleep(2000);
        WebElement tarim= driver.findElement(By.xpath("(//div[@class='title'])[33]"));
        actions.scrollToElement(tarim).clickAndHold(tarim).perform();

        // ve acilan yan sayfadan tarim ekipmanlarini secelim
       WebElement tarimEkipmanlari  = driver.findElement(By.xpath("(//a[text()='Tarım Ekipmanları'])[2]"));
        actions.moveToElement(tarimEkipmanlari).click(tarimEkipmanlari).perform();

        //tekrardan ilk sayfaya gecelim
        driver.switchTo().window(ilkSayfaHandle);

    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
