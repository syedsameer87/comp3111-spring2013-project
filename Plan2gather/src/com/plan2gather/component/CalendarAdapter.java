package com.plan2gather.component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import com.plan2gather.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CalendarAdapter extends BaseAdapter {
	private Context mContext;

	private java.util.Calendar month;
	public GregorianCalendar pMonth; // calendar instance for previous month
	/**
	 * calendar instance for previous month for getting complete view
	 */
	public GregorianCalendar pMonthMaxSet;
	private GregorianCalendar selectedDate;
	int firstDay;
	int maxWeekNumber;
	int maxP;
	int calMaxP;
	int lastWeekDay;
	int leftDays;
	int mnthlength;
	String itemValue, currentDateString;
	DateFormat df;

	private ArrayList<String> items;
	public static List<String> dayString;
	private View previousView;

	public CalendarAdapter(Context c, GregorianCalendar monthCalendar) {
		CalendarAdapter.dayString = new ArrayList<String>();
		
		month = monthCalendar;
		selectedDate = (GregorianCalendar) monthCalendar.clone();
		mContext = c;
		month.set(GregorianCalendar.DAY_OF_MONTH, 1);
		this.items = new ArrayList<String>();
		df = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		currentDateString = df.format(selectedDate.getTime());
		refreshDays();
	}

	public void setItems(ArrayList<String> items) {
		for (int i = 0; i != items.size(); i++) {
			if (items.get(i).length() == 1) {
				items.set(i, "0" + items.get(i));
			}
		}
		this.items = items;
	}

	public int getCount() {
		return dayString.size();
	}

	public Object getItem(int position) {
		return dayString.get(position);
	}

	public long getItemId(int position) {
		return 0;
	}

	// create a new view for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		TextView dayView;
		if (convertView == null) { // if it's not recycled, initialize some
									// attributes
			LayoutInflater vi = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.calendar_item, null);

		}
		dayView = (TextView) v.findViewById(R.id.date);
		// separates daystring into parts.
		String[] separatedTime = dayString.get(position).split("-");
		// taking last part of date. ie; 2 from 2012-12-02
		String gridvalue = separatedTime[2].replaceFirst("^0*", "");
		// checking whether the day is in current month or not.
		if ((Integer.parseInt(gridvalue) > 1) && (position < firstDay)) {
			// setting offdays to white color.
			dayView.setTextColor(v.getResources().getColor(R.color.other_month_textColor));
			dayView.setClickable(false);
			dayView.setFocusable(false);
		} else if ((Integer.parseInt(gridvalue) < 7) && (position > 28)) {
			dayView.setTextColor(v.getResources().getColor(R.color.other_month_textColor));
			dayView.setClickable(false);
			dayView.setFocusable(false);
		} else {
			// setting curent month's days in blue color.
			dayView.setTextColor(v.getResources().getColor(R.color.this_month_textColor));
		}

		if (dayString.get(position).equals(currentDateString)) {
			setSelected(v);
			previousView = v;
		} else {
			v.setBackgroundColor(v.getResources().getColor(R.color.canlendar_cell_background));
		}
		dayView.setText(gridvalue);

		// create date string for comparison
		String date = dayString.get(position);

		if (date.length() == 1) {
			date = "0" + date;
		}
		String monthStr = "" + (month.get(GregorianCalendar.MONTH) + 1);
		if (monthStr.length() == 1) {
			monthStr = "0" + monthStr;
		}

		// show icon if date is not empty and it exists in the items array
		ImageView iw = (ImageView) v.findViewById(R.id.date_icon);
		if (date.length() > 0 && items != null && items.contains(date)) {
			iw.setVisibility(View.VISIBLE);
		} else {
			iw.setVisibility(View.INVISIBLE);
		}
		return v;
	}

	public View setSelected(View view) {
		if (previousView != null) {
			previousView.setBackgroundColor(view.getResources().getColor(R.color.canlendar_cell_background));
		}
		previousView = view;
		view.setBackgroundColor(view.getResources().getColor(R.color.canlendar_cell_background_selected));
		return view;
	}

	public void refreshDays() {
		// clear items
		items.clear();
		dayString.clear();

		pMonth = (GregorianCalendar) month.clone();
		// month start day. ie; sun, mon, etc
		firstDay = month.get(GregorianCalendar.DAY_OF_WEEK);
		// finding number of weeks in current month.
		maxWeekNumber = month.getActualMaximum(GregorianCalendar.WEEK_OF_MONTH);
		// allocating maximum row number for the gridview.
		mnthlength = maxWeekNumber * 7;
		maxP = getMaxP(); // previous month maximum day 31,30....
		calMaxP = maxP - (firstDay - 1);// calendar offday starting 24,25 ...
		/**
		 * Calendar instance for getting a complete gridview including the three
		 * month's (previous,current,next) dates.
		 */
		pMonthMaxSet = (GregorianCalendar) pMonth.clone();
		/**
		 * setting the start date as previous month's required date.
		 */
		pMonthMaxSet.set(GregorianCalendar.DAY_OF_MONTH, calMaxP + 1);

		/**
		 * filling calendar gridview.
		 */
		for (int n = 0; n < mnthlength; n++) {

			itemValue = df.format(pMonthMaxSet.getTime());
			pMonthMaxSet.add(GregorianCalendar.DATE, 1);
			dayString.add(itemValue);

		}
	}

	private int getMaxP() {
		int maxP;
		if (month.get(GregorianCalendar.MONTH) == month
				.getActualMinimum(GregorianCalendar.MONTH)) {
			pMonth.set((month.get(GregorianCalendar.YEAR) - 1),
					month.getActualMaximum(GregorianCalendar.MONTH), 1);
		} else {
			pMonth.set(GregorianCalendar.MONTH,
					month.get(GregorianCalendar.MONTH) - 1);
		}
		maxP = pMonth.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);

		return maxP;
	}

}