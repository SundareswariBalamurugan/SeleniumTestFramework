package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.w3c.dom.ls.LSOutput;
import pages.Homepage;

public class HompageStepDef {

    Homepage homePage;
    public HompageStepDef() {
         homePage =  new Homepage();
    }

    @Given("User provide {string} and {string} in {string} page")
    public void user_provide_and(String Username, String password,String urlPage) {
        homePage.launchUrl(urlPage);
        homePage.provideLoginDetails(Username,password);
    }

    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        homePage.clickLoginButton();
    }

    @Then("User should be take to the store")
    public void user_should_be_take_to_the_store() {
        homePage.validateUserIsInProfilelPage();

    }

    @Given("User launches the {string} form")
    public void user_launches_the_form(String urlPage) {
        homePage.launchUrl(urlPage);
    }

    @When("User provides the details")
    public void user_provides_the_details() {
        homePage.userFillsINFormDetail();
    }
    @When("click submit")
    public void click_submit() {
       homePage.clickSubemitButton();
    }
    @Then("the details should be saved")
    public void the_details_should_be_saved() {

    }

    @When("I expand the list")
    public void i_expand_the_list() {
        homePage.expandtheList();
    }
    @Then("I enable the check boxes")
    public void i_enable_the_check_boxes() {
        homePage.enableCheckbox();
    }

    @When("I select the {string} radio button")
    public void i_select_the_radio_button(String option) throws InterruptedException {
        homePage.clickRadioButton(option);
    }
    @Then("Selected option should be displayed")
    public void selected_option_should_be_displayed() {
        homePage.valdiatedSelectedOption();
    }

    @When("I double click the double click button")
    public void i_double_click_the_double_click_button() {
       homePage.dbClick();
    }
    @When("I right click the right click button")
    public void i_right_click_the_right_click_button() {
       homePage.rightClick();
    }

    @Then("corresponding message should be displayed")
    public void corresponding_message_should_be_displayed() {
      homePage.validatemessage("dbClick");
      homePage.validatemessage("rightClick");
    }

    @When("User clicks {string} Link, HomePage should be launched")
    public void user_clicks_link(String link) {
        homePage.clickLink(link);
    }
    @Then("HomePage should be launched")
    public void home_page_should_be_launched() {

    }

    @When("User clicks click upload file to upload a new file")
    public void user_clicks_click_upload_file_to_upload_a_new_file() {
        homePage.uploadFile();
    }


}
