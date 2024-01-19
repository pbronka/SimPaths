package simpaths.model.enums.baselineDataEnums;

public enum Cohort {
    THIRTY(30, 39),
    FORTY(40, 49),
    FIFTY(50, 59);

    private final int minAge;
    private final int maxAge;

    Cohort(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }
}

