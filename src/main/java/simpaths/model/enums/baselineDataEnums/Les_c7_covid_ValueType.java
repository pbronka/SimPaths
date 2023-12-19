package simpaths.model.enums.baselineDataEnums;

import simpaths.model.enums.Les_c7_covid;

public enum Les_c7_covid_ValueType implements ValueType<Les_c7_covid> {
    INSTANCE;
    public Les_c7_covid convert(String value) {
        if (value == null || value.equalsIgnoreCase("null")) {
            return null;
        } else if (value.equalsIgnoreCase("Employee")) {
            return Les_c7_covid.Employee;
        } else if (value.equalsIgnoreCase("SelfEmployed")) {
            return Les_c7_covid.SelfEmployed;
        }  else if (value.equalsIgnoreCase("FurloughedFull")) {
            return Les_c7_covid.FurloughedFull;
        }  else if (value.equalsIgnoreCase("FurloughedFlex")) {
            return Les_c7_covid.FurloughedFlex;
        }   else if (value.equalsIgnoreCase("NotEmployed")) {
            return Les_c7_covid.NotEmployed;
        }   else if (value.equalsIgnoreCase("Student")) {
            return Les_c7_covid.Student;
        }   else if (value.equalsIgnoreCase("Retired")) {
            return Les_c7_covid.Retired;
        }
        else {
            throw new IllegalArgumentException("Invalid value");
        }
    }
}