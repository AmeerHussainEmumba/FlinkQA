package Tests;

import Pages.checkout;
import Pages.confirmationPage;
import Pages.productChoicePage;
import baseTest.BaseTest;
import org.testng.annotations.Test;


import java.io.IOException;

public class assignmentTest extends BaseTest {
@Test
    public void search() throws IOException, InterruptedException {
    productChoicePage lotionOrSunscreen = Homepage.searching();
    checkout check= lotionOrSunscreen.makePurchase();
    confirmationPage confirm =check.completePurchase();
    confirm.getConfirmation();

}
}

