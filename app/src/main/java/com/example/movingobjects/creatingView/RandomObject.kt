package com.example.movingobjects.creatingView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.View

class RandomObject(context : Context) : View(context ,  null) {

    var xPoint : Float = 100F
    var yPoint : Float = 100F
    var radius : Float = 50F

    private val redPaint : Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(500 , 500)
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Log.d("CircularShape" , "display Point $xPoint , $yPoint")
        canvas?.drawCircle(xPoint, yPoint, radius, redPaint)
    }

    init{
        redPaint.alpha = 1
        redPaint.style = Paint.Style.STROKE
        redPaint.strokeWidth = 5F
        redPaint.color = Color.BLUE
    }
}