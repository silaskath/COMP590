package edu.unc.svkathcs.assignment2;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.FloatProperty;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager sm;
    private Sensor accel, light, mag;
    private TextView accel_stat, accel_info, light_stat, light_info, mag_stat, mag_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accel = sm.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        light = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        mag = sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        accel_stat = (TextView) findViewById(R.id.accel_stat);
        accel_info = (TextView) findViewById(R.id.accel_info);
        light_stat = (TextView) findViewById(R.id.light_stat);
        light_info = (TextView) findViewById(R.id.light_info);
        mag_stat = (TextView) findViewById(R.id.mag_stat);
        mag_info = (TextView) findViewById(R.id.mag_info);

        // Display sensor availablity and information
        if(sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            accel_stat.setText("Status: Accelerometer is present.");
            accel_info.setText("Info: " +
                    accel.getMaximumRange() + ", " +
                    accel.getResolution() + ", " +
                    accel.getMaxDelay());
        }
        else {
            accel_stat.setText("Status: Accelerometer is not present.");
            accel_info.setText("Info: No info to display.");
        }
        if(sm.getDefaultSensor(Sensor.TYPE_LIGHT) != null) {
            light_stat.setText("Status: Light sensor is present.");
            light_info.setText("Info: " +
                    light.getMaximumRange() + ", " +
                    light.getResolution() + ", " +
                    light.getMaxDelay());
        }
        else {
            light_stat.setText("Status: Light sensor is not present.");
            light_stat.setText("Info: No info to display.");
        }
        if(sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null) {
            mag_stat.setText("Status: Magnetometer is present.");
            mag_info.setText("Info: " +
                    mag.getMaximumRange() + ", " +
                    mag.getResolution() + ", " +
                    mag.getMaxDelay());
        }
        else {
            mag_stat.setText("Status: Magnetometer is not present.");
            mag_info.setText("Info: No info to display.");
        }

    }

    public void accelClick(View v) {
        loadGraph(Sensor.TYPE_ACCELEROMETER);
    }
    public void lightClick(View v) {
        loadGraph(Sensor.TYPE_LIGHT);
    }
    public void magClick(View v) {
        loadGraph(Sensor.TYPE_MAGNETIC_FIELD);
    }
    public void aAnim(View v) {
        Intent a_anim = new Intent(this, AccelAnimation.class);
        startActivity(a_anim);
    }

    public void loadGraph(int sensor) {
        Intent graph = new Intent(this, GraphActivity.class);
        graph.putExtra("sensor", sensor);
        startActivity(graph);
    }

}
