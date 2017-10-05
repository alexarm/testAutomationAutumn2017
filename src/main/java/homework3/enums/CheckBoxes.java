package homework3.enums;

import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;

public enum CheckBoxes {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire"),
    HUR("Hur");

    public String label;

    CheckBoxes(String label) {
        this.label = label;
    }

    public static ArrayList<String> getCheckBoxesLabels(){
        ArrayList<String> labels = new ArrayList<String>();

        for (int i = 0; i < CheckBoxes.values().length; i++){
            labels.add(CheckBoxes.values()[i].label);
        }

        return labels;
    }

    @Override
    public String toString() {
        return label;
    }
}
