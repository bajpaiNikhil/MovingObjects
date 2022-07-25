package com.example.movingobjects.creatingView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.View
import kotlin.math.sqrt

class CircularShape(context : Context ) : View(context ,  null) {

    var xPoint : Float = (context.resources.displayMetrics.widthPixels.toFloat())/2
    var yPoint : Float = (context.resources.displayMetrics.heightPixels.toFloat())/2
    var radius : Float = 50F

    private val redPaint : Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bluePaint : Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Log.d("CircularShape" , "display Point $xPoint , $yPoint")

        val a = canvas?.drawCircle(xPoint, yPoint, radius, redPaint)
        val b = canvas?.drawCircle(400F, 300F , radius , bluePaint)

    }

    init{
        redPaint.alpha = 1
        redPaint.style = Paint.Style.STROKE
        redPaint.strokeWidth = 5F
        redPaint.color = Color.RED
        bluePaint.color = Color.BLUE
    }
}