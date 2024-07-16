package com.example.performanceapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class CustomCircularProgress(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private var progress: Int = 0
    private val paint: Paint = Paint()
    private val rect: RectF = RectF()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val width = width.toFloat()
        val height = height.toFloat()
        val diameter = Math.min(width, height)
        val strokeWidth = 20f

        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = strokeWidth

        // Background circle
        paint.color = Color.LTGRAY
        rect.set(strokeWidth, strokeWidth, diameter - strokeWidth, diameter - strokeWidth)
        canvas.drawArc(rect, 0f, 360f, false, paint)

        // Progress circle
        paint.color = Color.BLUE
        val sweepAngle = 360 * progress / 100f
        canvas.drawArc(rect, -90f, sweepAngle, false, paint)

        // Text in the center
        paint.style = Paint.Style.FILL
        paint.color = Color.BLACK
        paint.textSize = diameter / 5
        paint.textAlign = Paint.Align.CENTER
        val xPos = width / 2
        val yPos = (height / 2 - (paint.descent() + paint.ascent()) / 2)
        canvas.drawText("$progress%", xPos, yPos, paint)
    }

    fun setProgress(progress: Int) {
        this.progress = progress
        invalidate()
    }
}
