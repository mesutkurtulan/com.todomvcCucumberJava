package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.VuePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class VueStepDefinitions {
    VuePage vuePage = new VuePage();

    @Given("Empty ToDo list")
    public void empty_to_do_list() {
        Driver.getDriver().get(ConfigReader.getProperty("todomvcUrl"));
    }

    @When("I write {string} to <textbox> and press <enter>")
    public void i_write_to_textbox_and_press_enter(String string) {
        vuePage.textBox.sendKeys(string + Keys.ENTER);
    }

    @Then("I should see {string} item in ToDo list")
    public void i_should_see_item_in_to_do_list(String ExpectedString) {
        String actualString = vuePage.firstItemONTheTODOlist();
        Assert.assertEquals(ExpectedString, actualString);

        // Driver.closeDriver();
    }

    @Given("ToDo list with {string} item")
    public void to_do_list_with_item(String string) {
        vuePage.addItemToTheTODOlist(string);
    }

    @Then("I should see {string} item insterted to ToDo list below {string} item")
    public void i_should_see_item_insterted_to_to_do_list_below_item(String secondExpectedString, String firstExpectedString) {
        String firstActualString = vuePage.firstItemONTheTODOlist();
        Assert.assertEquals(firstExpectedString, firstActualString);

        String secondActualString = vuePage.secondItemONTheTODOlist();
        Assert.assertEquals(secondExpectedString, secondActualString);

        //Driver.closeDriver();
    }

    @When("I click on <checkbox> next to {string} item")
    public void i_click_on_checkbox_next_to_item(String string) {
        vuePage.firstItemCheckBox.click();
    }

    @Then("I should see {string} item marked as DONE")
    public void i_should_see_item_marked_as_done(String string) {
        Assert.assertEquals("todo completed", vuePage.firstCompletedItem());
        //Driver.closeDriver();
    }


    @Given("ToDo list with marked item")
    public void todoListWithMarkedItem() {
        vuePage.addItemToTheTODOlist("buy some milk");
        vuePage.firstItemCheckBox.click();
    }

    @Then("I should see {string} item marked as UNDONE")
    public void ıShouldSeeItemMarkedAsUNDONE(String arg0) {
        Assert.assertEquals("todo", vuePage.firstCompletedItem());
        //Driver.closeDriver();
    }

    @When("I click on <delete button> next to {string} item")
    public void ıClickOnDeleteButtonNextToItem(String arg0) {
        ReusableMethods.hover(vuePage.firstItem);
        vuePage.firstItemDeleteIcon.click();
    }

    @Then("List should be empty")
    public void listShouldBeEmpty() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(vuePage.todoList.isEmpty());
        //Driver.closeDriver();
    }

    @Given("ToDo list with {string} and {string} item in order")
    public void todoListWithAndItemInOrder(String item1, String item2) {
        vuePage.addItemToTheTODOlist(item1);
        vuePage.addSecondItemToTheTODOlist(item2);

    }
}
