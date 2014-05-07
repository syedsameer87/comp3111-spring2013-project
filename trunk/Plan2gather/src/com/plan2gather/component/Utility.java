package com.plan2gather.component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class Utility {
	public static ArrayList<String> nameOfEvent = new ArrayList<String>();
	public static ArrayList<String> descriptions = new ArrayList<String>();
	public static ArrayList<String> startDates = new ArrayList<String>();
	public static ArrayList<String> endDates = new ArrayList<String>();
	public static ArrayList<String> repetition = new ArrayList<String>();
	public static ArrayList<String> location = new ArrayList<String>();
	public static ArrayList<EventItem> eventList = new ArrayList<EventItem>();

	public static ArrayList<String> readCalendarEvent(Context context) {
		Cursor cursor = context.getContentResolver().query(
				Uri.parse("content://com.android.calendar/events"),
				new String[] { "calendar_id", "title", "description",
						"dtstart", "dtend", "rrule", "eventLocation" }, null,
				null, null);
		cursor.moveToFirst();
		// fetching calendars name
		String CNames[] = new String[cursor.getCount()];

		// fetching calendars id
		nameOfEvent.clear();
		descriptions.clear();
		startDates.clear();
		endDates.clear();
		repetition.clear();
		location.clear();
		eventList.clear();

		for (int i = 0; i < CNames.length; i++) {
			nameOfEvent.add(cursor.getString(1));
			descriptions.add(cursor.getString(2));
			startDates.add(cursor.getString(3));
			endDates.add(cursor.getString(4));
			repetition.add(cursor.getString(5));
			location.add(cursor.getString(6));
			Log.d("Sam", "Desc:" + cursor.getString(2));
			Log.d("Sam", "Start:" + cursor.getString(3));
			Log.d("Sam", "End:" + cursor.getString(4));
			Log.d("Sam", "repetition:" + cursor.getString(5));
			Log.d("Sam", "location:" + cursor.getString(6));
			
			CNames[i] = cursor.getString(1);
			cursor.moveToNext();

			eventList.add(new EventItem(nameOfEvent.get(i), startDates.get(i),
					endDates.get(i), descriptions.get(i), repetition.get(i),
					location.get(i)));
		}
		cursor.close();
		return nameOfEvent;
	}

	public static String getDate(long milliSeconds) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd",
				Locale.US);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(milliSeconds);
		return formatter.format(calendar.getTime());
	}

	public static String getTime(long milliSeconds) {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm", Locale.US);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(milliSeconds);
		return formatter.format(calendar.getTime());
	}
}
