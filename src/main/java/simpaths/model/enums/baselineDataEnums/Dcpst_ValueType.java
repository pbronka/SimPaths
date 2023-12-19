package simpaths.model.enums.baselineDataEnums;

import simpaths.model.enums.Dcpst;

public enum Dcpst_ValueType implements ValueType<Dcpst> {
    INSTANCE;
    public Dcpst convert(String value) {
        if (value == null || value.equalsIgnoreCase("null")) {
            return null;
        } else if (value.equalsIgnoreCase("Partnered")) {
            return Dcpst.Partnered;
        } else if (value.equalsIgnoreCase("SingleNeverMarried")) {
            return Dcpst.SingleNeverMarried;
        }  else if (value.equalsIgnoreCase("PreviouslyPartnered")) {
            return Dcpst.PreviouslyPartnered;
        }
        else {
            throw new IllegalArgumentException("Invalid value");
        }
    }
}