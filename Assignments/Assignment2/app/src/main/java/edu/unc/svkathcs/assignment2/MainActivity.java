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

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private SensorManager sm;
    private Sensor accel, light, mag;
    private TextView temp, accel_stat, accel_info, light_stat, light_info, mag_stat, mag_info;
    private int current_sensor;
    private long last_printed = 0;
    private ArrayList<Double> sensor_values = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accel = sm.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        light = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        mag = sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        temp = (TextView) findViewById(R.id.temp);
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
        loadGraph();
        sm.unregisterListener(this);
        clearSensorValues();
        sm.registerListener(this, accel, 1000000);
        current_sensor = Sensor.TYPE_ACCELEROMETER;
    }

    public void lightClick(View v) {
        loadGraph();
        sm.unregisterListener(this);
        clearSensorValues();
        sm.registerListener(this, light, 1000000);
        current_sensor = Sensor.TYPE_LIGHT;
    }

    public void magClick(View v) {
        loadGraph();
        sm.unregisterListener(this);
        clearSensorValues();
        sm.registerListener(this, mag, 1000000);
        current_sensor = Sensor.TYPE_MAGNETIC_FIELD;
    }

    public int getCurrentSensor() {
        return current_sensor;
    }

    public void loadGraph() {
        Intent graph = new Intent(this, GraphActivity.class);
        startActivity(graph);
    }

    public void addSensorValue(Double d) {
        sensor_values.add(d);
        if(sensor_values.size() > 5) {
            sensor_values.remove(0);
        }
    }

    public void clearSensorValues() {
        sensor_values.clear();
    }

    public Double getSensorMax() {
        if (sensor_values.size() > 0) {
            double max = sensor_values.get(0);
            for (int i = 1; i < sensor_values.size(); i++) {
                if (max < sensor_values.get(i))
                    max = sensor_values.get(i);
            }
            return max;
        }
        return 0d;
    }

    public Double getSensorMin() {
        if(sensor_values.size() > 0) {
            double min = sensor_values.get(0);
            for (int i = 1; i < sensor_values.size(); i++) {
                if (min > sensor_values.get(i))
                    min = sensor_values.get(i);
            }
            return min;
        }
        return 0d;
    }

    public Double getAverage() {
        if(sensor_values.size() > 0) {
            double total = 0d;
            for(int i = 0; i < sensor_values.size(); i++) {
                total += sensor_values.get(i);
            }
            return total / sensor_values.size();
        }
        return 0d;
    }

    public Double getStdDev(){
        if(sensor_values.size() > 0) {
            double avg = getAverage();
            ArrayList<Double> std_dev_list = new ArrayList<>();
            for(int i = 0; i < sensor_values.size(); i++) {
                std_dev_list.add(Math.pow(sensor_values.get(i) - avg, 2));
            }
            double total = 0d;
            for(int i = 0; i < std_dev_list.size(); i++) {
                total += std_dev_list.get(i);
            }
            return Math.sqrt(total / std_dev_list.size());
        }
        return 0d;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.timestamp - last_printed >= 1e8) {
            double x = event.values[0];
            double y = event.values[1];
            double z = event.values[2];
            double data = Math.sqrt(x * x + y * y + z * z);
            addSensorValue(data);
            String display = "";
            for(int i = 0; i < sensor_values.size(); i++) {
                display = display + (i + 1) + ": " + sensor_values.get(i) +
                        "\nAverage: " + getAverage() + "\nStd Dev: " + getStdDev();
            }
            temp.setText(display);
            last_printed = event.timestamp;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
