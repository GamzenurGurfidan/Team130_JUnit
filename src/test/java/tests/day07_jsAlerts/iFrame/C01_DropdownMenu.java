package tests.day07_jsAlerts.iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilitie.ReusableMethods;
import utilitie.TestBase;

public class C01_DropdownMenu extends TestBase {

    @Test
    public void zeroAppTesti(){

        // 1. http://zero.webappsecurity.com/ Adresine gidin
        // 2. Sign in butonuna basin
        // 3. Login kutusuna “username” yazin
        // 4. Password kutusuna “password” yazin
        // 5. Sign in tusuna basin, back tusuna basarak sayfaya donun
        // 6. Online banking menusunden Pay Bills sayfasina gidin
        // 7. “Purchase Foreign Currency” tusuna basin
        // 8. “Currency” drop down menusunden Eurozone’u secin
        // 9. “amount” kutusuna bir sayi girin
        // 10. “US Dollars” in secilmedigini test edin
        // 11. “Selected currency” butonunu secin
        // 12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        // 13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.

        driver.get("http://zero.webappsecurity.com/");

        driver.findElement(By.id("signin_button")).click();

        driver.findElement(By.id("user_login")).sendKeys("username");

        driver.findElement(By.id("user_password")).sendKeys("password");

        driver.findElement(By.xpath("//*[@*='Sign in']")).click();

        driver.navigate().back();

        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();

        driver.findElement(By.id("pay_bills_link")).click();

        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

        WebElement currencyDropDownMenu = driver.findElement(By.id("pc_currency"));
        Select select = new Select(currencyDropDownMenu);
        select.selectByValue("EUR");

        driver.findElement(By.id("pc_amount")).sendKeys("200");

        WebElement usDollarsRadioButton = driver.findElement(By.id("pc_inDollars_true"));

        Assert.assertFalse(usDollarsRadioButton.isSelected());

        driver.findElement(By.id("pc_inDollars_false")).click();

        driver.findElement(By.id("pc_calculate_costs")).click();

        driver.findElement(By.id("purchase_cash")).click();

        WebElement yaziElementi = driver.findElement(By.id("alert_content"));

        String expectedYazi = "Foreign currency cash was successfully purchased.";
        String actualYazi = yaziElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

        ReusableMethods.bekle(3);

    }

}
