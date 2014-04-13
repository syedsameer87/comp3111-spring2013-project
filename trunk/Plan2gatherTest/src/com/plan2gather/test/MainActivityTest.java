package com.plan2gather.test;


import android.test.ActivityInstrumentationTestCase2; 
import android.test.TouchUtils;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Point;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;

import com.plan2gather.MainActivity;
import com.plan2gather.R;
import com.plan2gather.component.NavMenuItems;
import com.plan2gather.fragments.*;



public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

	MainActivity mActivity;
	NavigationDrawerFragment mNavigationDrawerFragment;
	DrawerLayout mDrawerLayout;
	
	
	public MainActivityTest() {
		super(MainActivity.class);
	}
	
	@Override 
	 protected void setUp() throws Exception { 
	 //this method is called every time before any test execution 
	 super.setUp(); 
	 
	 
	 mActivity = (MainActivity) getActivity(); 
	 mNavigationDrawerFragment = (NavigationDrawerFragment) mActivity.getFragmentManager().findFragmentById(R.id.navigation_drawer);
	 mDrawerLayout = (DrawerLayout) mActivity.findViewById(R.id.drawer_layout);
	 
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
		 assertNotNull(mDrawerLayout);
	} 
	
	@SmallTest
	public void testnavigationDrawerItemSelection1() {
		mActivity.onNavigationDrawerItemSelected(1);
	}
	
	@SmallTest
	public void testnavigationDrawerItemSelection2() {
		mActivity.onNavigationDrawerItemSelected(2);
	}
	
	@SmallTest
	public void testnavigationDrawerItemSelection3() {
		mActivity.onNavigationDrawerItemSelected(3);
	}
	
	
	public void testdrawer(){
		mActivity.restoreActionBar();
		
	}
	
}