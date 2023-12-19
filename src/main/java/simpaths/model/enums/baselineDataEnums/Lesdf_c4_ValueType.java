package simpaths.model.enums.baselineDataEnums;

import simpaths.model.enums.Lesdf_c4;

public enum Lesdf_c4_ValueType implements ValueType<Lesdf_c4> {
    INSTANCE;
    public Lesdf_c4 convert(String value) {
        if (value == null || value.equalsIgnoreCase("null")) {
            return null;
        } else if (value.equalsIgnoreCase("BothEmployed")) {
            return Lesdf_c4.BothEmployed;
        } else if (value.equalsIgnoreCase("EmployedSpouseNotEmployed")) {
            return Lesdf_c4.EmployedSpouseNotEmployed;
        }  else if (value.equalsIgnoreCase("NotEmployedSpouseEmployed")) {
            return Lesdf_c4.NotEmployedSpouseEmployed;
        }  else if (value.equalsIgnoreCase("BothNotEmployed")) {
            return Lesdf_c4.BothNotEmployed;
        }
        else {
            throw new IllegalArgumentException("Invalid value");
        }
    }
}