package homework3.enums;

public enum HeaderMenu {
    HOME(""),
    CONTACT_FORM(""),
    SERVICE(""),
    METALS_AND_COLORS("");

    public String url;

    HeaderMenu(String url) {
        this.url = url;
    }
}
