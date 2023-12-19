package simpaths.model.enums.baselineDataEnums;

import simpaths.model.enums.Occupancy;

public enum Occupancy_ValueType implements ValueType<Occupancy> {
    INSTANCE;
    public Occupancy convert(String value) {
        if (value == null || value.equalsIgnoreCase("null")) {
            return null;
        } else if (value.equalsIgnoreCase("Couple")) {
            return Occupancy.Couple;
        } else if (value.equalsIgnoreCase("Single_Male")) {
            return Occupancy.Single_Male;
        }  else if (value.equalsIgnoreCase("Single_Female")) {
            return Occupancy.Single_Female;
        }
        else {
            throw new IllegalArgumentException("Invalid value");
        }
    }
}