package day05_junitFramework;

import org.junit.Ignore;
import org.junit.Test;

public class C01_ElvedaMainMethod {

    @Test
    public void test01(){
        System.out.println("test01 calisti");
        // @Test notasyonu sayesinde her bir test medhod'u bagımsız olarak çalışabilir
        // Eger testin içerisinde bir assertion yoksa kod problem yaşanmadan çalışıp bittiğinde
        //JUnit test passed olarak raporlar
    }
    @Test @Ignore
    public void test02(){
        System.out.println("test02 calisti");
    }
    @Test
    public void test03(){
        System.out.println("test03 calisti");
    }
}
