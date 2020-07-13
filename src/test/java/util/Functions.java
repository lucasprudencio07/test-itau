package util;

import model.ShiftType;

public class Functions {

    public static String verifyDot(String mileage) {

        if (mileage.contains("."))
            return mileage.replace(".", "");

        return mileage;
    }

    public static ShiftType defineShiftType(String shiftTypeText) {

        if (shiftTypeText.toLowerCase().equals("automatico") || shiftTypeText.toLowerCase().equals("automático"))
            return ShiftType.AUTOMATIC;

        return ShiftType.MANUAL;
    }

}
