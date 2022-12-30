package day10_FileTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_FileUpLoadTesti extends TestBase {
// test
    @Test
    public void test01(){
        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //2.chooseFile butonuna basalim
        //3.Yuklemek istediginiz dosyayi secelim
        /*
        Bu gorev icin chooseFile butonuna basildiginda
        acilan bilgisayarimizdaki file dosyalarini
        click yapabilmemiz gerekir, ancak selenium' da bu mumkun degildir.
        Bunun icin:
        1- chooseFile butonunu locate edin
        2- upload edilecek dosyanin dosya yolu olusturulur
        3- chooseFile butonuna sendKeys ile dosya yolunu verelim
         */
        WebElement chooseFileButton= driver.findElement(By.xpath("//input[@id='file-upload']"));

        String dosyaYolu= System.getProperty("user.home")+"\\\\Desktop\\\\MerhabaJava.docx";

        chooseFileButton.sendKeys(dosyaYolu);

        //4.Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();

        //5.“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadedElementi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedElementi.isDisplayed());

        ReusableMethods.bekle(5);
    }
}
