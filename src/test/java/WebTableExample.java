import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTableExample {
    public static void main(String args[]) {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='ws-table-all']/tbody/tr"));
        System.out.println("number of rows : " +rows.size());


        List<WebElement> columns = driver.findElements(By.xpath("//table[@class='ws-table-all']/tbody/tr/th"));
        System.out.println("number of columns : " +columns.size());
        String CompanyName = "Island Trading";

        for(int i=2; i <rows.size(); i++)
        {
          WebElement company = driver.findElement(By.xpath("//table[@class='ws-table-all']/tbody/tr[" +i+ "]/td[1]"));

          if(company.getText().equals("Island Trading"))
          {
              WebElement contact = driver.findElement(By.xpath("//table[@class='ws-table-all']/tbody/tr[" +i+ "]/td[2]"));
              WebElement country = driver.findElement(By.xpath("//table[@class='ws-table-all']/tbody/tr[" +i+ "]/td[3]"));

              System.out.println("contact is : " +contact.getText());
              System.out.println("country is : " +country.getText());
          }
        }

        WebElement Contact1 = driver.findElement(By.xpath("//td[text()='" + CompanyName + "']/following-sibling::td[1]"));
        WebElement Country1 = driver.findElement(By.xpath("//td[text()='" + CompanyName + "']/following-sibling::td[2]"));
        System.out.println(Contact1.getText());
        System.out.println(Country1.getText());

        driver.close();
    }
}
