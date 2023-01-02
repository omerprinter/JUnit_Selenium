package day12_webtables_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {

        // dosya yolunu olusturalim
        String dosyaYolu="src/test/java/day12_webtables_excel/ulkeler.xlsx";
        // FileInputStream objesi olusturup parametre olrak dosyaYolu nu verelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        // kod alanimizda excel' in bir kpyasini olusturup
        // tum bilgileri ona kopyaliyacagiz

        Workbook workbook= WorkbookFactory.create(fis);

        // istedigimin sayfaya gidelim

        Sheet sheet= workbook.getSheet("Sayfa1");

        // Angola yazdirmak icin 5. satira gidelim
        Row row= sheet.getRow(5);

        // 5.satirda 2. index i getirelim
        Cell cell=row.getCell(2);

        System.out.println(cell);



    }
}
