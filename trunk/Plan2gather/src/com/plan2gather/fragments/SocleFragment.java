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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class SocleFragment extends Fragment {

	public ArrayList<UserItem> userList;

	public SocleFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		userList = new ArrayList<UserItem>();
		readUserList(userList);
		try {
			FileWriter out = new FileWriter("/user.txt", true);
			out.write("98329337,SamSam");
			out.close();
		} catch (IOException e) {
			Log.d("Sam", "Error write file");
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		ListView rootView = (ListView) inflater.inflate(
				R.layout.fragment_socle, container, false);
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
			File file = new File("/user.txt");
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
	}

	public void updateUserList(UserItem item) {
		String outText = item.getID() + "," + item.getName();
		try {
			FileWriter out = new FileWriter("/user.txt", true);
			out.write(outText);
			out.close();
		} catch (IOException e) {
			Log.d("Sam", "Error write file");
		}
	}
}