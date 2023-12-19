package simpaths.model.enums.baselineDataEnums;

import simpaths.model.enums.Indicator;

public enum IndicatorValueType implements ValueType<Indicator> {
    INSTANCE;
    public Indicator convert(String value) {
        if (value == null) {
            return null;
        } else if (value.equalsIgnoreCase("true")) {
            return Indicator.True;
        } else if (value.equalsIgnoreCase("false")) {
            return Indicator.False;
        } else {
            throw new IllegalArgumentException("Value must be 'true', 'false', or null");
        }
    }
}