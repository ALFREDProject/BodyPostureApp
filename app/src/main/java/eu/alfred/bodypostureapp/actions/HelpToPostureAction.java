package eu.alfred.bodypostureapp.actions;

import android.widget.ImageView;

import java.util.Map;

import eu.alfred.api.proxies.interfaces.ICadeCommand;
import eu.alfred.api.speech.Cade;
import eu.alfred.bodypostureapp.MainActivity;
import eu.alfred.bodypostureapp.R;

/**
 * Created by Gary on 26.02.2016.
 */
public class HelpToPostureAction implements ICadeCommand {

    final static String LIE = "lie";
    final static String SIT = "sit";
    final static String STAND = "stand";

    MainActivity main;
    Cade cade;

    public HelpToPostureAction(MainActivity main, Cade cade) {
        this.main = main;
        this.cade = cade;
    }

    @Override
    public void performAction(String s, Map<String, String> map) {

        ImageView howToImage = (ImageView) main.findViewById(R.id.image_howto);
        String posture = map.get("selected_bodyposture");

        if(posture.equals(STAND)) {
            howToImage.setImageResource(R.drawable.howto_stand);
        } else if(posture.equals(SIT)) {
            howToImage.setImageResource(R.drawable.howto_sit);
        } else {
            howToImage.setImageResource(R.drawable.howto_lie);
        }

        cade.sendActionResult(true);
    }

    @Override
    public void performWhQuery(String s, Map<String, String> map) {

    }

    @Override
    public void performValidity(String s, Map<String, String> map) {

    }

    @Override
    public void performEntityRecognizer(String s, Map<String, String> map) {

    }
}
