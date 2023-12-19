package simpaths.model.enums.baselineDataEnums;

import simpaths.model.enums.Education;

public enum Education_ValueType implements ValueType<Education> {
    INSTANCE;
    public Education convert(String value) {
        if (value == null || value.equalsIgnoreCase("null")) {
            return null;
        } else if (value.equalsIgnoreCase("Low")) {
            return Education.Low;
        } else if (value.equalsIgnoreCase("Medium")) {
            return Education.Medium;
        }  else if (value.equalsIgnoreCase("High")) {
            return Education.High;
        }
        else {
            throw new IllegalArgumentException("Invalid value");
        }
    }
}