package com.example.movingobjects.di

import android.app.Application
import com.example.movingobjects.establishingSensor.MeasurableSensor
import com.example.movingobjects.establishingSensor.OrientationSensor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object SensorModule {
    @Provides
    @Singleton
    fun provideOrientationSensor(app: Application): MeasurableSensor {
        return OrientationSensor(app)
    }
}