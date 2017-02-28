package com.example.simac.assignment2;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private SensorManager sm;
    private Sensor prox_sensor, mag_sensor, accel_sensor;
    private List<Sensor> l;

    Button accel = (Button) findViewById(R.id.accel_but);
    Button prox = (Button) findViewById(R.id.prox_but);
    Button mag = (Button) findViewById(R.id.mag_but);
    TextView accel_stat = (TextView) findViewById(R.id.accel_stat);
    TextView accel_info = (TextView) findViewById(R.id.accel_info);
    TextView prox_stat = (TextView) findViewById(R.id.prox_stat);
    TextView prox_info = (TextView) findViewById(R.id.prox_info);
    TextView mag_stat = (TextView) findViewById(R.id.mag_stat);
    TextView mag_info = (TextView) findViewById(R.id.mag_info);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        l = sm.getSensorList(Sensor.TYPE_ALL);
        prox_sensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        mag_sensor = sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        accel_sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, accel_sensor, 100);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setLabel(accel_info, accel_sensor.getMaximumRange(), accel_sensor.getResolution(), accel_sensor.getMaxDelay());
        }
    }
    public void accel(View v){
        Log.v("TAAG", "Pressed accel.");
        startActivityForResult(new Intent(getBaseContext(), Graph.class), 1);
    }
    private void setLabel(TextView label, Float range, Float res, int delay) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Toast.makeText(this, event.sensor.getResolution() + "", Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    public void prox(View v) {
        Log.v("TAAG", "Pressed prox");
    }
    public void mag(View v) {
        Log.v("TAAG", "Pressed mag");
    }
}
