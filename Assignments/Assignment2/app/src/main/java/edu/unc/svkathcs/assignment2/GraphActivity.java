package edu.unc.svkathcs.assignment2;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sm;
    private Sensor accel, light, mag;
    private int current_sensor;
    private long last_printed = 0;
    private ArrayList<Double> sensor_values = new ArrayList<>();
    PlotView plot;// = new PlotView(this.getBaseContext());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accel = sm.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        light = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        mag = sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        sm.registerListener(this, accel, 1000000);
    }

    public void backToMain(View v) {
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
    }

    public int getCurrentSensor() {
        return current_sensor;
    }

    public void addSensorValue(Double d) {
        sensor_values.add(d);
        if (sensor_values.size() > 5) {
            sensor_values.remove(0);
        }
    }

    public void clearSensorValues() {
        sensor_values.clear();
    }




    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.timestamp - last_printed >= 1e8) {
            double x = event.values[0];
            double y = event.values[1];
            double z = event.values[2];
            double data = Math.sqrt(x * x + y * y + z * z);
            try {
                plot.addSensorValue(data);
            }
            catch (Exception e){

            }
            last_printed = event.timestamp;
            plot.invalidate();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}