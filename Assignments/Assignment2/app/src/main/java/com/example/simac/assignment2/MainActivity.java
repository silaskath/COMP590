package com.example.simac.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button accel = (Button) findViewById(R.id.accel_but);
        Button prox = (Button) findViewById(R.id.prox_but);
        Button mag = (Button) findViewById(R.id.mag_but);
    }
    public void accel(View v){
        Log.v("TAAG", "Pressed accel.");
    }
    public void prox(View v) {
        Log.v("TAAG", "Pressed prox");
    }
    public void mag(View v) {
        Log.v("TAAG", "Pressed mag");
    }
}
