package simpaths.model.enums.baselineDataEnums;

public enum DoubleValueType implements ValueType<Double> {
    INSTANCE;
    public Double convert(String value) {
        return Double.parseDouble(value);
    }
}