package homework3.enums;

public enum HeaderMenu {
    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_AND_COLORS("Metals & Colors");

    public String page;


    HeaderMenu(String page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return page;
    }
}
