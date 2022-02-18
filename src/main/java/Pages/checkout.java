package Pages;

import com.google.common.collect.Lists;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class checkout {
    private WebDriver driver;
    private String name1;
    private int priceOfSelection1;
    private String name2;
    private int priceOfSelection2;
    public checkout(WebDriver driver, String name1, int priceOfSelection1, String name2, int priceOfSelection2) {
        this.driver=driver;
        this.name1=name1;
        this.priceOfSelection1=priceOfSelection1;
        this.name2=name2;
        this.priceOfSelection2=priceOfSelection2;
    }

   public confirmationPage completePurchase () throws InterruptedException {
       String DisplayedName1=driver.findElement(By.xpath("//html/body/div[1]/div[2]/table/tbody/tr[1]/td[1]")).getText();
       String DisplayedName2=driver.findElement(By.xpath("//html/body/div[1]/div[2]/table/tbody/tr[2]/td[1]")).getText();
       WebElement button=driver.findElement(By.xpath("//button"));
       List<String> browserWindows = Lists.newArrayList(driver.getWindowHandles());
       int price1= Integer.parseInt(driver.findElement(By.xpath("//html/body/div[1]/div[2]/table/tbody/tr[1]/td[2]")).getText());
       int price2= Integer.parseInt(driver.findElement(By.xpath("//html/body/div[1]/div[2]/table/tbody/tr[2]/td[2]")).getText());
       Pattern intsOnly = Pattern.compile("\\d+");
       Matcher makeMatch = intsOnly.matcher(driver.findElement(By.xpath("//*[@id='total']")).getText());
       makeMatch.find();
       int totalPrice= Integer.parseInt(makeMatch.group());
       String card_number="4242424242424242";
       String expiryDate="02/24";
       JavascriptExecutor js= (JavascriptExecutor) driver;
       Assert.assertEquals(name1,DisplayedName1);
       Assert.assertEquals(name2,DisplayedName2);
       Assert.assertEquals(price1,priceOfSelection1);
       Assert.assertEquals(price2,priceOfSelection2);
       Assert.assertEquals(totalPrice,price1 + price2);
       {
           button.click();
           Thread.sleep(4000);
           driver.switchTo().frame("stripe_checkout_app");
           WebElement email = driver.findElement(By.xpath("//*[@id='email']"));
           email.sendKeys("a@a.com");
           WebElement cardNumber =driver.findElement(By.xpath("//*[@id='card_number']"));
           js.executeScript("arguments[1].value = arguments[0]; ", card_number, cardNumber);
           WebElement cardExpiry =driver.findElement(By.xpath("//*[@id='cc-exp']"));
           js.executeScript("arguments[1].value = arguments[0]; ", expiryDate, cardExpiry);
           WebElement CVC =driver.findElement(By.xpath("//*[@id='cc-csc']"));
           CVC.sendKeys("242");
           WebDriverWait wait = new WebDriverWait(driver,20);
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='billing-zip']")));
           WebElement zipCode= driver.findElement(By.xpath("//*[@id='billing-zip']"));
           zipCode.sendKeys("242");
           WebElement paymentButton = driver.findElement(By.xpath("//button[contains(.,'Pay INR')]"));
           paymentButton.click();
           driver.switchTo().parentFrame();
           Thread.sleep(5000);
           return new confirmationPage(driver);
       }
   }
}
