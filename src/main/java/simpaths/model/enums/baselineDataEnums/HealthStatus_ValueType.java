package simpaths.model.enums.baselineDataEnums;

import simpaths.model.enums.HealthStatus;

public enum HealthStatus_ValueType implements ValueType<HealthStatus> {
    INSTANCE;
    public HealthStatus convert(String value) {
        if (value == null || value.equalsIgnoreCase("null")) {
            return null;
        } else if (value.equalsIgnoreCase("Good")) {
            return HealthStatus.Good;
        } else if (value.equalsIgnoreCase("Poor")) {
            return HealthStatus.Poor;
        }
        else {
            throw new IllegalArgumentException("Invalid value");
        }
    }
}