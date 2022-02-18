package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.annotation.ElementType;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class productChoicePage {
    private WebDriver driver;
    private int decisionTemp;

    public productChoicePage(WebDriver driver, int temperature) {
        this.driver = driver;
        decisionTemp = temperature;
    }

    public checkout makePurchase() {
        List<WebElement> Elements = new ArrayList<>();
        ArrayList<Integer> selectedElements = new ArrayList<>();
        List<WebElement> elementPrices = new ArrayList<>();
        List<WebElement> buttons = new ArrayList<>();
        buttons= driver.findElements(By.xpath("//button[contains(.,'Add')]"));
        List<Integer> selectedElementPrices = new ArrayList<>();
        List<Integer> sortedList=new ArrayList<>();
        int selection1 = 99;
        int selection2 = 98;
        int priceOfSelection1;
        int priceOfSelection2;
        String Name1="null";
        String Name2="null";
        if (decisionTemp < 19) {
            Elements = driver.findElements(By.xpath("//html/body//p[1][not(contains(.,'Services'))]"));
            for (int position = 0; position <= Elements.size() - 1; position++) {
                if (Elements.get(position).getText().contains("Aloe") || Elements.get(position).getText().contains("aloe")) {
                    selectedElements.add(position);
                }
            }
            elementPrices = driver.findElements(By.xpath("//html/body//p[2]"));
            for (int counter = 0; counter <= selectedElements.size() - 1; counter++) {
                Pattern intsOnly = Pattern.compile("\\d+");
                Matcher makeMatch = intsOnly.matcher(elementPrices.get(selectedElements.get(counter)).getText());
                makeMatch.find();
                selectedElementPrices.add(Integer.parseInt(makeMatch.group()));
            }
            int temp1=selectedElementPrices.indexOf((Collections.min(selectedElementPrices)));
            priceOfSelection1=Collections.min(selectedElementPrices);
            selection1= selectedElements.get(temp1);
            Name1=Elements.get(selection1).getText();
            buttons.get(selection1).click();
            selectedElements.clear();
            selectedElementPrices.clear();

            //SecondChoice

            for (int position = 0; position <= Elements.size() - 1; position++) {
                if (Elements.get(position).getText().contains("Almond") || Elements.get(position).getText().contains("almond")) {
                    selectedElements.add(position);
                }
            }
            elementPrices = driver.findElements(By.xpath("//html/body//p[2]"));
            for (int counter = 0; counter <= selectedElements.size() - 1; counter++) {
                Pattern intsOnly = Pattern.compile("\\d+");
                Matcher makeMatch = intsOnly.matcher(elementPrices.get(selectedElements.get(counter)).getText());
                makeMatch.find();
                selectedElementPrices.add(Integer.parseInt(makeMatch.group()));
            }
            int temp2=selectedElementPrices.indexOf((Collections.min(selectedElementPrices)));
            priceOfSelection2=Collections.min(selectedElementPrices);
            selection2= selectedElements.get(temp2);
            Name2=Elements.get(selection2).getText();
            buttons.get(selection2).click();
        } else { //sunscreen
            Elements = driver.findElements(By.xpath("//html/body//p[1][not(contains(.,'Services'))]"));
            elementPrices = driver.findElements(By.xpath("//html/body//p[2]"));

            for (int counter = 0; counter <= Elements.size() - 1; counter++) {
                if (Elements.get(counter).getText().contains("spf-30") || Elements.get(counter).getText().contains("SPF-30")) {
                    selectedElements.add(counter);
                }
            }
            for (int counter = 0; counter <= selectedElements.size() - 1; counter++) {
                Pattern intsOnly = Pattern.compile("\\d+");
                Matcher makeMatch = intsOnly.matcher(elementPrices.get(selectedElements.get(counter)).getText());
                makeMatch.find();
                selectedElementPrices.add(Integer.parseInt(makeMatch.group()));
            }
            int temp1=selectedElementPrices.indexOf((Collections.min(selectedElementPrices)));
            priceOfSelection1=Collections.min(selectedElementPrices);
            selection1= selectedElements.get(temp1);
            Name1=Elements.get(selection1).getText();
            buttons.get(selection1).click();
            selectedElements.clear();
            selectedElementPrices.clear();

            //SecondChoice

            for (int position = 0; position <= Elements.size() - 1; position++) {
                if (Elements.get(position).getText().contains("SPF-50") || Elements.get(position).getText().contains("spf-50")) {
                    selectedElements.add(position);
                }
            }
            for (int counter = 0; counter <= selectedElements.size() - 1; counter++) {
                Pattern intsOnly = Pattern.compile("\\d+");
                Matcher makeMatch = intsOnly.matcher(elementPrices.get(selectedElements.get(counter)).getText());
                makeMatch.find();
                selectedElementPrices.add(Integer.parseInt(makeMatch.group()));
            }
            int temp2=selectedElementPrices.indexOf((Collections.min(selectedElementPrices)));
            priceOfSelection2=Collections.min(selectedElementPrices);
            selection2= selectedElements.get(temp2);
            Name2=Elements.get(selection2).getText();
            buttons.get(selection2).click();
        }
        WebElement cart=driver.findElement(By.xpath("//button[contains(.,'Cart')]"));
        cart.click();
        return new checkout(driver,Name1,priceOfSelection1,Name2,priceOfSelection2);
        }
    }
