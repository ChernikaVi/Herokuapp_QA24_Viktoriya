
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropDown {
    private static final String URL = "http://the-internet.herokuapp.com/dropdown";
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
    public void DropDown() {
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByValue("1");
        String text = select.getFirstSelectedOption().getText();
        Assert.assertEquals(text, "Option 1");


        select.selectByValue("2");
        String text1 = select.getFirstSelectedOption().getText();
        Assert.assertEquals(text1, "Option 2");

    }
}
