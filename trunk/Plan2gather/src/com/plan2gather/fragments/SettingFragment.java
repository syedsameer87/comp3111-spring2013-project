package com.plan2gather.fragments;
 
import com.plan2gather.R;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 
public class SettingFragment extends PreferenceFragment {
     
    public SettingFragment(){}
     
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_setting, container, false);
          
        return rootView;
    }
}