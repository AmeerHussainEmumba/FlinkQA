package cucumber;

import Pages.checkout;
import Pages.confirmationPage;
import Pages.productChoicePage;
import Pages.weatherShopperLandingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class productChoosingSteps {
    WebDriver driver;
    weatherShopperLandingPage Homepage;
    productChoicePage lotionOrSunscreen;
    checkout check;
    confirmationPage confirm;

    @Given("I navigate to the weatherShopperLandingPage")
    public void I_navigate_to_the_weatherShopperLandingPage() throws IOException, InterruptedException {  System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://weathershopper.pythonanywhere.com/");
        Homepage = new weatherShopperLandingPage(driver);
        lotionOrSunscreen = Homepage.searching();
        //checkout check= lotionOrSunscreen.makePurchase();
        //    confirmationPage confirm =check.completePurchase();
        //    confirm.getConfirmation();
    }

    @And("I make a selection of which product i want to buy")
    public void iMakeASelectionOfWhichProductIWantToBuy() {
        check= lotionOrSunscreen.makePurchase();
    }

    @And("I purchase two items of the product")
    public void iPurchaseTwoItemsOfTheProduct() throws InterruptedException {
        confirm =check.completePurchase();
    }

    @Then("I must be able to check if the transaction is complete")
    public void iMustBeAbleToCheckIfTheTransactionIsComplete() {
        confirm.getConfirmation();
        driver.close();
    }
}
