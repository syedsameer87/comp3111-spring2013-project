package com.plan2gather.fragments;
 
import com.plan2gather.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 
public class SocleFragment extends Fragment {
     
    public SocleFragment(){}
     
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_socle, container, false);
          
        return rootView;
    }
}