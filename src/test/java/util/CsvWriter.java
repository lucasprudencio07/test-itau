package util;

import com.opencsv.CSVWriter;
import model.Car;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {

    public static void writeData(List<Car> carList) throws IOException {


        CSVWriter csvWriter = new CSVWriter(new FileWriter(System.getProperty("user.dir") + "//src//test//resources//csv//dataFile.csv"));

//        String[] csvHeader = {"Brand", "Model", "Year", "Mileage", "Color", "Shift Type", "Price"};
//        csvWriter.writeNext(csvHeader);

        for (Car car : carList) {

            String[] carVector = {car.getBrand(), car.getModel(), car.getYear().toString(), car.getMileage().toString(), car.getColor(), car.getShiftType().toString().toLowerCase(), car.getVehiclePrice().toString()};

            csvWriter.writeNext(carVector);
        }

        csvWriter.flush();
        csvWriter.close();

    }

}
