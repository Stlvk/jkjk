package com.example.zh_moduleb

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast

class LineView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {



    var width1 = 0f
    var height1 = 0f
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        width1 = MeasureSpec.getSize(widthMeasureSpec).toFloat()
        height1 = MeasureSpec.getSize(heightMeasureSpec).toFloat()
    }
    var eventX=0f
    var eventY=0f
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var paint = Paint()
        paint.strokeWidth = 5f
        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        paint.isAntiAlias = true
        var path = Path()
        path.reset();
        canvas!!.translate(width1/2,height1/2)
        path.moveTo(0f,0f)

        path.quadTo(eventX,eventY,200f,200f)
        canvas!!.drawPath(path, paint)
        canvas!!.drawCircle(300f,300f,30f,paint)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event!!.action==MotionEvent.ACTION_MOVE){
            eventX=event.x
            eventY=event.y
            postInvalidate()
        }
        return true
    }

}