package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class confirmationPage {
    private WebDriver driver;
    public confirmationPage(WebDriver driver) {
        this.driver=driver;
    }

    public void getConfirmation()
    {
        WebElement secondHeading= driver.findElement(By.xpath("//h2"));
        Assert.assertEquals(secondHeading.getText(),"PAYMENT SUCCESS");
        System.out.println("and done");
    }
}
