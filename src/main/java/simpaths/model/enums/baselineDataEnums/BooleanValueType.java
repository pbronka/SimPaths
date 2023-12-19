package simpaths.model.enums.baselineDataEnums;

public enum BooleanValueType implements ValueType<Boolean> {
    INSTANCE;
    public Boolean convert(String value) {
        if (value == null) {
            return null;
        } else if (value.equalsIgnoreCase("true")) {
            return true;
        } else if (value.equalsIgnoreCase("false")) {
            return false;
        } else {
            throw new IllegalArgumentException("Value must be 'true', 'false', or null");
        }
    }
}