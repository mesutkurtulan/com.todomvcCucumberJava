package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class VuePage {

    public VuePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".new-todo")
    public WebElement textBox;

    @FindBy(css = ".toggle")
    public WebElement firstItemCheckBox;

    @FindBy(css = ".view >label")
    public WebElement firstItem;

    @FindBy(css = ".destroy")
    public WebElement firstItemDeleteIcon;

    @FindBys({
            @FindBy(css = ".todo")
    })
    public List<WebElement> todoList;


    public String firstItemONTheTODOlist(){
        String firstItemONTheTODOlist = Driver.getDriver().findElement(By.cssSelector(".todo-list > li:nth-child(1) > div > label")).getText(); // .view >label
        return firstItemONTheTODOlist;
    }

    public String secondItemONTheTODOlist(){
        String secondItemONTheTODOlist = Driver.getDriver().findElement(By.cssSelector(".todo-list > li:nth-child(2) > div > label")).getText();
        return secondItemONTheTODOlist;
    }

    public void addItemToTheTODOlist(String text){
        Driver.getDriver().get(ConfigReader.getProperty("todomvcUrl"));
        Driver.getDriver().findElement(By.cssSelector(".new-todo")).sendKeys(text+ Keys.ENTER);
    }

    public void addSecondItemToTheTODOlist(String text){
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

}
