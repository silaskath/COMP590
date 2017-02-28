package edu.unc.svkathcs.lab3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

public class PlotView extends View {

    private ArrayList<Float> pointList = new ArrayList<>();

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

//    private Bitmap b = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
//    private Canvas c = new Canvas(b);

    @Override
    protected void onDraw(Canvas c) {
        if(pointList.isEmpty())
            return;
        int radius = 20;
        Paint p = new Paint();
        p.setColor(Color.BLACK);
        for (int i = 0; i < pointList.size(); i++)
            c.drawCircle(0, pointList.get(0), radius, p);
    }

    public void addPoint(float f) {
        pointList.add(f);
        if (pointList.size() > 10)
            pointList.remove(0);
        invalidate();
    }

    public void clearList() {
        pointList.clear();
    }
}




