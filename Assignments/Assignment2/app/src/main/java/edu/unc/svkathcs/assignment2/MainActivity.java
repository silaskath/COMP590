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

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private SensorManager sm;
    private Sensor sensor, accel, light, mag;
    private TextView temp, accel_stat, accel_info, light_stat, light_info, mag_stat, mag_info;
    private int current_sensor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accel = sm.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        light = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        mag = sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
//        sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
//        sm.registerListener(this, sensor, 100000000);
//        sm.registerListener(this, grav, 1);
        temp = (TextView) findViewById(R.id.temp);
        accel_stat = (TextView) findViewById(R.id.accel_stat);
        accel_info = (TextView) findViewById(R.id.accel_info);
        light_stat = (TextView) findViewById(R.id.light_stat);
        light_info = (TextView) findViewById(R.id.light_info);
        mag_stat = (TextView) findViewById(R.id.mag_stat);
        mag_info = (TextView) findViewById(R.id.mag_info);

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
        loadGraph();
        sm.unregisterListener(this);
        sm.registerListener(this, accel, 100000000);
        current_sensor = Sensor.TYPE_ACCELEROMETER;
    }

    public void lightClick(View v) {
        loadGraph();
        sm.unregisterListener(this);
        sm.registerListener(this, light, 1000000);
        current_sensor = Sensor.TYPE_LIGHT;
    }

    public void magClick(View v) {
        loadGraph();
        sm.unregisterListener(this);
        sm.registerListener(this, mag, 1000000);
        current_sensor = Sensor.TYPE_MAGNETIC_FIELD;
    }

    public void loadGraph() {
        Intent graph = new Intent(this, GraphActivity.class);
//        startActivity(graph);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        double x = event.values[0];
        double y = event.values[1];
        double z = event.values[2];
        double data = Math.sqrt(x*x + y*y + z*z);
        String display = data + "";
        temp.setText(display);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
