package edu.unc.svkathcs.graphix;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by smacbook on 2/2/17.
 */

public class CustomView extends View {

    int x = 50;
    int y = 50;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        p.setColor(Color.GREEN);

    }

    public void setPosition(x, y) {
        this x = x;
        this y = y;
    }
}
