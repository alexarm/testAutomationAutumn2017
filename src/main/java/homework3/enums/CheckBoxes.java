package homework3.enums;

import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;

public enum CheckBoxes {
    WATER($(".label-checkbox:nth-of-type(1) input"), "Water"),
    EARTH($(".label-checkbox:nth-of-type(2) input"), "Earth"),
    WIND($(".label-checkbox:nth-of-type(3) input"), "Wind"),
    FIRE($(".label-checkbox:nth-of-type(4) input"), "Fire");

    public SelenideElement checkBox;
    public String label;

    CheckBoxes(SelenideElement checkBox, String label) {
        this.checkBox = checkBox;
        this.label = label;
    }

    public static ArrayList<String> getCheckBoxesLabels(){
        ArrayList<String> labels = new ArrayList<String>();

        for (int i = 0; i < CheckBoxes.values().length; i++){
            labels.add(CheckBoxes.values()[i].label);
        }

        return labels;
    }
}
