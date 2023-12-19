package simpaths.model.enums.baselineDataEnums;

import simpaths.model.enums.Ydses_c5;

public enum Ydses_c5_ValueType implements ValueType<Ydses_c5> {
    INSTANCE;
    public Ydses_c5 convert(String value) {
        if (value == null || value.equalsIgnoreCase("null")) {
            return null;
        } else if (value.equalsIgnoreCase("Q1")) {
            return Ydses_c5.Q1;
        } else if (value.equalsIgnoreCase("Q2")) {
            return Ydses_c5.Q2;
        }  else if (value.equalsIgnoreCase("Q3")) {
            return Ydses_c5.Q3;
        }  else if (value.equalsIgnoreCase("Q4")) {
            return Ydses_c5.Q4;
        }  else if (value.equalsIgnoreCase("Q5")) {
            return Ydses_c5.Q5;
        }
        else {
            throw new IllegalArgumentException("Invalid value");
        }
    }
}