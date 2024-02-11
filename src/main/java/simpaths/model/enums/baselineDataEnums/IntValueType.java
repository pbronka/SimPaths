package simpaths.model.enums.baselineDataEnums;

public enum IntValueType implements ValueType<Integer> {
    INSTANCE;
    public Integer convert(String value) {
        if (value == null || value.equalsIgnoreCase("null")) {
            return 0;
        } else return Integer.parseInt(value);
    }
}
