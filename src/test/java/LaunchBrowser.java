import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LaunchBrowser {
    public static void main(String args[])
    {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();
        driver.get("https://www.simplilearn.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        WebElement userName = driver .findElement(By.name("user_login"));
        userName.sendKeys("megha.chourasiya@rakuten.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Megh@Learn1234567");

        WebElement rememberMe = driver.findElement(By.id("remember-me"));
        rememberMe.click();

        WebElement loginButton = driver.findElement(By.name("btn_login"));
        loginButton.click();

        WebElement errormsg = driver.findElement(By.className("error_msg"));
        System.out.println("the error message is " +errormsg.getText());

        List<WebElement> links =  driver.findElements(By.tagName("a"));
        System.out.println("total number of links are " +links.size());

    }
}
