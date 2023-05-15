
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AddRemoveElements {
    private static final String URL = "http://the-internet.herokuapp.com/add_remove_elements/";
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.get(URL);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void AddRemoveTest() {
        WebElement addElement = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addElement.click();
        addElement.click();

        List<WebElement> deleteElement = driver.findElements(By.xpath("//*[text()='Delete']"));
        Assert.assertEquals(deleteElement.size(), 2);
        deleteElement.get(0).click();

        deleteElement = driver.findElements(By.xpath("//*[text()='Delete']"));
        Assert.assertEquals(deleteElement.size(), 1);
    }
}
