package day06_assertions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_BestbuyAssertion extends TestBase {
    /*
1) Bir class oluşturun: BestBuyAssertions
2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
 ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
 ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
 ○ logoTest => BestBuy logosunun görüntülendigini test edin
 ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
 */
    @Test
    public void test01(){
        //https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
        driver.get("https://www.bestbuy.com/");

        // ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String expectedTitle="Rest";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedTitle));

        // ○ logoTest => BestBuy logosunun görüntülendigini test edin
       WebElement logoElement= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
       Assert.assertTrue(logoElement.isDisplayed());

        // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement francisElement= driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue(francisElement.isDisplayed());

        ReusableMethods.bekle(1);
    }

}
