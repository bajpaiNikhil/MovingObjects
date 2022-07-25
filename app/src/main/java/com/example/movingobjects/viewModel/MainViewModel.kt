package com.example.movingobjects.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movingobjects.establishingSensor.MeasurableSensor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val orientationSensor: MeasurableSensor
) : ViewModel() {

    val valuesLiveData: MutableLiveData<List<Float>> = MutableLiveData()


    init {
        orientationSensor.startListening()
        orientationSensor.setOnSensorValueChangeListener { tiltValue ->
            val a = (tiltValue[0] *(180/3.14))
            val b = (tiltValue[1] *(180/Math.PI))
            val c = (tiltValue[2] *(180/Math.PI))
            valuesLiveData.value = tiltValue
//            Log.d("MainViewModel" , "its viewModel in 90-value ${90-a} , ${90-b} , ${90-c}")
//            Log.d("MainViewModel" , "its viewModel in value , $values ")
            Log.d("MainViewModel" , "its viewModel in value , ${90-b} ")

        }
    }

    fun removeSensor(){
        orientationSensor.stopListening()
    }
}