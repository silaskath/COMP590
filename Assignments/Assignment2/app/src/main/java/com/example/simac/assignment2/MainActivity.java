package com.example.simac.assignment2;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager sm;
    private Sensor light, gravity, accelerometer;
    private List<Sensor> l;

    Button accel = (Button) findViewById(R.id.accel_but);
    Button prox = (Button) findViewById(R.id.prox_but);
    Button mag = (Button) findViewById(R.id.mag_but);
    TextView accel_stat = (View) findViewById(R.id.accel_stat);
    TextView accel_info = (View) findViewById(R.id.accel_info);
    TextView prox_stat = (View) findViewById(R.id.prox_stat);
    TextView prox_info = (View) findViewById(R.id.prox_info);
    TextView mag_stat = (View) findViewById(R.id.mag_stat);
    TextView mag_info = (View) findViewById(R.id.mag_info);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        l = sm.getSensorList(Sensor.TYPE_ALL);
//        light = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
//        gravity = sm.getDefaultSensor(Sensor.TYPE_GRAVITY);
        accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, accelerometer, 100);
    }
    public void accel(View v){
        Log.v("TAAG", "Pressed accel.");
        startActivityForResult(new Intent(getBaseContext(), Graph.class), 1);
    }
    public void prox(View v) {
        Log.v("TAAG", "Pressed prox");
    }
    public void mag(View v) {
        Log.v("TAAG", "Pressed mag");
    }
}
