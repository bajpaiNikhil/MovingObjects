package com.example.movingobjects

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.movingobjects.creatingView.CircularShape
import com.example.movingobjects.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var  circleObject : CircularShape
    private var state: String = "MIDDLE"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)


        circleObject = CircularShape(this)
        setContentView(circleObject)


        val myViewModel : MainViewModel by viewModels()
        myViewModel.valuesLiveData.observe(this , Observer {

            val b = (it[1] *(180/Math.PI))
            val angle : Double = 90.0

            Log.d("MainActivity" , "before the change  ${circleObject.xPoint} , ${circleObject.yPoint} , ${circleObject.radius} ,  $b")

            if ((angle-b) >95.00){
                state = "+XMoving"
                movingInXDirection()
            }
            else if((angle-b)<85){
                state = "-XMoving"
                movingInXDirection()
            }
        })
    }

    private fun movingInXDirection() {

        if(state=="+XMoving") {
            circleObject.xPoint = circleObject.xPoint + 5
            setContentView(circleObject)
            Log.d(
                "MainActivity",
                "${circleObject.xPoint} , ${circleObject.yPoint} , ${circleObject.radius} ,  $state"
            )
        }
        if(state =="-XMoving"){
            circleObject.xPoint = circleObject.xPoint - 5
            setContentView(circleObject)
            Log.d(
                "MainActivity",
                "${circleObject.xPoint} , ${circleObject.yPoint} , ${circleObject.radius} ,  $state"
            )
        }
    }

}