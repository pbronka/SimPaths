package simpaths.model.enums.baselineDataEnums;

import simpaths.model.enums.Dhe;

public enum Dhe_ValueType implements ValueType<Dhe> {
    INSTANCE;
    public Dhe convert(String value) {
        if (value == null || value.equalsIgnoreCase("null")) {
            return null;
        } else if (value.equalsIgnoreCase("Poor")) {
            return Dhe.Poor;
        } else if (value.equalsIgnoreCase("Fair")) {
            return Dhe.Fair;
        }  else if (value.equalsIgnoreCase("Good")) {
            return Dhe.Good;
        } else if (value.equalsIgnoreCase("VeryGood")) {
            return Dhe.VeryGood;
        } else if (value.equalsIgnoreCase("Excellent")) {
            return Dhe.Excellent;
        }
        else {
            throw new IllegalArgumentException("Invalid value");
        }
    }
}