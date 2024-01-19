package simpaths.model.enums.baselineDataEnums;

public enum DoubleValueType implements ValueType<Double> {
    INSTANCE;
    public Double convert(String value) {
        if (value == null || value.equalsIgnoreCase("null")) {
            return 0.;
        } else return Double.parseDouble(value);
    }
}