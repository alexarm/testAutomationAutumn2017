package homework3.enums;

import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;

public enum RadioButtons{
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    public String label;

    RadioButtons(String label) {
        this.label = label;
    }

    public static ArrayList<String> getRadioLabels(){
        ArrayList<String> labels = new ArrayList<String>();

        for (int i = 0; i < RadioButtons.values().length; i++){
            labels.add(RadioButtons.values()[i].label);
        }

        return labels;
    }

    @Override
    public String toString() {
        return label;
    }
}
