package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class VuePage {

    public VuePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "toggle")
    public WebElement firstItemCheckBox;

    @FindBy(css = ".view >label")
    public WebElement firstItem;

    @FindBy(className = "destroy")
    public WebElement firstItemDeleteIcon;

    @FindBys({
            @FindBy(className = "todo")
    })

    public List<WebElement> todoList;

    public void goToEmptyToDoList(){
        Driver.getDriver().get(ConfigReader.getProperty("todomvcUrl"));
    }

    public String firstItemONTheTODOlist(){
        String firstItemONTheTODOlist = Driver.getDriver().findElement(By.cssSelector(".todo-list > li:nth-child(1) > div > label")).getText();
        return firstItemONTheTODOlist;
    }

    public String secondItemONTheTODOlist(){
        String secondItemONTheTODOlist = Driver.getDriver().findElement(By.cssSelector(".todo-list > li:nth-child(2) > div > label")).getText();
        return secondItemONTheTODOlist;
    }

    public void addItemToTheTODOlist(String text){
        Driver.getDriver().findElement(By.cssSelector(".new-todo")).sendKeys(text+ Keys.ENTER);
    }

    public String firstCompletedItem(){
        String actualCssValue = Driver.getDriver().findElement(By.cssSelector(".todo-list > li:nth-child(1)")).getAttribute("class");
        return actualCssValue;
    }

    public String markAllAsComplete(){
        String markAllAsComplete = Driver.getDriver().findElement(By.cssSelector(".main > label")).getText();
        return markAllAsComplete;
    }

    public List<String> allToDoList(){

        List<WebElement> toDoListElement = Driver.getDriver().findElements(By.cssSelector(".todo")); // list'teki eleman sayısı

        ArrayList<String> toDoList = new ArrayList<>();

        for (int i = 1; i <=toDoListElement.size() ; i++) {
            String todoElement = ".todo-list > li:nth-child("+i+")";
            String eachElementText = Driver.getDriver().findElement(By.cssSelector(todoElement)).getText();
            toDoList.add(eachElementText);
        }
        return toDoList;
    }

}
