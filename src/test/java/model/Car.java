package model;

public class Car {

    private String brand;
    private String model;
    private Integer year;
    private Integer mileage;
    private String color;
    private ShiftType shiftType;
    private Integer vehiclePrice;

    // Constructor
    public Car(String brand, String model, Integer year, Integer mileage, String color, ShiftType shiftType, Integer vehiclePrice) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.color = color;
        this.shiftType = shiftType;
        this.vehiclePrice = vehiclePrice;
    }

    // Getter & Setter
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ShiftType getShiftType() {
        return shiftType;
    }

    public void setShiftType(ShiftType shiftType) {
        this.shiftType = shiftType;
    }

    public Integer getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(Integer vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }
}
