package tests.day13_ExcelOtomasyon;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C02_ReadExcel {
    @Test
    public void readExcelTesti() throws IOException {

        // - 1.satirdaki 2.hucreye gidelim ve yazdiralim
        // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        // - 2.satir 4.cell’in afganistan’in baskenti Kabil oldugunu test edelim
        // - Satir sayisini bulalim
        // - Fiziki olarak kullanilan satir sayisini bulun
        // - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        String dosyaYolu = "src/test/java/tests/day13_ExcelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");


        System.out.println(sayfa1.getRow(0).getCell(1)); // Başkent (İngilizce)

        String istenenHucre = sayfa1.getRow(0).getCell(1).toString();
        System.out.println(istenenHucre);

        String expectedHucreDegeri = "Kabil";
        String actualHucreDegeri = sayfa1.getRow(1).getCell(3).toString();

        Assert.assertEquals(expectedHucreDegeri,actualHucreDegeri);

        System.out.println(sayfa1.getLastRowNum()); // 190 son satırın indexini verdi

        System.out.println(sayfa1.getPhysicalNumberOfRows()); // 191 reel olarak kullanılan satır sayısını verir

        Sheet sayfa2 = workbook.getSheet("Sayfa2");

        System.out.println(sayfa2.getLastRowNum()); // 20
        System.out.println(sayfa2.getPhysicalNumberOfRows()); // 10

        // System.out.println(sayfa2.getRow(22).getCell(1)); // NullPointerException

        // workbook excel dosyasinda kullanilan son satirdan sonrasini almaz
        // o satirlara ulasmak isterseniz NullPointerException verir

        // System.out.println(sayfa2.getRow(5).getCell(10)); // NullPointerException

        System.out.println(sayfa2.getRow(6).getCell(10)); // null

        // System.out.println(sayfa2.getRow(5).getCell(5)); // NullPointerException

        System.out.println(sayfa2.getRow(6).getCell(20)); // null

        // Excell de ingilizce ülkle ismi Poland var mı



        boolean polandVarmi = false;

        for (int i = 0; i <=sayfa1.getLastRowNum() ; i++) {

            String satirdakiIngilizceUlkeIsmi = sayfa1.getRow(i).getCell(0).toString();

            if (satirdakiIngilizceUlkeIsmi.equalsIgnoreCase("Poland")){
                polandVarmi = true;
            }

        }
        Assert.assertTrue(polandVarmi);

        // Excelde ingilizce ismi Samoa ülkesinin baskentinin adinin Apia oldugunu test edin

        for (int i = 0; i <=sayfa1.getLastRowNum() ; i++) {

            String satirdakiUlkeIsmi = sayfa1.getRow(i).getCell(0).toString();
            String ulkeninBaskentIsmi = sayfa1.getRow(i).getCell(1).toString();

            if (satirdakiUlkeIsmi.equalsIgnoreCase("Samoa")){
                Assert.assertEquals("Apia",ulkeninBaskentIsmi);
            }

        }

        // bu iki testi map kullanarak yapalım
        // bunun için once ingilizce ulke isimleri ve baskentleri bir map yapalim

        Map<String , String > ulkelerVeBaskentleri = new TreeMap<>();

        for (int i = 0; i <=sayfa1.getLastRowNum() ; i++) {

            String satirdakiUlkeIsmi = sayfa1.getRow(i).getCell(0).toString();
            String ulkeninBaskentIsmi = sayfa1.getRow(i).getCell(1).toString();

            ulkelerVeBaskentleri.put(satirdakiUlkeIsmi,ulkeninBaskentIsmi);

        }

        Assert.assertTrue(ulkelerVeBaskentleri.containsKey("Poland"));

        Assert.assertEquals("Apia", ulkelerVeBaskentleri.get("Samoa"));

    }
}
