package homework3.enums;

import java.util.ArrayList;

public enum Colors {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    public String color;

    Colors(String color) {
        this.color = color;
    }

    public static ArrayList<String> getColors(){
        ArrayList<String> colors = new ArrayList<String>();

        for (int i = 0; i < Colors.values().length; i++){
            colors.add(Colors.values()[i].color);
        }

        return colors;
    }
}
