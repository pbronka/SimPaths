package simpaths.model.enums.baselineDataEnums;


import simpaths.model.enums.Quintiles;

public enum Quintiles_ValueType implements ValueType<Quintiles> {
    INSTANCE;
    public Quintiles convert(String value) {
        if (value == null || value.equalsIgnoreCase("null")) {
            return null;
        } else if (value.equalsIgnoreCase("Q1")) {
            return Quintiles.Q1;
        } else if (value.equalsIgnoreCase("Q2")) {
            return Quintiles.Q2;
        }  else if (value.equalsIgnoreCase("Q3")) {
            return Quintiles.Q3;
        }  else if (value.equalsIgnoreCase("Q4")) {
            return Quintiles.Q4;
        }  else if (value.equalsIgnoreCase("Q5")) {
            return Quintiles.Q5;
        }
        else {
            throw new IllegalArgumentException("Invalid value");
        }
    }
}