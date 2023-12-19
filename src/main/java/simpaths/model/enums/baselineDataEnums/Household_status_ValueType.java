package simpaths.model.enums.baselineDataEnums;

import simpaths.model.enums.Household_status;

public enum Household_status_ValueType implements ValueType<Household_status> {
    INSTANCE;
    public Household_status convert(String value) {
        if (value == null || value.equalsIgnoreCase("null")) {
            return null;
        } else if (value.equalsIgnoreCase("Parents")) {
            return Household_status.Parents;
        } else if (value.equalsIgnoreCase("Single")) {
            return Household_status.Single;
        } else if (value.equalsIgnoreCase("Couple")) {
            return Household_status.Couple;
        }

        else {
            throw new IllegalArgumentException("Invalid value");
        }
    }
}