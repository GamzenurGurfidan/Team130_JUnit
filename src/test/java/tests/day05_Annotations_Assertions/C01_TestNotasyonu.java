package tests.day05_Annotations_Assertions;

import org.junit.Ignore;
import org.junit.Test;

public class C01_TestNotasyonu {
    /*
    test notasyonu siradan bir methodu
    bagımsız olarak calıstırılabilen bir test methoduna donusturur

    bir classta birden fazla test methodu varsa
    istersek her bir methodu tek başina,
    istersek de class leveldan calistirip toplu olarak calistirabiliriz

    JUnit test methodlari toplu calıstırıldıgında
    hangi siralama ile calisacagini BİLEMEYİZ ve KONTROL EDEMEYİZ

    eger calismasini istemediginiz bir test methodu varsa
    @Ignore notasyonu kullanabiliriz
     */
    @Test
    public void testOtomasyonuTest(){
        System.out.println("Test otomasyonu testi çalıştı");

    }
    @Test @Ignore
    public void wisequarterTest(){
        System.out.println("Wise Quarter testi çalıştı");

    }
    @Test
    public void youtubeTest (){
        System.out.println("Youtube testi çalıştı");

    }
}
