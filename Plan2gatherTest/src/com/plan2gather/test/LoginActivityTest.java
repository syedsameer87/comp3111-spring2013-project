package com.plan2gather.test;


import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.SmallTest;
import android.test.TouchUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;

import com.plan2gather.LoginActivity;
import com.plan2gather.MainActivity;

public class LoginActivityTest extends
		ActivityInstrumentationTestCase2<LoginActivity> {
	
	LoginActivity mActivity;
	EditText textMobileNumber;
	Button buttonRegister;

	public LoginActivityTest() {
		super(LoginActivity.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override 
	 protected void setUp() throws Exception { 
	 //this method is called every time before any test execution 
		 super.setUp();
		 
		 mActivity = this.getActivity();
		 textMobileNumber = (EditText) mActivity.findViewById(com.plan2gather.R.id.mobile_number);	 
		 buttonRegister = (Button) mActivity.findViewById(com.plan2gather.R.id.reg_button);
	 } 
	
	@Override
	protected void tearDown() throws Exception { 
		 //this method is called every time after any test execution 
		 // we want to clean the texts 
		textMobileNumber.clearComposingText();
		mActivity.finish();
		super.tearDown(); 
	 } 
	
	@SmallTest
	public void testView() { // checks if the activity is created 
		 assertNotNull(getActivity()); 
		 assertNotNull(textMobileNumber); 
		 assertNotNull(buttonRegister); 
	} 
	
	@SmallTest   
	 public void testButtonRegister() {  //checks if button displayed correctly
		final View decorView = mActivity.getWindow().getDecorView();
		
		ViewAsserts.assertOnScreen(decorView, buttonRegister);
		
		final ViewGroup.LayoutParams layoutParams = buttonRegister.getLayoutParams();
		
		assertNotNull(layoutParams);
		//assertEquals(layoutParams.width, WindowManager.LayoutParams.MATCH_PARENT);
		//assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	 } 


	@SmallTest
	public void testattemptLogin1() { // check if input is null		
		TouchUtils.tapView(this, textMobileNumber);	
		sendKeys("");
		TouchUtils.clickView(this, buttonRegister);		
	}
	
	@SmallTest
	public void testattemptLogin2() { // check if input is invalid mobile no.
		TouchUtils.tapView(this, textMobileNumber);	
		sendKeys("1 2 3");
		TouchUtils.clickView(this, buttonRegister);	
	}

	@SmallTest 
	public void testattemptLogin3() {
		//Error may occur due to intent MainActivity
		//cannot return to LoginActivity for further test
		//Must be put at the end 
		TouchUtils.tapView(this, textMobileNumber);	
		sendKeys("9 8 7 6 5 4 3 2");
		TouchUtils.clickView(this, buttonRegister);		
	}

		
}
	
