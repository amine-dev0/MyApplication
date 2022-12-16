package com.example.myapplication;

import static android.app.ProgressDialog.show;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.BaseMenuPresenter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import android.widget.ToggleButton;

public class checkbox extends AppCompatActivity implements View.OnClickListener{

    private CheckBox checkboxone, checkboxtwo;
    private ToggleButton toggleButton;
    private ToggleButton toggleButtonn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);

        checkboxone = findViewById(R.id.fit);
        checkboxtwo = findViewById(R.id.kick);
        toggleButton= (ToggleButton) findViewById(R.id.togglebt );
        toggleButtonn= (ToggleButton) findViewById(R.id.togglebtt );
        toggleButtonn.setOnClickListener(this);





        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (toggleButton.isChecked()) {

                    @SuppressLint("UseCompatLoadingForDrawables") Drawable drawable = getResources().getDrawable(R.drawable.buttongreen, getTheme());
                    toggleButton.setBackgroundDrawable(drawable);

                    StringBuffer Result = new StringBuffer();
                    Result.append("Sport Selected :");
                    if (checkboxone.isChecked()) {
                        Result.append("\n Fitness");

                    }
                    if (checkboxtwo.isChecked()) {
                        Result.append("\n Kick Boxing");

                    }


                    Toast.makeText(checkbox.this,Result.toString(), Toast.LENGTH_LONG ).show();
                }
                else {

                    @SuppressLint("UseCompatLoadingForDrawables") Drawable drawabletwo= getResources().getDrawable(R.drawable.buttons, getTheme());
                    toggleButton.setBackgroundDrawable( drawabletwo );
                }
            }
        });



    }

    @Override
    public void onClick(View v) {
        if (checkboxone.isChecked()) {
            switch (v.getId()) {
                case R.id.togglebtt:
                    startActivity(new Intent(this, nav.class));
                    break;
            }
        }
        if (checkboxtwo.isChecked()) {
            switch (v.getId()) {
                case R.id.togglebtt:
                    startActivity(new Intent(this, nav.class));
                    break;
            }
        }
        else {
            StringBuffer result= new StringBuffer();
            result.append("nothing seleted!!");
            Toast.makeText(checkbox.this,result.toString(), Toast.LENGTH_LONG ).show();
        }

        }

    }



