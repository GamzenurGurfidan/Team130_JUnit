package tests.day08_iFrame_switchingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilitie.ReusableMethods;
import utilitie.TestBase;

import java.util.Set;

public class C03_KontrolsuzAcilanWindowaGecis extends TestBase {

    @Test
    public void kontrolsuzWindowaGecis (){
        // 1- https://testotomasyonu.com/discount adresine gidin
        // 2- Elektronics Products yazisinin gorunur olduğunu test edin
        // 3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        // 4- Dell bilgisayar’a tiklayip acilan sayfada urun fiyatinin $399.00 olduğunu test edin.
        // 5- Ilk sayfaya donun ve Fashion yazisinin gorunur olduğunu test edin
        // 6- Sayfayi kapatin

        driver.get("https://testotomasyonu.com/discount");

        // yazi iframe icinde oldugundan once o iframei locate edip oraya gecelim

        WebElement iFrameElementi = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iFrameElementi);

        WebElement electronicsYaziElementi = driver.findElement(By.xpath("//*[text()='Electronics Products']"));

        Assert.assertTrue(electronicsYaziElementi.isDisplayed());

        WebElement dellElementi = driver.findElement(By.id("dell-core"));

        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = dellElementi.getText();

        Assert.assertEquals(expectedUrunIsmi,actualUrunIsmi);

        dellElementi.click();

        // click yapildiginda kontrolsuz olarak yeni bir tab acıldıgından
        // river yeni taba gecmez eski windowda kalir
        // bu durumda ikinci sayfanın window handle degerini bulabilmek için
        // 3 adıma ihtiyacımız var

        // 1. adim : ilk windowun WHD'ini kaydedelim

        String ilkWindowHandleDegeri = driver.getWindowHandle();

        // 2. adim: click yapildiktan sonra WHDini kaydettigimiz ilk windowun yanına
        //          yeni bir tap acıldı
        //          getWindowHandles() kullanarak acik olan iki windowun
        //          WHDlerini bir Set olarak kaydedlim

        Set<String> whDegerleriSeti = driver.getWindowHandles();

        // 3. adim: whDegerleriSeti ve ilkWindowWHD kullanarak
        //          ikinci windowun WHDini bulup kaydedin

        String ikinciWindowWHD = "";
        for (String eachWHD: whDegerleriSeti){
            if (!eachWHD.equals(ilkWindowHandleDegeri)){
                ikinciWindowWHD = eachWHD;
            }
        }

        // artik yeni windowa switch yapılabilir

        driver.switchTo().window(ikinciWindowWHD);

        WebElement priceProduct = driver.findElement(By.id("priceproduct"));

        String expectedFiyat = "$399.00";
        String actualFiyat = priceProduct.getText();

        Assert.assertEquals(expectedFiyat,actualFiyat);

        driver.switchTo().window(ilkWindowHandleDegeri);

        WebElement fashionFrame = driver.findElement(By.xpath("(//iframe[@frameborder='1'])[2]"));
        driver.switchTo().frame(fashionFrame);

        WebElement fashion = driver.findElement(By.xpath("//*[text()='Fashion']"));

        Assert.assertTrue(fashion.isDisplayed());

        driver.switchTo().defaultContent();

        WebElement hereAreSomeElementi = driver.findElement(By.xpath("//*[text()='Here are some products.']"));

        Assert.assertTrue(hereAreSomeElementi.isDisplayed());

        ReusableMethods.bekle(3);

    }
}
