public enum DataStatus {
    ACTIVE("active"),
    INACTIVE("inactive"),
    BLOCKED("blocked"),
    DEAD("dead");

    private final String option;

    private DataStatus(final String option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return option;
    }

}
