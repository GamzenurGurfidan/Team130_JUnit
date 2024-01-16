package tests.day08_iFrame_switchingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilitie.TestBase;

import java.util.List;
import java.util.Set;

public class C04_KontrolsuzAcilanWindowaGecis extends TestBase {

    @Test
    public void test01(){

        // ● https://testotomasyonu.com/addremove/ adresine gidin.
        // ● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        // ● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
        // ● ‘Please click for Electronics Products’ linkine tiklayin.
        // ● Electronics sayfasinin acildigini test edin
        // ● Bulunan urun sayisinin 16 olduğunu test edin
        // ● Ilk actiginiz addremove sayfasina donun
        // ● Url’in addremove icerdigini test edin

        driver.get("https://testotomasyonu.com/addremove/");

        WebElement addRemoveElementi = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));

        String expectedYazi = "Add/Remove Elements";
        String actualYazi = addRemoveElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedYazi,actualYazi);

        String ilkWindowWHD = driver.getWindowHandle();

        driver.findElement(By.xpath("//*[text()='Electronics Products']")).click();


        Set<String> whDegerleriSeti = driver.getWindowHandles();

        String ikinciWindowWHD = "";
        for (String eachWHD: whDegerleriSeti){
            if (!eachWHD.equals(ilkWindowWHD)){
                ikinciWindowWHD = eachWHD;
            }
        }

        driver.switchTo().window(ikinciWindowWHD);

        expectedTitle = "Electronics";
        actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));

        List<WebElement> urunElementleriText = driver.findElements(By.xpath("//*[@class='product-box mb-2 pb-1']"));

        int expectedUrunSayisi = 16;
        int actualUrunSayisi = urunElementleriText.size();

        Assert.assertEquals(expectedUrunSayisi,actualUrunSayisi);

        driver.switchTo().window(ilkWindowWHD);

        String expectedURLIcerik = "addremove";
        String actualURLIcerik = driver.getCurrentUrl();

        Assert.assertTrue(actualURLIcerik.contains(expectedURLIcerik));


    }
}
