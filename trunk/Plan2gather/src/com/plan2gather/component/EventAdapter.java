package com.plan2gather.component;

import java.util.ArrayList;

import com.plan2gather.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class EventAdapter extends BaseAdapter {
	private Context mContext;
	private ArrayList<EventItem> eventList;

	public EventAdapter(Context context, ArrayList<EventItem> eventItem) {
		this.mContext = context;
		this.eventList = eventItem;
	}

	@Override
	public int getCount() {
		return eventList.size();
	}

	@Override
	public Object getItem(int position) {
		return eventList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater vi = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = vi.inflate(R.layout.event_item, null);
		}
		
		TextView txtName = (TextView) convertView.findViewById(R.id.eventName);
		TextView txtStart = (TextView) convertView.findViewById(R.id.startTime);
		TextView txtEnd = (TextView) convertView.findViewById(R.id.endTime);
		
		txtName.setText(eventList.get(position).getTitle());
		txtStart.setText(eventList.get(position).getStartTime());
		txtEnd.setText(eventList.get(position).getEndTime());

		return convertView;
	}
}