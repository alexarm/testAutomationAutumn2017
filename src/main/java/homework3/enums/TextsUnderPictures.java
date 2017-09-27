package homework3.enums;

import java.util.ArrayList;

public enum TextsUnderPictures {
    TEXT_PRACTISE("To include good practices\nand ideas from successful\nEPAM projec"),
    TEXT_CUSTOM("To be flexible and\ncustomizable"),
    TEXT_MULTI("To be multiplatform"),
    TEXT_BASE("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    public String text;

    TextsUnderPictures(String text) {
        this.text = text;
    }

    public static ArrayList<String> getTexts(){
        ArrayList<String> texts = new ArrayList<String>();

        for (int i = 0; i < TextsUnderPictures.values().length; i++){
            texts.add(TextsUnderPictures.values()[i].text);
        }

        return texts;
    }

}
