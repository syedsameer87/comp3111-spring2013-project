package com.plan2gather.fragments;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import com.plan2gather.component.CalendarAdapter;
import com.plan2gather.R;
import com.plan2gather.component.Utility;

import android.os.Bundle;
import android.os.Handler;
import android.app.Fragment;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CalendarFragment extends Fragment {

	public GregorianCalendar month, itemMonth;// calendar instances.

	public CalendarAdapter adapter;// adapter instance
	public Handler handler;// for grabbing some event values for showing the dot
	// marker.
	public ArrayList<String> items; // container to store calendar items which

	// needs showing the event marker
	ArrayList<String> event;
	LinearLayout rLayout;
	ArrayList<String> date;
	ArrayList<String> eventName;
	String selectedGridDate; 

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_calendar, null);

		rLayout = (LinearLayout) view.findViewById(R.id.eventDetail);
		month = (GregorianCalendar) GregorianCalendar.getInstance();
		itemMonth = (GregorianCalendar) month.clone();

		items = new ArrayList<String>();
		adapter = new CalendarAdapter(getActivity(), month);

		GridView gridview = (GridView) view.findViewById(R.id.gridview);
		gridview.setAdapter(adapter);

		handler = new Handler();
		handler.post(calendarUpdater);

		TextView title = (TextView) view.findViewById(R.id.title);
		title.setText(android.text.format.DateFormat.format("MMMM yyyy", month));

		RelativeLayout previous = (RelativeLayout) view
				.findViewById(R.id.previous);

		previous.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				setPreviousMonth();
				refreshCalendar();
			}
		});

		RelativeLayout next = (RelativeLayout) view.findViewById(R.id.next);
		next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				setNextMonth();
				refreshCalendar();

			}
		});

		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				// removing the previous view if added
				if (((LinearLayout) rLayout).getChildCount() > 0) {
					((LinearLayout) rLayout).removeAllViews();
				}

				((CalendarAdapter) parent.getAdapter()).setSelected(v);
				selectedGridDate = CalendarAdapter.dayString
						.get(position);
				String[] separatedTime = selectedGridDate.split("-");
				String gridvalueString = separatedTime[2].replaceFirst("^0*",
						"");// taking last part of date. ie; 2 from 2012-12-02.
				int gridvalue = Integer.parseInt(gridvalueString);
				// navigate to next or previous month on clicking offdays.
				if ((gridvalue > 10) && (position < 8)) {
					setPreviousMonth();
					refreshCalendar();
				} else if ((gridvalue < 7) && (position > 28)) {
					setNextMonth();
					refreshCalendar();
				}
				((CalendarAdapter) parent.getAdapter()).setSelected(v);

				eventName = new ArrayList<String>();
				for (int i = 0; i < Utility.startDates.size(); i++) {
					if (Utility.startDates.get(i).equals(selectedGridDate)) {
						eventName.add(Utility.nameOfEvent.get(i));
					}
				}

				if (eventName.size() > 0) {
					for (int i = 0; i < eventName.size(); i++) {
						TextView rowTextView = new TextView(getActivity());

						// set some properties of rowTextView or something
						rowTextView.setText("Event:" + eventName.get(i));
						rowTextView.setTextColor(Color.BLACK);

						// add the textview to the linearlayout
						rLayout.addView(rowTextView);

					}

				}

				eventName = null;
				showToast(selectedGridDate);
			}
		});
		return view;
	}

	protected void setNextMonth() {
		if (month.get(GregorianCalendar.MONTH) == month
				.getActualMaximum(GregorianCalendar.MONTH)) {
			month.set((month.get(GregorianCalendar.YEAR) + 1),
					month.getActualMinimum(GregorianCalendar.MONTH), 1);
		} else {
			month.set(GregorianCalendar.MONTH,
					month.get(GregorianCalendar.MONTH) + 1);
		}

	}

	protected void setPreviousMonth() {
		if (month.get(GregorianCalendar.MONTH) == month
				.getActualMinimum(GregorianCalendar.MONTH)) {
			month.set((month.get(GregorianCalendar.YEAR) - 1),
					month.getActualMaximum(GregorianCalendar.MONTH), 1);
		} else {
			month.set(GregorianCalendar.MONTH,
					month.get(GregorianCalendar.MONTH) - 1);
		}
	}

	protected void showToast(String string) {
		Toast.makeText(getActivity(), string, Toast.LENGTH_SHORT).show();
	}

	public void refreshCalendar() {
		TextView title = (TextView) getActivity().findViewById(R.id.title);

		adapter.refreshDays();
		adapter.notifyDataSetChanged();
		handler.post(calendarUpdater); // generate some calendar items

		title.setText(android.text.format.DateFormat.format("MMMM yyyy", month));
	}

	public Runnable calendarUpdater = new Runnable() {

		@Override
		public void run() {
			items.clear();

			// Print dates of the current week
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String itemvalue;
			event = Utility.readCalendarEvent(getActivity());
			Log.d("=====Event====", event.toString());
			Log.d("=====Date ARRAY====", Utility.startDates.toString());

			for (int i = 0; i < Utility.startDates.size(); i++) {
				itemvalue = df.format(itemMonth.getTime());
				itemMonth.add(GregorianCalendar.DATE, 1);
				items.add(Utility.startDates.get(i).toString());
			}

			adapter.setItems(items);
			adapter.notifyDataSetChanged();
		}
	};
}