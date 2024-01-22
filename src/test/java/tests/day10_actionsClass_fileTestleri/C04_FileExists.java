package tests.day10_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExists {
    @Test
    public void test01(){

        // projemiz altinda deneme.txt dosyasınin varoldugunu test edin

        String dosyaYolu = "src/test/java/tests/day10_actionsClass_fileTestleri/deneme.txt";

        System.out.println(Files.exists(Paths.get(dosyaYolu)));  // true

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // C:\Users\Gamzenur\IdeaProjects\Team130_JUnit\src\test\java\tests\day10_actionsClass_fileTestleri\deneme.txt

        System.out.println(System.getProperty("user.dir"));
        // C:\Users\Gamzenur\IdeaProjects\Team130_JUnit

        // Asolute dosya yolunuzu dinamik yapmak isterseniz

        String absoluteDosyaYolu = System.getProperty("user.dir") + "/src/test/java/tests/day10_actionsClass_fileTestleri/deneme.txt";

        Assert.assertTrue(Files.exists(Paths.get(absoluteDosyaYolu)));

    }
}
