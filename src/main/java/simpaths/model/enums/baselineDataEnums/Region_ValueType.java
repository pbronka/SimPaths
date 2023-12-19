package simpaths.model.enums.baselineDataEnums;

import simpaths.model.enums.Region;

public enum Region_ValueType implements ValueType<Region> {
    INSTANCE;
    public Region convert(String value) {
        if (value == null || value.equalsIgnoreCase("null")) {
            return null;
        } else if (value.equalsIgnoreCase("UKC")) {
            return Region.UKC;
        } else if (value.equalsIgnoreCase("UKD")) {
            return Region.UKD;
        }  else if (value.equalsIgnoreCase("UKE")) {
            return Region.UKE;
        }  else if (value.equalsIgnoreCase("UKF")) {
            return Region.UKF;
        }  else if (value.equalsIgnoreCase("UKG")) {
            return Region.UKG;
        }  else if (value.equalsIgnoreCase("UKH")) {
            return Region.UKH;
        }  else if (value.equalsIgnoreCase("UKI")) {
            return Region.UKI;
        }  else if (value.equalsIgnoreCase("UKJ")) {
            return Region.UKJ;
        }  else if (value.equalsIgnoreCase("UKK")) {
            return Region.UKK;
        }  else if (value.equalsIgnoreCase("UKL")) {
            return Region.UKL;
        }  else if (value.equalsIgnoreCase("UKM")) {
            return Region.UKM;
        }  else if (value.equalsIgnoreCase("UKN")) {
            return Region.UKN;
        }
        else {
            throw new IllegalArgumentException("Invalid value");
        }
    }
}