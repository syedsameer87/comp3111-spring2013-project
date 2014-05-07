package com.plan2gather.fragments;

import com.plan2gather.MainActivity;
import com.plan2gather.R;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileFragment extends Fragment {

	public static String screenName;
	EditText eText;
	
	public ProfileFragment() {
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_profile, container,
				false);
		eText = (EditText) view.findViewById(R.id.screenName);
		eText.setText(screenName);
		Button changeSName = (Button) view.findViewById(R.id.changeSName);
		changeSName.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				screenName = eText.getText().toString();
				Toast.makeText(getActivity(), "Change success!", Toast.LENGTH_SHORT).show();
			}
		});

		return view;
	}

}