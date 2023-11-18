import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class FacebookSignup {
    public static void main(String args[]) {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();
        driver.get("https://www.facebook.com//");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        WebElement NewAccount = driver.findElement(By.xpath("//a[text()='Create new account']"));
        NewAccount.click();

        WebElement FirstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        FirstName.sendKeys("Rahul");

        WebElement LastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        LastName.sendKeys("Roy");

        WebElement Email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        Email.sendKeys("abc@xyz.com");

        WebElement ReEmail = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        ReEmail.sendKeys("abc@xyz.com");

        WebElement Password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        Password.sendKeys("Abc@12345");

        WebElement Day = driver.findElement(By.id("day"));
        Select dday = new Select(Day);
        dday.selectByValue("13");

        WebElement Month = driver.findElement(By.id("month"));
        Select mmonth = new Select(Month);
        mmonth.selectByVisibleText("Dec");


        WebElement Year = driver.findElement(By.id("year"));
        Select yyear = new Select(Year);
        yyear.selectByValue("1995");

        WebElement Gender = driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
        Gender.click();

        List<WebElement> allMonths = driver.findElements(By.xpath("//select[@id='month']/option"));
        for(WebElement month : allMonths)
        {
            System.out.println("Month is :" +month.getText());
        }

        List<WebElement> allYears = driver.findElements(By.xpath("//select[@id='year']/option"));
        for(WebElement year : allYears)
        {
            System.out.println("Year is :" +year.getText());
        }
        driver.close();

        // print value of pop over present for DOb and gender
    }
    }
