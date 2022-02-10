package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.openqa.selenium.Keys.ENTER;

public class weatherShopperLandingPage {
    private WebDriver driver;

    public weatherShopperLandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public lotionPage searching() throws IOException, InterruptedException {
        System.out.println("started");
        String tempText = driver.findElement(By.xpath("//*[@id='temperature']")).getText();
        WebElement buyMoisturizers = driver.findElement(By.xpath("//button[contains(.,'moisturizers')]"));
        WebElement buySunscreen = driver.findElement(By.xpath("//button[contains(.,'sunscreens')]"));
        Pattern intsOnly = Pattern.compile("\\d+");
        Matcher makeMatch = intsOnly.matcher(tempText);
        makeMatch.find();
        int tempInt = Integer.parseInt(makeMatch.group());
        //Integer.parseInt(tempInt);
        System.out.println("the current temperature is "+ tempInt);

        if (tempInt < 19) {
            buyMoisturizers.click();
            return new lotionPage(driver,tempInt);
        } else if (tempInt > 34) {
            buySunscreen.click();
            return new lotionPage(driver,tempInt);
        }
        else
        {
            System.out.println("The temperature was outside the specified range ");
            driver.close();
            return null;
        }
    }
}

