import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class frames {
    private static final String URL = "http://the-internet.herokuapp.com/iframe";
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(URL);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void framesTest() {
        driver.switchTo().frame("mce_0_ifr");
        WebElement frame = driver.findElement(By.id("tinymce"));
        String frameText = frame.getText();
        Assert.assertEquals(frameText, "Your content goes here.");
        driver.switchTo().defaultContent();
    }
}
