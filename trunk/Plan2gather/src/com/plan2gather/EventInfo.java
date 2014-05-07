package com.plan2gather;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import com.plan2gather.component.EventItem;
import com.plan2gather.component.Utility;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class EventInfo extends Activity {
	EventItem e;
	int position;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		Intent intent = getIntent();
		setContentView(R.layout.activity_event_info);

		// Get the message from the intent
		String message = intent.getStringExtra("eName");

		for (int i = 0; i < Utility.eventList.size(); i++) {
			if (Utility.eventList.get(i).getTitle().compareTo(message) == 0) {
				position = i;
				e = Utility.eventList.get(i);
				break;
			}
		}

		TextView eNameT = (TextView) findViewById(R.id.eNameD);
		TextView eStartT = (TextView) findViewById(R.id.eStartD);
		TextView eEndT = (TextView) findViewById(R.id.eEndD);
		TextView ePlaceT = (TextView) findViewById(R.id.ePlaceD);
		TextView eDescT = (TextView) findViewById(R.id.eDescD);
		//TextView eRepeatT = (TextView) findViewById(R.id.eRepeatD);
		TextView ePartiT = (TextView) findViewById(R.id.ePartiD);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm",
				Locale.US);
		Calendar calendar = Calendar.getInstance();

		eNameT.setText(e.getTitle());
		calendar.setTimeInMillis(Long.parseLong(e.getStartTime()));
		eStartT.setText(formatter.format(calendar.getTime()).toString());
		calendar.setTimeInMillis(Long.parseLong(e.getEndTime()));
		eEndT.setText(formatter.format(calendar.getTime()).toString());
		if (e.getLocation() != null)
			ePlaceT.setText(e.getLocation());
		if (e.getDescription() != null)
			eDescT.setText(e.getDescription());
		//if (e.getRepetition() != null)
			//eRepeatT.setText(e.getRepetition());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		return super.onOptionsItemSelected(item);
	}
}