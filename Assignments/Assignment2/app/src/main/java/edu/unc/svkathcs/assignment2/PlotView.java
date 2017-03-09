package edu.unc.svkathcs.assignment2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by smacbook on 3/3/17.
 */

public class PlotView extends View{

    public PlotView(Context context) {
        super(context);
    }

    public PlotView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PlotView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PlotView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private ArrayList<Double> sensor_values = new ArrayList<>();
    private ArrayList<Double> average_values = new ArrayList<>();
    private ArrayList<Double> std_dev_values = new ArrayList<>();
    private ArrayList<Integer> time_value = new ArrayList<>();
    private Float radius, padding, vertical_width, horizontal_spacing;
    private int time = 0;
    private double offset = 1;


    protected void onDraw(Canvas c) {
        super.onDraw(c);
        drawBackground(c);
        Paint p = new Paint();
//        String sv = "";
//        for(int i = 0; i < sensor_values.size(); i++)
//            sv = sv + Math.floor(sensor_values.get(i)) + "\n";
//        p.setColor(Color.BLACK);
//        p.setTextSize(25f);
//        c.drawText(sv, 50f, 1000f, p);
        p.setColor(Color.BLUE);
        drawValues(c, sensor_values, p);
        p.setColor(Color.GREEN);
        drawValues(c, average_values, p);
        p.setColor(Color.RED);
        drawValues(c, std_dev_values, p);
    }

    public void addSensorValue(Double d) {
        sensor_values.add(d);
        if(sensor_values.size() > 5) {
            sensor_values.remove(0);
        }
        average_values.add(getAverage());
        if(average_values.size() > 5) {
            average_values.remove(0);
        }
        std_dev_values.add(getStdDev());
        if(std_dev_values.size() > 5) {
            std_dev_values.remove(0);
        }
        if(sensor_values.size() == 5)
            increaseTime();
        this.invalidate();
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
        if (sensor_values.size() > 0) {
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
        if (sensor_values.size() > 0) {
            double total = 0d;
            for (int i = 0; i < sensor_values.size(); i++) {
                total += sensor_values.get(i);
            }
            return total / sensor_values.size();
        }
        return 0d;
    }

    public void initTime() {
        for(int i = 0; i < 7; i++) {
            time_value.add(i);
            time = i;
        }
    }

    private void increaseTime() {
        time_value.add(time);
        time_value.remove(0);
        time++;
    }

    public Double getStdDev() {
        if (sensor_values.size() > 0) {
            double avg = getAverage();
            ArrayList<Double> std_dev_list = new ArrayList<>();
            for (int i = 0; i < sensor_values.size(); i++) {
                std_dev_list.add(Math.pow(sensor_values.get(i) - avg, 2));
            }
            double total = 0d;
            for (int i = 0; i < std_dev_list.size(); i++) {
                total += std_dev_list.get(i);
            }
            return Math.sqrt(total / std_dev_list.size());
        }
        return 0d;
    }

    public void setOffset(int i) {
        if(i == Sensor.TYPE_ACCELEROMETER)
            offset = 1;
        else if (i == Sensor.TYPE_LIGHT)
            offset = 1;
        else
            offset = 1;
    }

    private void drawValues(Canvas c, ArrayList<Double> ald, Paint p) {
        radius = 15f;
        padding = 50f;
        vertical_width = 90f;
        horizontal_spacing = (getWidth() - (padding * 2)) / 6;
        offset = 10;
        

        if(ald.size() == 0)
            return;
        for(int i = 0; i < ald.size(); i++){
            c.drawCircle(horizontal_spacing * (i + 1) + padding,
                    (float) ((6 * vertical_width + padding - ald.get(i) * offset)),
                    radius, p);
            if(sensor_values.size() > i + 1) {
                c.drawLine(horizontal_spacing * (i + 1) + padding,
                        (float) ((6 * vertical_width + padding - ald.get(i) * offset) - 1),
                        horizontal_spacing * (i + 2) + padding,
                        (float) ((6 * vertical_width + padding - ald.get(i + 1) * offset) - 1), p);
                c.drawLine(horizontal_spacing * (i + 1) + padding,
                        (float) ((6 * vertical_width + padding - ald.get(i) * offset)),
                        horizontal_spacing * (i + 2) + padding,
                        (float) ((6 * vertical_width + padding - ald.get(i + 1) * offset)), p);
                c.drawLine(horizontal_spacing * (i + 1) + padding,
                        (float) ((6 * vertical_width + padding - ald.get(i) * offset) + 1),
                        horizontal_spacing * (i + 2) + padding,
                        (float) ((6 * vertical_width + padding - ald.get(i + 1) * offset) + 1), p);
            }
        }
    }

    private void drawBackground(Canvas c) {
        radius = 15f;
        padding = 50f;
        vertical_width = 90f;
        horizontal_spacing = (getWidth() - (padding * 2)) / 6;
        Double range = getSensorMax() - getSensorMin();

        Paint p = new Paint();
        // Draw Grid
        p.setColor(Color.LTGRAY);
        for(int i = 0; i < 7; i++)
            c.drawLine(padding, vertical_width * i + padding, getWidth() - padding, vertical_width * i + padding, p);
        for(int i = 0; i < 7; i++)
            c.drawLine(horizontal_spacing * i + padding, padding, horizontal_spacing * i + padding, vertical_width * 6 + padding, p);
        // Draw text on axis and descriptions
        p.setColor(Color.BLACK);
        p.setTextSize(25f);
//        for(int i = 6; i > -1; i--)
//            c.drawText(i * Math.floor(getSensorMax() / 6) + "", 0f, vertical_width * (6 - i) + padding, p);
        for(int i = 0; i < 7; i++)
            c.drawText(time_value.get(i) + "", horizontal_spacing * i + 45, vertical_width * 7, p);
        ArrayList<String> descriptions = new ArrayList<>();
        descriptions.add("Value");
        descriptions.add("Mean");
        descriptions.add("Std Dev");
        for(int i = 0; i < 3; i++)
            c.drawText(descriptions.get(i), horizontal_spacing * i * 2 + padding, 20f, p);
        p.setColor(Color.BLUE);
        c.drawCircle(horizontal_spacing + padding, 15f, radius, p);
        c.drawLine(horizontal_spacing, 14f, horizontal_spacing + padding * 2, 14f, p);
        c.drawLine(horizontal_spacing, 15f, horizontal_spacing + padding * 2, 15f, p);
        c.drawLine(horizontal_spacing, 16f, horizontal_spacing + padding * 2, 16f, p);
        p.setColor(Color.GREEN);
        c.drawCircle(horizontal_spacing * 3 + padding, 15f, radius, p);
        c.drawLine(horizontal_spacing * 3, 14f, horizontal_spacing * 3 + padding * 2, 14f, p);
        c.drawLine(horizontal_spacing * 3, 15f, horizontal_spacing * 3 + padding * 2, 15f, p);
        c.drawLine(horizontal_spacing * 3, 16f, horizontal_spacing * 3 + padding * 2, 16f, p);
        p.setColor(Color.RED);
        c.drawCircle(horizontal_spacing * 5 + padding, 15f, radius, p);
        c.drawLine(horizontal_spacing * 5, 14f, horizontal_spacing * 5 + padding * 2, 14f, p);
        c.drawLine(horizontal_spacing * 5, 15f, horizontal_spacing * 5 + padding * 2, 15f, p);
        c.drawLine(horizontal_spacing * 5, 16f, horizontal_spacing * 5 + padding * 2, 16f, p);
    }

}
