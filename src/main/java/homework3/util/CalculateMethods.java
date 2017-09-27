package homework3.util;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class CalculateMethods {

    public static double getStep(SelenideElement element){
        double step = element.getSize().width / 100.0;
        return step;
    }

    public static int getCurrentPosition(SelenideElement sliderHandle){
        return Integer.parseInt(sliderHandle.getText());
    }

    public static int getOffset(int position, SelenideElement sliderTrack, SelenideElement sliderHandle){
        int offset = (int)Math.round((position - getCurrentPosition(sliderHandle)) * getStep(sliderTrack));
        return offset - 2;
    }
}
