package cucumber.Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebTestingStep {

    // Step 01 ---------------------------------------------------------------------------------------------------------------------
    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        System.out.println("a");
    }

    @When("I select the brand and the car model")
    public void i_select_the_brand_and_the_car_model() {
    }

    @Then("a list based on my filter will be returned")
    public void a_list_based_on_my_filter_will_be_returned() {
    }


    // Step 02 ---------------------------------------------------------------------------------------------------------------------
    @Given("I have a list on cars based on the brand and car model")
    public void i_have_a_list_on_cars_based_on_the_brand_and_car_model() {
    }

    @When("I pick up some field on the annoucement")
    public void i_pick_up_some_field_on_the_annoucement() {
    }
    @Then("the price will be {string} of an {string} on the position {int}")
    public void the_price_will_be_of_an_on_the_position(String string, String string2, Integer int1) {
    }


    // Step 03 ---------------------------------------------------------------------------------------------------------------------
    @Given("I need to read the vehicle list")
    public void i_need_to_read_the_vehicle_list() {
    }


    @When("I create a csv file")
    public void i_create_a_csv_file() {
    }


    @Then("all the car data need to be saved into this file")
    public void all_the_car_data_need_to_be_saved_into_this_file() {
    }


    // Step 04 ---------------------------------------------------------------------------------------------------------------------
    @Given("I have a list of vehicles")
    public void i_have_a_list_of_vehicles() {
    }


    @Then("I need to validate all the data")
    public void i_need_to_validate_all_the_data() {
    }

}
