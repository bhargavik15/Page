package page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ActionsReusable {
    WebDriver driver;
    List<WebElement> list;
    void openUrl(String url){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    WebElement getElement(By locator){
        return driver.findElement(locator);
    }
    void typeText(By locator,String value){
        if(isElementPresent(locator))
        getElement(locator).sendKeys(value);


    }
    void click(By locator){
        if(isElementPresent(locator))
        getElement(locator).click();
    }
    void select(By locator,String value){
        if(isElementPresent(locator))
        new Select(getElement(locator)).selectByVisibleText(value);

    }
    int getLinkCount(){
        list=driver.findElements(By.tagName("a"));
        return list.size();
    }
    List<String> getAllLinks(){
        List<String> allLinks=new ArrayList<>();
        for(int linkCount=0;linkCount<getLinkCount();linkCount++){
            allLinks.add(list.get(linkCount).getAttribute("href"));
        }
        return allLinks;
    }

    boolean isElementPresent(By locator) {
        try {
            getElement(locator).isDisplayed();
            return true;

        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Web element not found");
            return false;

        }


    }

}


