package baseTest;

import Pages.weatherShopperLandingPage;
import com.google.common.collect.Lists;
import com.google.common.io.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BaseTest {
    protected weatherShopperLandingPage Homepage;
    private ChromeDriver driver;


    @BeforeClass
    public void setUp() throws IOException {
        System.out.println("we have liftoff");
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://weathershopper.pythonanywhere.com/");
        Homepage = new weatherShopperLandingPage(driver);
    }

    /*@AfterClass
    public void endNow() {}*/

    @AfterMethod

    public void endNow() {
        List<String> newBrowserTabs = Lists.newArrayList(driver.getWindowHandles());
        /*driver.switchTo().window(newBrowserTabs.get(2));
        driver.close();
        driver.switchTo().window(newBrowserTabs.get(1));
        driver.close();
        driver.switchTo().window(newBrowserTabs.get(0));*/
        //driver.close();
    }
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
