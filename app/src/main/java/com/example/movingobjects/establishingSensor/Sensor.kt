package com.example.movingobjects.establishingSensor

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor

class OrientationSensor(
    context: Context
) : AndroidSensor(
    context = context ,
    sensorFeature = PackageManager.FEATURE_SENSOR_GYROSCOPE ,
    sensorType = Sensor.TYPE_ORIENTATION
)