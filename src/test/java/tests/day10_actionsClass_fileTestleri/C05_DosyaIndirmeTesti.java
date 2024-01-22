package tests.day10_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilitie.ReusableMethods;
import utilitie.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_DosyaIndirmeTesti extends TestBase {

    @Test
    public void dosyaIndirmeTesti(){

        //1. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");


        //2. logo.jpg dosyasını indirelim

        driver.findElement(By.xpath("//*[text()='foto.png']"))
                     .click();

        ReusableMethods.bekle(3);

        //3. Dosyanın başarıyla indirilip indirilmediğini test edelim

        // kodunuzun herkesin bilgisayarında çalışabilmesi için
        // dosya yolunu dinamik yapmak isteriz
        // internette tıkladıgımız dosya dowloads klosörüne indirilir

        String dinamikDosyaYolu = System.getProperty("user.home") + "\\Downloads\\foto.png";

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));




        // C:\Users\Gamzenur\Downloads

        System.out.println(System.getProperty("user.home")); // C:\Users\Gamzenur
    }

}
