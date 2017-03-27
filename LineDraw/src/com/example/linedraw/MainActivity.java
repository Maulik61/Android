package com.example.linedraw;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
		InternetConnectionManager internetConnection;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		internetConnection = new InternetConnectionManager(ActivityHome.this);
	}
}
