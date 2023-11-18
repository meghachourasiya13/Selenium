import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.TimeUnit;

public class DragNDropExample {
    public static void main(String args[]) {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/droppable/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        WebElement from = driver.findElement(By.id("draggable"));

        WebElement to = driver.findElement(By.id("droppable"));

        Actions obj = new Actions(driver);
        obj.dragAndDrop(from,to).perform();

        WebElement msg = driver.findElement(By.xpath("//div[@id = 'droppable']/p"));
        System.out.println(msg.getText());

        driver.close();

               }
}
