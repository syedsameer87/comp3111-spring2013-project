package com.plan2gather.test;


import android.test.ActivityInstrumentationTestCase2; 
import android.test.TouchUtils;
import android.content.Intent;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.Gravity;
import android.view.View;
import android.widget.GridView;
import android.support.v4.widget.DrawerLayout;

import com.plan2gather.MainActivity;
import com.plan2gather.R;
import com.plan2gather.fragments.*;



public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

	MainActivity mActivity;
	NavigationDrawerFragment mNavigationDrawerFragment;
	
	public MainActivityTest() {
		super(MainActivity.class);
	}
	
	@Override 
	 protected void setUp() throws Exception { 
	 //this method is called every time before any test execution 
	 super.setUp(); 
	 
	 
	 mActivity = (MainActivity) getActivity(); 
	 mNavigationDrawerFragment = (NavigationDrawerFragment) mActivity.getFragmentManager().findFragmentById(R.id.navigation_drawer);
	// mNavigationDrawerFragment = (NavigationDrawerFragment) mActivity.getLayoutInflater().inflate(0,R.layout.fragment_calendar);
	// mDrawerLayout = (DrawerLayout) mActivity.findViewById(R.id.drawer_layout);
	 //GridView gridview = (GridView) view.findViewById(R.id.gridview);
	 } 
	
	@Override
	protected void tearDown() throws Exception { 
		 //this method is called every time after any test execution 
		 // we want to clean the texts 
		super.tearDown(); 
	 } 
	
	@SmallTest
	public void testView() { // checks if the activity is created 
		 assertNotNull(mActivity); 
	} 
	
	public void CloseSlidebar(){
		if (mNavigationDrawerFragment.isDrawerOpen())
		TouchUtils.drag(this, 30, 47, 30, 47, 0);
	}
	
	public void OpenSlidebar(){
		if (!mNavigationDrawerFragment.isDrawerOpen())
		TouchUtils.drag(this, 30, 47, 30, 47, 0);
	}

	public void testSelectCalendar() {
		OpenSlidebar();
		//Select Calendar
		TouchUtils.drag(this, 25, 25, 100, 100, 0);
		//Click on an item
		TouchUtils.drag(this, 160, 160, 240, 240, 0);
		//Click on previous for 6 times
		for (int i=0;i<6;i++)
		TouchUtils.drag(this, 22, 22, 90, 90, 0);
		//Click on next	for 6 times
		for (int i=0;i<6;i++)
		TouchUtils.drag(this, 300, 300, 90, 90, 0);
		//Click on offdays
		TouchUtils.drag(this, 155, 155, 155, 155, 0); //a day on previous month
		TouchUtils.drag(this, 248, 248, 340, 340, 0); //a day on next month	
	}


	public void testSelectSocle() {
		OpenSlidebar();
		TouchUtils.drag(this, 25, 25, 150, 150, 0);
	}
	
	public void testSelectProfile() {
		OpenSlidebar();
		TouchUtils.drag(this, 25, 25, 200, 200, 0);
	}
	
	public void testSelectSetting() {
		OpenSlidebar();
		TouchUtils.drag(this, 25, 25, 250, 250, 0);
	}
	
	public void testSelectFunctionButton() {
		CloseSlidebar();
		TouchUtils.drag(this, 300, 300, 50, 50, 0);
	}
	
}
	
	
	/*
	@SmallTest
	public void testnavigationDrawerItemSelection2() {
		mActivity.onNavigationDrawerItemSelected(2);
	}
	
	@SmallTest
	public void testnavigationDrawerItemSelection3() {
		mActivity.onNavigationDrawerItemSelected(3);
	}
	
	public void testCloseSlidebar(){
		TouchUtils.drag(this, 300, 0, 200, 200, 0);
	}*/
	
	
	

	

	
	
	
