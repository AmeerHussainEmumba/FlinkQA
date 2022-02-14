package Tests;

import Pages.checkout;
import Pages.lotionPage;
import Pages.weatherShopperLandingPage;
import baseTest.BaseTest;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.Test;


import java.io.IOException;

public class assignmentTest extends BaseTest {
@Test
    public void search() throws IOException, InterruptedException {
    lotionPage lontionpage = Homepage.searching();
    checkout check= lontionpage.makePurchase();
    check.completePurchase();

}
}
