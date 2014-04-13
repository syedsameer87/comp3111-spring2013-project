package com.plan2gather.component;

import java.util.ArrayList;
import com.plan2gather.R;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NavMenuAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<NavMenuItems> SlidingMenuItem;

	public NavMenuAdapter(Context context,
			ArrayList<NavMenuItems> SlidingMenuItem) {
		this.context = context;
		this.SlidingMenuItem = SlidingMenuItem;
	}

	@Override
	public int getCount() {
		return SlidingMenuItem.size();
	}

	@Override
	public Object getItem(int position) {
		return SlidingMenuItem.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater mInflater = (LayoutInflater) context
					.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = mInflater.inflate(R.layout.drawer_menu_item, null);
		}

		ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
		TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
		TextView txtCount = (TextView) convertView.findViewById(R.id.counter);

		imgIcon.setImageResource(SlidingMenuItem.get(position).getIcon());
		txtTitle.setText(SlidingMenuItem.get(position).getTitle());

		// displaying count
		// check whether it set visible or not
		if (SlidingMenuItem.get(position).getCounterVisibility()) {
			txtCount.setText(SlidingMenuItem.get(position).getCount());
		} else {
			// hide the counter view
			txtCount.setVisibility(View.GONE);
		}

		return convertView;
	}

}