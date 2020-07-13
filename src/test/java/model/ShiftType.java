package model;

public enum ShiftType {

    MANUAL("MANUAL"),
    AUTOMATIC("AUTOMATIC");

    private String shiftType;

    ShiftType(String shiftType) {
        this.shiftType = shiftType;
    }

    public String getShiftType() {
        return shiftType;
    }

}
