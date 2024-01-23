package tests.day12_WebTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilitie.ReusableMethods;
import utilitie.TestBase;

import java.util.List;

public class C01_KlasikHtmlKodlariylaWebTables extends TestBase {
    @Test
    public void test01() {
        // 1.“https://testotomasyonu.com/webtables” adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        // 2.Web table tum body’sini yazdirin
        WebElement tumBodyElementi = driver.findElement(By.tagName("tbody"));
        System.out.println(tumBodyElementi.getText());

        // 3. Web tablosunda “Comfortable Gaming Chair” bulundugunu test edin
        String expectedTabloIcerik = "Comfortable Gaming Chair";
        String actualTumBody = tumBodyElementi.getText();
        Assert.assertTrue(actualTumBody.contains(expectedTabloIcerik));

        // 4. Web table bodysin’deki satir sayisinin 5 oldugunu test edin
        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody/tr"));

        int expectedSatirSayisi = 5;
        int actualSatirSayisi = satirlarListesi.size();

        Assert.assertEquals(expectedSatirSayisi, actualSatirSayisi);

        // 5. Tum satirlari yazdirin
        List<String> satirYazilariList = ReusableMethods.strListeCevir(satirlarListesi);
        System.out.println("-----------------Satırlar Listesi-----------------");
        System.out.println(satirYazilariList);

        // 6. Web table’daki sutun sayisinin 4 olduğunu test edin
        List<WebElement> ucuncuSatirDatalarList = driver.findElements(By.xpath("//tbody/tr[3]/td"));

        int expectedSutunSayisi = 4;
        int actualSutunSayisi = ucuncuSatirDatalarList.size();

        Assert.assertEquals(expectedSutunSayisi, actualSutunSayisi);

        // 7. 3.sutunu yazdirin
        List<WebElement> ucuncuSutunElementleri = driver.findElements(By.xpath("//tbody/tr/td[3]"));

        System.out.println("\n" + ReusableMethods.strListeCevir(ucuncuSutunElementleri));

        // 8. Tablodaki basliklari yazdirin
        WebElement baslikElementi = driver.findElement(By.tagName("thead"));
        System.out.println("Basliklar: " + baslikElementi.getText());

        // 9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
        System.out.println(dataDondur(2, 3)); // $40.00
        System.out.println(dataDondur(4, 2)); // Furniture

        // 10. 4.satirdaki category degerinin “Furniture” oldugunu test edin

        String expectedData = "Furniture";
        String actualData = dataDondur(4,2);

        Assert.assertEquals(expectedData,actualData);

    }
    public String dataDondur (int satirNo, int sutunNo){

        // //tbody/tr[    4    ]/td[    1    ]

        String dinamikXpath =  "//tbody/tr[" + satirNo + "]/td[" + sutunNo + "]";

        WebElement istenenHucreElementi = driver.findElement(By.xpath(dinamikXpath));

        return istenenHucreElementi.getText();
    }
}
