package com.plan2gather.component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class Utility {
	public static ArrayList<String> eventID = new ArrayList<String>();
	public static ArrayList<String> nameOfEvent = new ArrayList<String>();
	public static ArrayList<String> descriptions = new ArrayList<String>();
	public static ArrayList<String> startDates = new ArrayList<String>();
	public static ArrayList<String> endDates = new ArrayList<String>();
	public static ArrayList<String> repetition = new ArrayList<String>();
	public static ArrayList<String> location = new ArrayList<String>();

	public static ArrayList<String> readCalendarEvent(Context context) {
		Cursor cursor = context.getContentResolver().query(
				Uri.parse("content://com.android.calendar/events"),
				new String[] { "calendar_id", "title", "description",
						"dtstart", "dtend", "rrule", "eventLocation" }, null, null, null);
		cursor.moveToFirst();
		// fetching calendars name
		String CNames[] = new String[cursor.getCount()];

		// fetching calendars id
		eventID.clear();
		nameOfEvent.clear();
		descriptions.clear();
		startDates.clear();
		endDates.clear();
		repetition.clear();
		location.clear();
		
		for (int i = 0; i < CNames.length; i++) {
			eventID.add(cursor.getString(0));
			nameOfEvent.add(cursor.getString(1));
			descriptions.add(cursor.getString(2));
			try {
				startDates.add(getDate(Long.parseLong(cursor.getString(3))));
				if (null == cursor.getString(4))
					endDates.add("");
				else
					endDates.add(getDate(Long.parseLong(cursor.getString(4))));
			} catch (Exception ex) {
				Log.d("Sam", "Start:" + cursor.getString(3));

				Log.d("Sam", "End:" + cursor.getString(4));
			}
			repetition.add(cursor.getString(5));
			location.add(cursor.getString(6));
			CNames[i] = cursor.getString(1);
			cursor.moveToNext();

		}
		return nameOfEvent;
	}

	public static String getDate(long milliSeconds) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(milliSeconds);
		return formatter.format(calendar.getTime());
	}
}
