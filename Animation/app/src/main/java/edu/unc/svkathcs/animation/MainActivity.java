package edu.unc.svkathcs.animation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imv = (ImageView) findViewById(R.id.imv);
        imv.setBackgroundResource(R.drawable.mylist);
        ((AnimationDrawable)imv.getBackground()).start();
    }

    void funcUp(){
        Log.v("TAAG", "it should go up");
    }

    void funcDown(){
        Log.v("TAAG", "it shoudl go down");
    }
}
