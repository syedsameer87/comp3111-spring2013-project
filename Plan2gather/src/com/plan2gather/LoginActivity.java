package com.plan2gather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class LoginActivity extends Activity {

	// Dummy values
	private static final String[] DUMMY_CREDENTIALS = new String[] {
			"98765432",  "67699413" };

	// Values for email and password at the time of the login attempt.
	private String mNumber;

	// UI references.
	private EditText mNumberView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		getActionBar().setTitle(getResources().getString(R.string.title_activity_login));

		// Set up the login form.
		mNumberView = (EditText) findViewById(R.id.mobile_number);

		findViewById(R.id.reg_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						attemptLogin();
					}
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		return true;
	}

	/**
	 * Attempts to sign in or register the account specified by the login form.
	 * If there are form errors (invalid email, missing fields, etc.), the
	 * errors are presented and no actual login attempt is made.
	 */
	public void attemptLogin() {

		// Reset errors.
		mNumberView.setError(null);

		// Store values at the time of the login attempt.
		mNumber = mNumberView.getText().toString();

		boolean cancel = false;
		View focusView = null;

		// Check for a valid password.
		if (TextUtils.isEmpty(mNumber)) {
			mNumberView.setError(getString(R.string.error_field_required));
			focusView = mNumberView;
			cancel = true;
		} else if (mNumber.length() != 8) {
			mNumberView.setError(getString(R.string.error_invalid_number));
			focusView = mNumberView;
			cancel = true;
		}

		if (cancel) {
			// There was an error; don't attempt login and focus the first
			// form field with an error.
			focusView.requestFocus();
		} else {
			// Show a progress spinner, and kick off a background task to
			// perform the user login attempt.
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
		}
	}
}
