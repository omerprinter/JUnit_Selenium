package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_WindowHandle {

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
        // https://the-internet.herokuapp.com/iframe adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");
        String birinciWHD=driver.getWindowHandle();

        // elemental selenium linkini tiklayin
        driver.findElement(By.linkText("Elemental Selenium")).click();
        String ikinciWHD="";
        Set<String> tumWHD=driver.getWindowHandles();
        for (String eachWHD:tumWHD) {
            if (!eachWHD.equals(birinciWHD)){
                ikinciWHD=eachWHD;
            }
        }

        // yeni tab'a gecip sayfadaki en buyuk yazinin "Elemental Selenium" oldugunu test edin
        driver.switchTo().window(ikinciWHD);
        String expBuyukYazi="Elemental Selenium";
        String actBuyukYazi=driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expBuyukYazi,actBuyukYazi);

        // ilk sayfaya geri donup sayfadaki yazinin
        driver.switchTo().window(birinciWHD);

        // "An iFrame containing the TinyMCE WYSIWYG Editor" oldugunu test edin
        String expIlkYazi="An iFrame containing the TinyMCE WYSIWYG Editor";
        String actIlkYazi=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expIlkYazi,actIlkYazi);

    }
}
