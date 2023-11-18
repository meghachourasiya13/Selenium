import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowsExample {

    public static void main(String args[]) {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        String paretWindow = driver.getWindowHandle();
        System.out.println("parent window is : " +paretWindow);

        WebElement tabBtn = driver.findElement(By.id("tabButton"));
        tabBtn.click();

        //set won't have duplicate values
        Set<String> allWindow = driver.getWindowHandles();
        String childWindow = "";
        for(String window : allWindow) {
            System.out.println("all window : " + window);
            if(!window.equals(paretWindow))
                childWindow = window;
        }

        driver.switchTo().window(childWindow);
                WebElement header = driver.findElement(By.tagName("h1"));
        System.out.println("header is: " +header.getText());
        driver.close();
        driver.switchTo().window(paretWindow);

        WebElement windowBtn = driver.findElement(By.id("windowButton"));
        windowBtn.click();
        Set<String> allWindow1 = driver.getWindowHandles();
        String childWindow1 = "";
        for(String window : allWindow1) {
            System.out.println("all window : " + window);
            if(!window.equals(paretWindow))
                childWindow1 = window;
        }

        driver.switchTo().window(childWindow1);
        WebElement header2 = driver.findElement(By.tagName("h1"));
        System.out.println("Window header is: " +header2.getText());

        driver.switchTo().window(paretWindow);
        //quit() will close all window
        driver.quit();

    }
}
