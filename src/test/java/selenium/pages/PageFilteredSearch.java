package selenium.pages;

import model.Car;
import model.ShiftType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Functions;

import java.util.ArrayList;
import java.util.List;

public class PageFilteredSearch {

    private WebDriver chromeDriver;

    private List<String> vehicleBrandListString = new ArrayList<>();
    private List<String> vehicleModelListString = new ArrayList<>();
    private List<Integer> vehicleYearListInteger = new ArrayList<>();
    private List<Integer> vehicleMileageListInteger = new ArrayList<>();
    private List<String> vehicleColorListString = new ArrayList<>();
    private List<ShiftType> vehicleShiftTypeList = new ArrayList<>();
    private List<Integer> vehiclePriceListInteger = new ArrayList<>();


    public PageFilteredSearch(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }


    public String getManufacturerName() {
        return chromeDriver.findElement(By.xpath("//div[@class='sticky_conteudo']//h1")).getText().split(" ")[0];
    }


    public String getModelName() {
        return chromeDriver.findElement(By.xpath("//div[@class='sticky_conteudo']//h1")).getText().split(" ")[1];
    }


    public List<WebElement> getVehicleList() {

        return chromeDriver.findElements(By.cssSelector("a.clearfix h2"));
    }

    public List<String> getVehicleNames() {

        List<String> vehicleBrandModelListString = new ArrayList<>();
        List<WebElement> vehicleNameWebElements = chromeDriver.findElements(By.cssSelector("a.clearfix h2"));
        vehicleNameWebElements.forEach(vehicle -> vehicleBrandModelListString.add(vehicle.getText()));

        return vehicleBrandModelListString;
    }


    public List<Integer> getVehiclePrices() {

        List<WebElement> vehiclePriceWebElements = chromeDriver.findElements(By.cssSelector("a.clearfix h3"));
        vehiclePriceWebElements.forEach(vehicle -> vehicleMileageListInteger.add(Integer.parseInt(vehicle.getText().substring(3, 9).replace(".", ""))));


        return vehicleMileageListInteger;
    }

    public List<Car> getCompleteCarDetails() {

        List<Car> carList = new ArrayList<>();

        // Get all brand names
        List<WebElement> vehicleBrandWE = chromeDriver.findElements(By.cssSelector("a.clearfix h2"));
        vehicleBrandWE.forEach(vehicleBrand -> vehicleBrandListString.add(vehicleBrand.getText().split(" ")[0]));

        // Get all model names
        List<WebElement> vehicleModelWE = chromeDriver.findElements(By.cssSelector("a.clearfix h2"));
        vehicleModelWE.forEach(vehicleModel -> vehicleModelListString.add(vehicleModel.getText().substring(5)));

        // Get all manufaturer year
        List<WebElement> vehicleYearWE = chromeDriver.findElements(By.cssSelector("a.clearfix ul.listahorizontal li.primeiro p"));
        vehicleYearWE.forEach(vehicleYear -> vehicleYearListInteger.add(Integer.parseInt(vehicleYear.getText().substring(0, 4))));

        // Get all car mileage
        List<WebElement> vehicleMileageWE = chromeDriver.findElements(By.cssSelector("a.clearfix ul.listahorizontal li.usado p"));
        vehicleMileageWE.forEach(vehicleMileage -> vehicleMileageListInteger.add(Integer.parseInt(Functions.verifyDot(vehicleMileage.getText()))));

        // Get all car color
        List<WebElement> vehicleColorWE = chromeDriver.findElements(By.cssSelector("a.clearfix ul.listahorizontal li:nth-child(3) p"));
        vehicleColorWE.forEach(vehicleColor -> vehicleColorListString.add(vehicleColor.getText().toLowerCase()));

        // Get all shift type
        List<WebElement> vehicleShiftTypeWE = chromeDriver.findElements(By.cssSelector("a.clearfix ul.listahorizontal li.ultimo p"));
        vehicleShiftTypeWE.forEach(vehicleShiftType -> vehicleShiftTypeList.add(Functions.defineShiftType(vehicleShiftType.getText())));

        // Get all prices
        List<WebElement> vehiclePriceWE = chromeDriver.findElements(By.cssSelector("a.clearfix h3"));
        vehiclePriceWE.forEach(vehiclePrice -> vehiclePriceListInteger.add(Integer.parseInt(vehiclePrice.getText().substring(3, 9).replace(".", ""))));


        for (int index = 0; index < 20; index++) {

            carList.add(index, new Car(vehicleBrandListString.get(index),
                                       vehicleModelListString.get(index),
                                       vehicleYearListInteger.get(index),
                                       vehicleMileageListInteger.get(index),
                                       vehicleColorListString.get(index),
                                       vehicleShiftTypeList.get(index),
                                       vehiclePriceListInteger.get(index)));
        }

        return carList;
    }
}
