package com.example.linedraw;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CustomLineDraw extends View{
	Paint paints;
	final float linethickness;
	float beginX=0;
	float beginY=0;
	float endX =200;
	float endY =200;
	float stopX;
	float stopY;
	boolean start =true;
	
	public CustomLineDraw(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomLineDraw,0,0);
		try{
			 linethickness = a.getDimension(R.styleable.CustomLineDraw_linethickness, 100.0f);
		}finally{
			a.recycle();
		}
		paints = new Paint();
		paints.setStyle(Style.FILL);
		paints.setStrokeWidth(linethickness);
		paints.setColor(Color.BLUE);
	}	
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		float startX=canvas.getWidth()/2;
		float startY= canvas.getHeight()/2;
		if(start){
			canvas.drawLine(startX, startY, startX, startY, paints);
			stopX=startX;
			stopY=startY;
			start=false;
		}else{
			canvas.drawLine(startX, startY, stopX, stopY, paints);
		}
		
		if(stopX != getWidth() && stopY != getHeight()){
			stopX++;
			stopY++;
			Log.d("test", "stopX:"+stopX+" stopY:"+stopY+" endX:"+endY+" endY:"+endY);
			postInvalidateDelayed(15);
		}
//		if(stopX != 500 && stopY != 500){
//			stopX++;
//			stopY++;
//			postInvalidateDelayed(15);
//		}
	}
}
