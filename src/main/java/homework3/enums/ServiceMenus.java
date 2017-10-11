package homework3.enums;

import java.util.ArrayList;

public enum ServiceMenus {
    SUPPORT("support"),
    DATES("dates"),
    COMPLEX_TABLE("complex table"),
    SIMPLE_TABLE("simple table"),
    TABLE_WITH_PAGES("table with pages"),
    DIFFERENT_ELEMENTS("different elements");

    public String menuName;

    ServiceMenus(String menuName) {
        this.menuName = menuName;
    }

    public static ArrayList<String> getMenuNames() {
        ArrayList<String> names = new ArrayList<String>();
        for (int i = 0; i < ServiceMenus.values().length; i++) {
            names.add(ServiceMenus.values()[i].menuName);
        }
        return names;
    }

    @Override
    public String toString() {
        return menuName;
    }
}
