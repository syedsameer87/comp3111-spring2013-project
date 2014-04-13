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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProfileFragment extends Fragment {

	TextView textTargetUri;
	ImageView targetImage;
	float scale;
	
	public ProfileFragment() {
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		scale = getActivity().getResources().getDisplayMetrics().density;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_profile, container,
				false);

		Button buttonLoadImage = (Button) view.findViewById(R.id.loadimage);
		targetImage = (ImageView) view.findViewById(R.id.targetimage);

		buttonLoadImage.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(intent, 1);
			}
		});

		return view;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
			MainActivity activity = (MainActivity) getActivity();
			Bitmap bitmap = getBitmapFromCameraData(data, activity);
			float dpToPx = 300 * scale + 0.5f;
			LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
					-1, (int)dpToPx);
			targetImage.setLayoutParams(layoutParams);
			targetImage.setImageBitmap(bitmap);
		}
	}

	/**
	 * Use for decoding camera response data.
	 * 
	 * @param data
	 * @param context
	 * @return
	 */
	public static Bitmap getBitmapFromCameraData(Intent data, Context context) {
		Uri selectedImage = data.getData();
		String[] filePathColumn = { MediaStore.Images.Media.DATA };
		Cursor cursor = context.getContentResolver().query(selectedImage,
				filePathColumn, null, null, null);
		cursor.moveToFirst();
		int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
		String picturePath = cursor.getString(columnIndex);
		cursor.close();
		return BitmapFactory.decodeFile(picturePath);
	}

}