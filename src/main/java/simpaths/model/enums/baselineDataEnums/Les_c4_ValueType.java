package simpaths.model.enums.baselineDataEnums;

import simpaths.model.enums.Les_c4;

public enum Les_c4_ValueType implements ValueType<Les_c4> {
    INSTANCE;
    public Les_c4 convert(String value) {
        if (value == null || value.equalsIgnoreCase("null")) {
            return null;
        } else if (value.equalsIgnoreCase("EmployedOrSelfEmployed")) {
            return Les_c4.EmployedOrSelfEmployed;
        } else if (value.equalsIgnoreCase("NotEmployed")) {
            return Les_c4.NotEmployed;
        }  else if (value.equalsIgnoreCase("Student")) {
            return Les_c4.Student;
        }  else if (value.equalsIgnoreCase("Retired")) {
            return Les_c4.Retired;
        }
        else {
            throw new IllegalArgumentException("Invalid value");
        }
    }
}