package edu.unc.svkathcs.assignment2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

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

    protected void onDraw(Canvas c) {
        super.onDraw(c);
        Paint p = new Paint();
        p.setColor(Color.GREEN);
        c.drawCircle(20, 20, 15f, p);
        drawBackground(c);
    }

    public void blueCircle(Double x, Double y) {

    }

    public void drawBackground(Canvas c) {
        Float padding = 50f;
        Float vertical_width = 90f;
        Float horizontal_spacing = (getWidth() - (padding * 2)) / 6;
        Paint p = new Paint();
        p.setColor(Color.LTGRAY);
        for(int i = 0; i < 7; i++)
            c.drawLine(padding, vertical_width * i + padding, getWidth() - padding, vertical_width * i + padding, p);
        for(int i = 0; i < 7; i++)
            c.drawLine(horizontal_spacing * i + padding, padding, horizontal_spacing * i + padding, vertical_width * 6 + padding, p);
        p.setColor(Color.BLACK);
        for(int i = 6; i > -1; i--)
            c.drawText(i * 10 + "", 0f, vertical_width * (6 - i) + padding, p);
        for(int i = 0; i < 7; i++)
            c.drawText((i + 1) + "", horizontal_spacing * i + padding, vertical_width * 7, p);

    }
}
