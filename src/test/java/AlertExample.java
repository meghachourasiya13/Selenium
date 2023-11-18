import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AlertExample {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        WebElement AlertBtn = driver.findElement(By.id("alertButton"));
        AlertBtn.click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Thread.sleep(2000);
        alert.accept();

        WebElement AlertBtn1 = driver.findElement(By.id("confirmButton"));
        AlertBtn1.click();
        alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Thread.sleep(2000);
        alert.dismiss();
    }
}
