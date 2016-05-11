package eu.alfred.bodypostureapp;

import android.content.Intent;
import android.os.Bundle;

import java.util.Map;

import eu.alfred.api.proxies.interfaces.ICadeCommand;
import eu.alfred.bodypostureapp.actions.HelpToPostureAction;
import eu.alfred.ui.AppActivity;
import eu.alfred.ui.BackToPAButton;
import eu.alfred.ui.CircleButton;


public class MainActivity extends AppActivity implements ICadeCommand {

    final static String HELP_TO_POSTURE_ACTION = "HowToPostureAction";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circleButton = (CircleButton) findViewById(R.id.voiceControlBtn);
        circleButton.setOnTouchListener(new MicrophoneTouchListener());

        backToPAButton = (BackToPAButton) findViewById(R.id.backControlBtn);
        backToPAButton.setOnTouchListener(new BackTouchListener());
    }

    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    public void performAction(final String calledAction, final Map<String, String> map) {
        switch (calledAction) {
            case HELP_TO_POSTURE_ACTION:
                HelpToPostureAction htpa = new HelpToPostureAction(this, cade);
                htpa.performAction(calledAction, map);
                break;
            default:
                break;
        }
    }

    @Override
    public void performWhQuery(final String calledAction, final Map<String, String> map) {

    }

    @Override
    public void performValidity(String calledAction, Map<String, String> map) {
    }

    @Override
    public void performEntityRecognizer(String calledAction, Map<String, String> map) {
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
