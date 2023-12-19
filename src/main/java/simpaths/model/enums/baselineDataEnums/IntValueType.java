package simpaths.model.enums.baselineDataEnums;

public enum IntValueType implements ValueType<Integer> {
    INSTANCE;
    public Integer convert(String value) {
        return Integer.parseInt(value);
    }
}
