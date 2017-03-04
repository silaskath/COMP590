package edu.unc.svkathcs.assignment2;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private SensorManager sm;
    private Sensor accel, light, prox, gyro;
    TextView temp;
    TextView temp_2;
    TextView temp_3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accel = sm.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        light = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        prox = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        gyro = sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sm.registerListener(this, light, 1);
//        sm.registerListener(this, grav, 1);
        temp = (TextView) findViewById(R.id.temp);
        temp_2 = (TextView) findViewById(R.id.temp_2);
        temp_3 = (TextView) findViewById(R.id.temp_3);
    }

    public void accelClick(View v) {
//        Log.v("You clicked it.", Throwable t);
        Intent graph = new Intent(this, GraphActivity.class);
        startActivity(graph);
//        accel = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        String accel_x = event.values[0] + event.values[1] + event.values[2] +"";
//        String accel_y = event.values[1] + "";
//        String accel_z = event.values[2] + "";



//        for(int i = 0; i < event.values.length; i++) {
//            event_string.concat(event.values[i] + ", ");
//        }

        temp.setText(accel_x);
//        temp_2.setText(accel_y);
//        temp_3.setText(accel_z);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
