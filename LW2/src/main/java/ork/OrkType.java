package ork;

public enum OrkType {
    BASIC("Basic"),
    LEADER("Leader"),
    SCOUT("Scout");

    private final String displayName;

    OrkType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}