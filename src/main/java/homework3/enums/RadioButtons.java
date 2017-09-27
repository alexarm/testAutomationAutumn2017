package homework3.enums;

import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;

public enum RadioButtons{
    GOLD($(".label-radio:nth-of-type(1) input"), "Gold"),
    SILVER($(".label-radio:nth-of-type(2) input"), "Silver"),
    BRONZE($(".label-radio:nth-of-type(3) input"), "Bronze"),
    SELEN($(".label-radio:nth-of-type(4) input"), "Selen");

    public SelenideElement radio;
    public String label;

    RadioButtons(SelenideElement radio, String label) {
        this.radio = radio;
        this.label = label;
    }

    public static ArrayList<String> getRadioLabels(){
        ArrayList<String> labels = new ArrayList<String>();

        for (int i = 0; i < RadioButtons.values().length; i++){
            labels.add(RadioButtons.values()[i].label);
        }

        return labels;
    }
}
