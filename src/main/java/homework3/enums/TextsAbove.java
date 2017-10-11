package homework3.enums;

public enum TextsAbove {
    MAIN_TITLE("EPAM framework Wishes…"),
    MAIN_TXT("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor " +
            "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation " +
            "ullamco laboris nisi ut aliquip ex ea commodo consequat Duis aute irure dolor in reprehenderit " +
            "in voluptate velit esse cillum dolore eu fugiat nulla pariatur.");

    public String text;

    TextsAbove(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
