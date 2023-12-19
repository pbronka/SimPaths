package simpaths.model.enums.baselineDataEnums;

public enum LongValueType implements ValueType<Long> {
    INSTANCE;
    public Long convert(String value) {
        return Long.parseLong(value);
    }
}
