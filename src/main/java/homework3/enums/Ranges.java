package homework3.enums;

public enum Ranges {
    MIN(0),
    MAX(100),
    LEFT_TEST(30),
    RIGHT_TEST(70);

    public int range;

    Ranges(int range) {
        this.range = range;
    }
}
