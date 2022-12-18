package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


public class CaloriFragment extends Fragment {

    EditText edKg, edCm;
    CardView cardBtn;
    TextView textView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_calori, container, false);
        edKg = (EditText) v.findViewById(R.id.edKg);
        cardBtn = v.findViewById(R.id.cardBtn);
        textView = v.findViewById(R.id.textView);
        edCm = v.findViewById(R.id.edCm);

        cardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String kg = edKg.getText().toString();
                String cm = edCm.getText().toString();

                if (kg.length()>0 && cm.length()>0){

                    float weight = Float.parseFloat(kg);
                    float ecm = Float.parseFloat(cm);

                    float height = (float) (ecm);
                    float bmiIndex = weight/(height*height);

                    if (bmiIndex>40){

                        textView.setText("Overweight class 3 : "+bmiIndex);

                    }else if (bmiIndex>35 || bmiIndex>39.9){

                        textView.setText("Overweight class 2 : "+bmiIndex);

                    }
                    else if (bmiIndex>30 || bmiIndex>34.9){

                        textView.setText("Overweight class 1 : "+bmiIndex);

                    }
                    else if (bmiIndex>25 || bmiIndex>29.9){

                        textView.setText("Normal weight: "+bmiIndex);

                    }
                    else if(bmiIndex>18.5 || bmiIndex>24.9) {

                        textView.setText("Normal weight : "+bmiIndex);

                    }
                    else if(bmiIndex<18.5) {

                        textView.setText("Under weight : "+bmiIndex);

                    }
                    else{

                        textView.setText("Error");

                    }

                }else {

                    textView.setText("Please Input All Box");
                }

            }
        });
        return v;
    }
}