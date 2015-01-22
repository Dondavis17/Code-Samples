package com.example.flashlight;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import com.example.flashlight.R;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;


public class FlashSwitchActivity extends Activity {
	
	
	ImageButton btnSwitch;
	private Camera camera;
	private boolean isFlashOn;
	private boolean hasFlash;
	Parameters params;
	
	@SuppressWarnings("deprecation")	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.flash_switch);
		btnSwitch = (ImageButton) findViewById(R.id.btn_switch);
		
		hasFlash = getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
	
	
		if (!hasFlash)
		{
			AlertDialog alert = new AlertDialog.Builder(FlashSwitchActivity.this).create();
			alert.setTitle("Error");
			alert.setMessage("Sorry, your device doesn't support flash light!");
			alert.setButton("OK", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface diaglog, int which) {
					finish();
			}
		});
		alert.show();
		return;
	}
	
	getCamera();
	toggleSwitch();
	}
	public void switchClicked(View v)
	{
		if(isFlashOn)
		{
			turnOffFlash();
		}
		else
		{
			turnOnFlash();
		}
	}
	
	private void getCamera()
	{
		if (camera == null)
		{
			try
			{
				camera = Camera.open();
				params = camera.getParameters();
			}
			catch (RuntimeException e)
			{
				Log.e("Camera Error.  Failed to open. Error: ", e.getMessage());
			}
		}
	}
	
	//turn On flash
	private void turnOnFlash()
	{
		if (!isFlashOn)
		{
			if (camera == null || params == null)
			{
				return;
			}
			params = camera.getParameters();
			params.setFlashMode(Parameters.FLASH_MODE_TORCH);
			camera.setParameters(params);
			camera.startPreview();
			isFlashOn = true;
			toggleSwitch();
		}
	}
	
	//Turning off flash
	private void turnOffFlash()
	{
		if (isFlashOn)
		{
			if (camera == null || params == null)
			{
				return;
			}
			
			params = camera.getParameters();
			params.setFlashMode(Parameters.FLASH_MODE_OFF);
			camera.setParameters(params);
			isFlashOn = false;
			toggleSwitch();
		}
	}

	private void toggleSwitch()
	{
		if(isFlashOn)
		{
			btnSwitch.setImageResource(R.drawable.btn_switch_on);
		}
		else
		{
			btnSwitch.setImageResource(R.drawable.btn_switch_off);
		}
	}
	
	@Override
	protected void onStop()
	{
		super.onStop();
		if (camera != null)
		{
			camera.release();
			camera = null;
		}
	}
	
	@Override
	protected void onDestroy()
	{
		super.onDestroy();
	}
	
	@Override
	protected void onStart()
	{
		super.onStart();
		getCamera();
	}
	
	@Override
	protected void onPause()
	{
		super.onPause();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.flash_switch, menu);
		return true;
	}

}
