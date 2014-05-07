package com.plan2gather.component;

import java.util.ArrayList;

import com.plan2gather.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class UserListAdapter extends ArrayAdapter<UserItem> {
	private Context mContext;
	private ArrayList<UserItem> userList;
	
	public UserListAdapter(Context context, ArrayList<UserItem> userList) {
		super(context, 0);
		this.mContext = context;
		this.userList = userList;
	}
	@Override
	public int getCount() {
		return userList.size();
	}

	@Override
	public UserItem getItem(int position) {
		return userList.get(position);
	}


	public View getView(int position, View convertView, ViewGroup parent) {
		// Abstract View --> Get a View that displays the data at the specified
		// position in the data set.
		UserItem item = getItem(position);
		View view = convertView;

		if (view == null) {
			int layout = R.layout.user_item;
			view = LayoutInflater.from(getContext()).inflate(layout, null);

			TextView uName = (TextView) view.findViewById(R.id.userSName);
			TextView uid = (TextView) view.findViewById(R.id.uid);
			
			uName.setText(item.getName());
			uid.setText(item.getID());
		}
		return view;
	}

}