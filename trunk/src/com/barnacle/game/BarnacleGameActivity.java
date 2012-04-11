package com.barnacle.game;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

/**
 * BarnacleGameActivity class
 */
public class BarnacleGameActivity extends Activity
{
	/**
	 * Properties used with sensors.
	 */
	private SensorManager sensorManager;
	private Sensor sensor;
	private float x, y, z;

	/**
	 * onCreate
	 * 
	 * @abstract Sets up the sensor listener.
	 */
	@Override
	public void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.main );

		sensorManager = (SensorManager) getSystemService( Context.SENSOR_SERVICE );
		sensor = sensorManager.getSensorList( Sensor.TYPE_ACCELEROMETER ).get( 0 );
	}

	/**
	 * onResume()
	 */
	@Override
	protected void onResume()
	{
		super.onResume();
		sensorManager.registerListener( accelerationListener, sensor, SensorManager.SENSOR_DELAY_GAME );
	}

	/**
	 * onStop()
	 */
	@Override
	protected void onStop()
	{
		sensorManager.unregisterListener( accelerationListener );
		super.onStop();
	}

	private SensorEventListener accelerationListener = new SensorEventListener()
	{
		@Override
		public void onAccuracyChanged( Sensor sensor, int acc )
		{
		}

		/**
		 * onSensorChanged()
		 * 
		 * @abstract Updates the x, y and z properties on sensor changes.
		 */
		@Override
		public void onSensorChanged( SensorEvent event )
		{
			x = event.values[0];
			y = event.values[1];
			z = event.values[2];
		}

	};
}