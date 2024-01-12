package tests.day06_Assertion;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C05_DrpodownMenu extends TestBase {

    // ● https://testotomasyonu.com/form adresine gidin.
    //	1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
    //	2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
    //	3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
    //	4. Secilen değerleri konsolda yazdirin
    //	5. Ay dropdown menüdeki tum değerleri(value) yazdırın
    //	6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin

    @Test
    public void dropdownTesti() throws InterruptedException {

        driver.get("https://testotomasyonu.com/form");

        WebElement gunDdmElementi =
                driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));

        Select selectGun = new Select(gunDdmElementi);

        selectGun.selectByIndex(5);


        WebElement ayDdmElemetti =
                driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));

        Select selectAy = new Select(ayDdmElemetti);

        selectAy.selectByValue("nisan");

        WebElement yilDdmElementi =
                driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));

        Select selectYil = new Select(yilDdmElementi);

        selectYil.selectByVisibleText("1990");

        System.out.println(selectGun.getFirstSelectedOption().getText() + "\n" +
                           selectAy.getFirstSelectedOption().getText() + "\n" +
                           selectYil.getFirstSelectedOption().getText());

        System.out.println(ayDdmElemetti.getText());

        Assert.assertEquals(selectAy.getOptions().size(),13);


        Thread.sleep(1000);
    }

}
