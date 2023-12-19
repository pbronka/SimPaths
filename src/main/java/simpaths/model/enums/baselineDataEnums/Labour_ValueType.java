package simpaths.model.enums.baselineDataEnums;

import simpaths.model.enums.Labour;

public enum Labour_ValueType implements ValueType<Labour> {
    INSTANCE;
    public Labour convert(String value) {
        if (value == null || value.equalsIgnoreCase("null")) {
            return null;
        } else if (value.equalsIgnoreCase("ZERO")) {
            return Labour.ZERO;
        } else if (value.equalsIgnoreCase("TEN")) {
            return Labour.TEN;
        }  else if (value.equalsIgnoreCase("TWENTY")) {
            return Labour.TWENTY;
        }  else if (value.equalsIgnoreCase("THIRTY")) {
            return Labour.THIRTY;
        }  else if (value.equalsIgnoreCase("FORTY")) {
            return Labour.FORTY;
        }
        else {
            throw new IllegalArgumentException("Invalid value");
        }
    }
}