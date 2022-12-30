package day09_actions;

import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_MoveToElement extends TestBase {

    @Test
    public void test01(){
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        // beklenecek web element olusturulur
        Actions actions=new Actions(driver);


        //3- “Create a list” butonuna basin
        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin


    }
}
