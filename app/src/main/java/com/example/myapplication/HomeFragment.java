package com.example.myapplication;




import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ToggleButton;


public class HomeFragment extends Fragment implements OnClickListener {


    public ToggleButton button1 = null;
    public ToggleButton button2 = null;
    public ToggleButton button3 = null;
    public ToggleButton button4 = null;
    public ToggleButton button5 = null;
    public ToggleButton button6 = null;
    Intent intent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        Intent intent1 = new Intent(getActivity(), Exercices.class);
        button1 = rootView.findViewById(R.id.exbtn1);
        button1.setOnClickListener(v -> startActivity(intent1));
        Intent intent2 = new Intent(getActivity(), ExercicesBack.class);
        button2 = rootView.findViewById(R.id.exbtn2);
        button2.setOnClickListener(v -> startActivity(intent2));
        Intent intent3 = new Intent(getActivity(), ExercicesChest.class);
        button3 = rootView.findViewById(R.id.exbtn3);
        button3.setOnClickListener(v -> startActivity(intent3));
        Intent intent4 = new Intent(getActivity(), ExercicesTricep.class);
        button4 = rootView.findViewById(R.id.exbtn4);
        button4.setOnClickListener(v -> startActivity(intent4));
        Intent intent5 = new Intent(getActivity(), ExercicesShoulders.class);
        button5 = rootView.findViewById(R.id.exbtn5);
        button5.setOnClickListener(v -> startActivity(intent5));
        Intent intent6 = new Intent(getActivity(), ExercicesLegs.class);
        button6 = rootView.findViewById(R.id.exbtn6);
        button6.setOnClickListener(v -> startActivity(intent6));
        return rootView;

    }

    @Override
    public void onClick(View v) {

    }
}







