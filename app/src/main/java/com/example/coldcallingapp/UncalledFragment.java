package com.example.coldcallingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class UncalledFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_uncalled, container, false);
        ListView list = (v.findViewById(R.id.listview_uncalled));
        ArrayList <Student> uncalled = ((GlobalClass)getActivity().getApplication()).getUncalled();
        ArrayAdapter <Student> arrayAdapter = new ArrayAdapter<>(getActivity().getApplicationContext(),R.layout.activity_listview, uncalled);
        list.setAdapter(arrayAdapter);


        return v;
    }
}
