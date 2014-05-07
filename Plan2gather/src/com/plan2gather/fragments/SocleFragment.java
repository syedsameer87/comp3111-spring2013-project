package com.plan2gather.fragments;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.plan2gather.R;
import com.plan2gather.component.UserItem;
import com.plan2gather.component.UserListAdapter;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class SocleFragment extends Fragment {

	public static ArrayList<UserItem> userList;

	public SocleFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		userList = new ArrayList<UserItem>();
		readUserList(userList);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		ListView rootView = (ListView) inflater.inflate(
				R.layout.fragment_socle, container, false);
		rootView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
			}
		});

		rootView.setAdapter(new UserListAdapter(getActivity(), userList));
		return rootView;
	}

	public void readUserList(ArrayList<UserItem> userList) {
		String temp;
		String tStringArray[];
		String ID;
		String sName;
		userList.clear();
		try {
			File sdcard = Environment.getExternalStorageDirectory();
			File file = new File(sdcard, "user.txt");
			BufferedReader in = new BufferedReader(new FileReader(file));
			while (in.readLine() != null) {
				temp = in.readLine();
				tStringArray = temp.split(",");
				ID = tStringArray[0];
				sName = tStringArray[1];
				userList.add(new UserItem(ID, sName));
			}
		} catch (IOException e) {
			Log.d("Sam", "Error read file");
		}

		userList.add(new UserItem("98329337", "SamSam"));
		userList.add(new UserItem("68986426", "Rainbow"));
		userList.add(new UserItem("51774170", "SiuHei"));
		userList.add(new UserItem("64474354", "Ant"));
	}

	public void updateUserList(UserItem item) {
		String outText = item.getID() + "," + item.getName();
		try {
			File sdcard = Environment.getExternalStorageDirectory();
			FileWriter out = new FileWriter("user.txt", true);
			out.write(outText);
			out.close();
		} catch (IOException e) {
			Log.d("Sam", "Error write file");
		}
	}
}