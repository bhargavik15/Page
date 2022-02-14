package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestScript {
    ActionsReusable actionsReusable=new ActionsReusable();
    @Test
    void textBox(){
        actionsReusable.openUrl("https://demoqa.com/automation-practice-form");
        actionsReusable.typeText(By.id("firstName"),"Bhargavi");
        actionsReusable.typeText(By.id("lastName"),"Kallagunta");
        actionsReusable.click(By.id("dateOfBirthInput"));
        actionsReusable.select(By.className("react-datepicker__year-select"),"2100");
        //actionsReusable.getAllLinks();
        System.out.println("Total links count:"+actionsReusable.getLinkCount());
        System.out.println(actionsReusable.getAllLinks());


    }
}
