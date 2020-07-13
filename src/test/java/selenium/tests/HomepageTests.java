package selenium.tests;

import model.Car;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import selenium.base.BaseTests;
import selenium.pages.PageFilteredSearch;
import util.CsvWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class HomepageTests extends BaseTests {

    private PageFilteredSearch pageFilteredSearch;

    private static final String brand = "Ford";
    private static final String model = "EcoSport";

    private static final String ecosportTitaniumName = "Ford EcoSport Titanium 1.5 (Aut) (Flex)".toLowerCase();
    private static final String ecosportSEName = "Ford EcoSport SE 1.5 (Aut) (Flex)".toLowerCase();
    private static final Integer ecosportTitaniumPrice = 82790;
    private static final Integer ecosportSEPrice = 63900;

    private static final String csvSpliter = ",";

    @Test
    public void testingHome() {
        home.getTitle();
        assertThat(home.getTitle(), is(equalTo("Carros novos, usados e seminovos para comprar e vender - iCarros")));
    }


    @Test
    public void validateCarManufacturerAndModel() throws InterruptedException {
        pageFilteredSearch = home.selectCarBrandAndModel(brand, model);

        assertThat(pageFilteredSearch.getManufacturerName(), is(equalTo(brand)));
        assertThat(pageFilteredSearch.getModelName(), is(equalTo(model)));

    }


    @Test
    public void validateCarResultList() throws InterruptedException {

        validateCarManufacturerAndModel();

        String carBrandAndModel = brand + " " + model;

        List<WebElement> carList = pageFilteredSearch.getVehicleList();

        for (WebElement car : carList) {

            String actualCarBrandAndModel = car.getText().split(" ")[0] + " " + car.getText().split(" ")[1];

            assertThat(actualCarBrandAndModel.toLowerCase(), is(equalTo(carBrandAndModel.toLowerCase())));
        }

    }


    @Test
    public void validateModelAndPriceOfThe2FirstCars() throws InterruptedException {

        validateCarManufacturerAndModel();

        List<String> vehicleNameList = pageFilteredSearch.getVehicleNames();

        String firstVehicleName = vehicleNameList.get(0);
        String secondVehicleName = vehicleNameList.get(1);

        assertThat(firstVehicleName.toLowerCase(), is(equalTo(ecosportTitaniumName)));
        assertThat(secondVehicleName.toLowerCase(), is(equalTo(ecosportSEName)));

        //------------------------------------------------------------------------------

        List<Integer> vehiclePriceList = pageFilteredSearch.getVehiclePrices();

        Integer firstVehiclePrice = vehiclePriceList.get(0);
        Integer secondVehiclePrice = vehiclePriceList.get(1);

        assertThat(firstVehiclePrice, is(equalTo(ecosportTitaniumPrice)));
        assertThat(secondVehiclePrice, is(equalTo(ecosportSEPrice)));

    }


    @Test
    public void saveDataInACsv() throws IOException, InterruptedException {

        validateCarManufacturerAndModel();

        List<Car> carList = pageFilteredSearch.getCompleteCarDetails();

        CsvWriter.writeData(carList);
    }


    @Test
    public void readCsvDataAndValidate() throws InterruptedException {

        validateCarManufacturerAndModel();

        List<Car> carList = pageFilteredSearch.getCompleteCarDetails();

        String csvFilePath = System.getProperty("user.dir") + "//src//test//resources//csv//dataFile.csv";
        String line;
        Integer counter = 0;

        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFilePath));

            bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null && counter < 20) {

                String[] car = line.split(",");

                assertThat(car[0].replace("\"", ""), is(equalTo(carList.get(counter).getBrand())));
                assertThat(car[1].replace("\"", ""), is(equalTo(carList.get(counter).getModel())));
                assertThat(car[2].replace("\"", ""), is(equalTo(carList.get(counter).getYear().toString())));
                assertThat(car[3].replace("\"", ""), is(equalTo(carList.get(counter).getMileage().toString())));
                assertThat(car[4].replace("\"", ""), is(equalTo(carList.get(counter).getColor())));
                assertThat(car[5].replace("\"", ""), is(equalTo(carList.get(counter).getShiftType().toString().toLowerCase())));
                assertThat(car[6].replace("\"", ""), is(equalTo(carList.get(counter).getVehiclePrice().toString())));

                counter++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
