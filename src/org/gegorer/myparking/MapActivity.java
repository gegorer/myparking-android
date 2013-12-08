package org.gegorer.myparking;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MapActivity extends Activity implements OnClickListener {

	private String mLat;
	private String mLon;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		SharedPreferences settings = getSharedPreferences("Location", 0);
		mLat = settings.getString("lat", "");
		mLon = settings.getString("lon", "");
		
		Button saveBtn = (Button) findViewById(R.id.save);
		saveBtn.setOnClickListener(this);
		
		Button navBtn = (Button) findViewById(R.id.nav);
		navBtn.setOnClickListener(this);
		if (mLat.equals("") || mLon.equals("")) {
			navBtn.setEnabled(false);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.save:
			save();
			break;
		case R.id.nav:
			nav();
			break;
		default:
			break;
		}
	}
	
	private void save() {
		// TODO: confirm dialog for overwrite
		SharedPreferences settings = getSharedPreferences("Location", 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString("lat", "123");
		editor.putString("lon", "456");
		editor.commit();

		Button navBtn = (Button) findViewById(R.id.nav);
		navBtn.setEnabled(true);
	}
	
	private void nav() {
		// TODO: navigate using google map (app)
	}

}
