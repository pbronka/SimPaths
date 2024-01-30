package simpaths.model.enums.baselineDataEnums;

public enum Cohort {
    TWENTY(20,20),
    THIRTY(30, 30),
    FORTY(40, 40),
    FIFTY(50, 50);

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