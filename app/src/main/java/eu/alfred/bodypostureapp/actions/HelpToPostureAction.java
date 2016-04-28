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

        switch (posture) {
            case("sit"):
            case("assis"):
            case("zit"):
                howToImage.setImageResource(R.drawable.howto_stand);
                break;
            case("stand"):
            case("debout"):
            case("sta"):
                howToImage.setImageResource(R.drawable.howto_sit);
                break;
            case("lie"):
            case("allonge"):
            case("lig"):
                howToImage.setImageResource(R.drawable.howto_lie);
                break;
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
