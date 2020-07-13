package cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import selenium.pages.PageFilteredSearch;
import selenium.pages.PageHome;
import selenium.tests.HomepageTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WebTestingStep {

    private static WebDriver chromeDriver;

    private PageHome home = new PageHome(chromeDriver);
    private HomepageTests homepageTests;

    private PageFilteredSearch pageFilteredSearch;

    private static String carManufacturer = "Ford";
    private static String carModel = "EcoSport";

    @Before
    public static void setUp() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lprudencio\\Downloads\\WebDriver\\chromedriver83.exe");
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\lucas\\Documents\\Drivers\\chromedriver83.exe");

        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        chromeDriver.manage().window().maximize();
    }


    // Step 01 ---------------------------------------------------------------------------------------------------------------------
    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        home.loadHome();
        assertThat(home.getTitle(), is(equalTo("Carros novos, usados e seminovos para comprar e vender - iCarros")));
    }


    @When("I select the brand and the car model")
    public void i_select_the_brand_and_the_car_model() throws InterruptedException {
        pageFilteredSearch = home.selectCarBrandAndModel(carManufacturer, carModel);

        assertThat(pageFilteredSearch.getManufacturerName(), is(equalTo(carManufacturer)));
        assertThat(pageFilteredSearch.getModelName(), is(equalTo(carModel)));
    }


    @Then("a list based on my filter will be returned")
    public void a_list_based_on_my_filter_will_be_returned() throws InterruptedException {

        String carBrandAndModel = carManufacturer + " " + carModel;

        List<WebElement> carList = pageFilteredSearch.getVehicleList();

        for (WebElement car : carList) {

            String actualCarBrandAndModel = car.getText().split(" ")[0] + " " + car.getText().split(" ")[1];

            assertThat(actualCarBrandAndModel.toLowerCase(), is(equalTo(carBrandAndModel.toLowerCase())));
        }

    }


    // Step 02 ---------------------------------------------------------------------------------------------------------------------
    @Given("I have a list on cars based on the brand and car model")
    public void i_have_a_list_on_cars_based_on_the_brand_and_car_model() throws InterruptedException {
        pageFilteredSearch = home.selectCarBrandAndModel(carManufacturer, carModel);

        assertThat(pageFilteredSearch.getManufacturerName(), is(equalTo(carManufacturer)));
        assertThat(pageFilteredSearch.getModelName(), is(equalTo(carModel)));
    }


    @When("I pick up some field on the annoucement")
    public void i_pick_up_some_field_on_the_annoucement() {
    }


    @Then("the price will be {int} of an {string} on the position {int}")
    public void the_price_will_be_of_an_on_the_position(Integer price, String model, Integer index) {
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


    @After(order = 0)
    public static void tearDown() {
        chromeDriver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
        chromeDriver.quit();
    }

}
