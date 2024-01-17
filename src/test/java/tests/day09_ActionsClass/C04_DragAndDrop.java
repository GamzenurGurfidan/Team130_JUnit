package tests.day09_ActionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilitie.ReusableMethods;
import utilitie.TestBase;

public class C04_DragAndDrop extends TestBase {
    @Test
    public void test01(){

        // 1- https://testotomasyonu.com/droppable adresine gidelim
        // 2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        // 3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        // 4- Sayfayi yenileyin
        // 5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        // 6- “Drop Here” yazisinin degismedigini test edin

        driver.get("https://testotomasyonu.com/droppable");

        Actions actions = new Actions(driver);

        WebElement acceptableButonElementi = driver.findElement(By.id("draggable2"));

        WebElement dropHereElementi = driver.findElement(By.id("droppable2"));

        ReusableMethods.bekle(1);

        actions.dragAndDrop(acceptableButonElementi,dropHereElementi).perform();

        String expectedYazi = "Dropped!";
        String actualYazi = dropHereElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

        ReusableMethods.bekle(1);

        driver.navigate().refresh();

        dropHereElementi = driver.findElement(By.id("droppable2"));
        WebElement notAccepteableElementi = driver.findElement(By.id("draggable-nonvalid2"));

        ReusableMethods.bekle(1);

        actions.dragAndDrop(notAccepteableElementi,dropHereElementi).perform();

        expectedYazi = "Drop Here";
        actualYazi = dropHereElementi.getText();

        ReusableMethods.bekle(1);

        Assert.assertEquals(expectedYazi,actualYazi);


    }
}
