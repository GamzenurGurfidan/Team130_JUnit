package tests.day13_ExcelOtomasyon;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_WriteExcel {
    @Test
    public void writeExcelTesti() throws IOException {
        // 3) Adimlari takip ederek Sayfa1’deki1.satira kadar gidelim
        // 4) 5.hucreye yeni bir cell olusturalim
        // 5) Olusturdugumuz hucreye “Nufus” yazdiralim
        // 6) 2.satir nufus kolonuna 1500000 yazdiralim
        // 7) 10.satir nufus kolonuna 250000 yazdiralim
        // 8) 15.satir nufus kolonuna 54000 yazdiralim
        // 9) Dosyayi kaydedelim
        //10) Dosyayi kapatalim

        String dosyaYolu = "src/test/java/tests/day13_ExcelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        sayfa1.getRow(0).createCell(4);
        sayfa1.getRow(0).getCell(4).setCellValue("Nüfus");

        sayfa1.getRow(1).createCell(4).setCellValue("1500000");
        sayfa1.getRow(9).createCell(4).setCellValue("250000");
        sayfa1.getRow(14).createCell(4).setCellValue("54000");

        FileOutputStream fileOutputStream = new FileOutputStream(dosyaYolu);
        workbook.write(fileOutputStream);

        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();

    }
}
