package day10_FileTest;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C01_FileInputStream {

    @Test
    public void test01() throws FileNotFoundException {

        String dosyaYolu="C:\\Users\\PC\\Desktop\\MerhabaJava.docx";

        FileInputStream fis=new FileInputStream(dosyaYolu);


        System.out.println(System.getProperty("user.dir"));
        // C:\Users\PC\Documents\com.Team105JUnit

        System.out.println(System.getProperty("user.home"));
        // kullanicinin temel path' ini verir.
        // C:\Users\PC

        // masaustune gitmek istersek
        // C:\Users\PC + \Desktop eklemeliyiz

        // Downloads'a gitmek istersek
        // C:\Users\PC + \Downloads eklemeliyiz

        // Kpdlarinizin dinamik olmasi yani kisinin bilgisayarindaki
        // kullanici adi gibidetaylara takilmamasi icin
        // File testlerinde kullanilacak dosya yolunu
        // user.home...  temel path'ini calistigi bilgisayardan alacak sekilde olustururuz.


        //  dosyaYolu="C:\\Users\\PC\\Desktop\\MerhabaJava.docx";
        String dinamikDosyaYolu=System.getProperty("user.home")+"\\\\Desktop\\\\MerhabaJava.docx";

    }
}
