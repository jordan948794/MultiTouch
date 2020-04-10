package com.example.s1072756;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Fingers extends View {

    Paint paint = new Paint();
    //float xPos = 200;
    //float yPos = 200;
    int Count = 0;
    float[] xPos = new float[20];
    float[] yPos = new float[20];
    int[] rainbow;



    public Fingers(Context context) {
        super(context);
        rainbow = context.getResources().getIntArray(R.array.rainbow);

    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawColor(Color.LTGRAY);
        //paint.setColor(Color.YELLOW);
        //canvas.drawCircle(xPos, yPos, 80, paint);
        for (int i=0; i<Count; i++){
            //paint.setColor(Color.YELLOW);
            paint.setColor(rainbow[i % 7]);

            canvas.drawCircle(xPos[i], yPos[i], 80, paint);
        }

    }

    public boolean onTouchEvent (MotionEvent event) {
        //xPos = event.getX();
        //yPos = event.getY();
        Count = event.getPointerCount();
        for (int i = 0; i < Count; i++) {
            xPos[i] = event.getX(i);
            yPos[i] = event.getY(i);
        }

        invalidate();
        return true;
    }


}
