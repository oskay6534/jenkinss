package test1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test1 {
    @Test
    public void gogle() {
        // WebDriverManager ile driver kurulumu
        WebDriverManager.chromedriver().setup();

        // Jenkins için gerekli ayarlar (Headless Mod)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Tarayıcı penceresini açmadan çalıştırır
        options.addArguments("--no-sandbox"); // Linux sunucularda güvenlik engeline takılmamak için
        options.addArguments("--disable-dev-shm-usage"); // Bellek sorunlarını önlemek için
        options.addArguments("--remote-allow-origins=*"); // Bağlantı sorunlarını aşmak için

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://www.google.com");
            System.out.println("Sayfa başlığı: " + driver.getTitle());
        } finally {
            // Test bittiğinde tarayıcıyı mutlaka kapatmalısın
            // Kapatmazsan Jenkins'te arka planda yüzlerce boş Chrome süreci birikir!
            driver.quit();
        }
    }
}