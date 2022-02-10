package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lotionPage {
    private WebDriver driver;
    private int decisionTemp;

    public lotionPage(WebDriver driver, int temperature) {
        this.driver = driver;
        decisionTemp = temperature;
    }

    public void makePurchase() {
        List<WebElement> Elements = new ArrayList<>();
        ArrayList<Integer> selectedElements = new ArrayList<>();
        List<WebElement> elementPrices = new ArrayList<>();
        List<Integer> selectedElementPrices = new ArrayList<>();
        List<Integer> sortedList=new ArrayList<>();
        int selection1 = 99;
        if (decisionTemp < 19) {
            Elements = driver.findElements(By.xpath("//html/body//p[1][not(contains(.,'Services'))]"));
            for (int position = 0; position <= Elements.size() - 1; position++) {
                if (Elements.get(position).getText().contains("Aloe") || Elements.get(position).getText().contains("aloe")) {
                    selectedElements.add(position);
                } else {}
            }
            elementPrices = driver.findElements(By.xpath("//html/body//p[2]"));
            for (int counter = 0; counter <= selectedElements.size() - 1; counter++) {
                Pattern intsOnly = Pattern.compile("\\d+");
                Matcher makeMatch = intsOnly.matcher(elementPrices.get(selectedElements.get(counter)).getText());
                makeMatch.find();
                selectedElementPrices.add(Integer.parseInt(makeMatch.group()));
            }
           int temp=selectedElementPrices.indexOf((Collections.min(selectedElementPrices)));
            selection1= selectedElements.get(temp);

        } else { //sunscreen
            Elements = driver.findElements(By.xpath("//html/body//p[1][not(contains(.,'Services'))]"));

            for (int counter = 0; counter <= Elements.size() - 1; counter++) {
                if (Elements.get(counter).getText().contains("spf-30") || Elements.get(counter).getText().contains("SPF-30")) {
                    selectedElements.add(counter);
                } else {}
            }
            elementPrices = driver.findElements(By.xpath("//html/body//p[2]"));
            for (int counter = 0; counter <= selectedElements.size() - 1; counter++) {
                Pattern intsOnly = Pattern.compile("\\d+");
                Matcher makeMatch = intsOnly.matcher(elementPrices.get(selectedElements.get(counter)).getText());
                makeMatch.find();
                selectedElementPrices.add(Integer.parseInt(makeMatch.group()));
            }
            int temp=selectedElementPrices.indexOf((Collections.min(selectedElementPrices)));
            selection1= selectedElements.get(temp);
        }
        //Collections.min(selectedElementPrices);
            System.out.println("number of selected element " + selectedElements.size());
            System.out.println("number of selected elements according to prices " + selectedElementPrices.size());
            for (int a = 0; a <= selectedElements.size() - 1; a++) {
                System.out.println(selectedElements.get(a));
            }
            for (int a = 0; a <= selectedElementPrices.size() - 1; a++) {
                System.out.println(selectedElementPrices.get(a));
            }
            for (int a = 0; a <= sortedList.size() - 1; a++) {
            System.out.println(sortedList.get(a));
        }
            System.out.println(Collections.min(selectedElementPrices));
            System.out.println(selection1);
            System.out.println("done");
        }
    }
