package simpaths.model.enums.baselineDataEnums;

import simpaths.model.enums.Dhhtp_c4;
import simpaths.model.enums.Les_c4;

public enum Dhhtp_c4_ValueType implements ValueType<Dhhtp_c4> {
    INSTANCE;
    public Dhhtp_c4 convert(String value) {
        if (value == null || value.equalsIgnoreCase("null")) {
            return null;
        } else if (value.equalsIgnoreCase("CoupleNoChildren")) {
            return Dhhtp_c4.CoupleChildren;
        } else if (value.equalsIgnoreCase("CoupleChildren")) {
            return Dhhtp_c4.CoupleChildren;
        }  else if (value.equalsIgnoreCase("SingleNoChildren")) {
            return Dhhtp_c4.SingleNoChildren;
        }  else if (value.equalsIgnoreCase("SingleChildren")) {
            return Dhhtp_c4.SingleChildren;
        }
        else {
            throw new IllegalArgumentException("Invalid value");
        }
    }
}