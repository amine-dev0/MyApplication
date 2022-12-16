package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ToggleButton;


public class TimeFragment extends Fragment implements OnClickListener {


    LinearLayout button1 = null;
    LinearLayout button2 = null;
    LinearLayout button3 = null;
    LinearLayout button4 = null;
    LinearLayout button5 = null;
    Intent intent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_time, container, false);

        Intent intent1 = new Intent(getActivity(), Week1.class);
        button1 = rootView.findViewById(R.id.week1);
        button1.setOnClickListener(v -> startActivity(intent1));
        Intent intent2 = new Intent(getActivity(), week2.class);
        button2 = rootView.findViewById(R.id.week2);
        button2.setOnClickListener(v -> startActivity(intent2));
        Intent intent3 = new Intent(getActivity(), week3.class);
        button3 = rootView.findViewById(R.id.week3);
        button3.setOnClickListener(v -> startActivity(intent3));
        Intent intent4 = new Intent(getActivity(), week4.class);
        button4 = rootView.findViewById(R.id.week4);
        button4.setOnClickListener(v -> startActivity(intent4));
        Intent intent5 = new Intent(getActivity(), week5.class);
        button5 = rootView.findViewById(R.id.week5);
        button5.setOnClickListener(v -> startActivity(intent5));

        return rootView;

    }

    @Override
    public void onClick(View v) {

    }
}





