package practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.TestBase;


import static org.junit.Assert.*;

public class Q2 extends TestBase {
    //              ..Exercise2...
    @Before
    public void beforeTest(){
        //  http://www.bestbuy.com 'a gidin,
        driver.get("http://www.bestbuy.com");
    }

    @Test
    public void titleTest(){
//  Sayfa basliginin "Best" icerdigini(contains) dogrulayin
        String expTitle="Best";
        String actTitle= driver.getTitle();
        assertTrue(actTitle.contains(expTitle));

    }
    @Test
    public void logoTest(){
//  Ayrica Relative Locator kullanarak;
//      logoTest => BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin
        WebElement helloHeading=driver.findElement(By.xpath("(//div[@class='heading'])[1]"));  // (//div[@class='heading'])[1]
        WebElement bestBuyLogo= driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloHeading));
        assertTrue(bestBuyLogo.isDisplayed());

    }
    @Test
    public void linkTest(){
//  Ayrica Relative Locator kullanarak;
//      mexicoLinkTest => Linkin goruntulenip goruntulenmedigini dogrulayin
        WebElement unitedStatesLogo= driver.findElement(By.xpath("(//img[@alt='United States'])[1]"));
        WebElement mexicoLogoElement= driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(unitedStatesLogo));
        assertTrue(mexicoLogoElement.isDisplayed());

    }

}
