package edu.unc.svkathcs.graphix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    void funcUp(){
        Log.v("TAAG", "it should go up");
        CustomView cv = (CustomView) findViewById(R.id.custom_canvas);

    }

    void funcDown(){
        Log.v("TAAG", "it shoudl go down");
    }
}
