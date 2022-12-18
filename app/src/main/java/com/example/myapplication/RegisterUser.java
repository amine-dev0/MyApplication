package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import de.hdodenhof.circleimageview.CircleImageView;

public class RegisterUser extends AppCompatActivity {

    EditText username, password, age, email;
    TextView select,signIn;
    ToggleButton signup;
    DBHelper DB;
    CircleImageView profileImage ;
    public static final int PICK_IMAGE_REQUEST = 99;
    private Uri imagePath;
    private Bitmap imageToStore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        profileImage = (CircleImageView) findViewById(R.id.Profile_image);
        select = (TextView) findViewById(R.id.select);
        signIn = (TextView) findViewById(R.id.signIn);
        age = (EditText) findViewById(R.id.age);
        email = (EditText) findViewById(R.id.email);
        signup = (ToggleButton) findViewById(R.id.btnsignup);

        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            storeImage();
                }
        });

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choseImage();
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void choseImage() {

        try {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(intent, PICK_IMAGE_REQUEST);
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        try {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null)
            {
                imagePath = data.getData();
                imageToStore = MediaStore.Images.Media.getBitmap(getContentResolver(), imagePath);
                profileImage.setImageBitmap(imageToStore);
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void storeImage() {


        if (!username.getText().toString().isEmpty() && !email.getText().toString().isEmpty()
                && !age.getText().toString().isEmpty() && !password.getText().toString().isEmpty()
                && profileImage.getDrawable() != null && imageToStore != null) {
            DB.insertData(new ModelClass(username.getText().toString(), email.getText().toString()
                    , age.getText().toString(), password.getText().toString(), imageToStore));
            Intent intent = new Intent(RegisterUser.this, RegisterUser.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "PLease fill all the fields", Toast.LENGTH_SHORT).show();
            select.setTextColor(getResources().getColor(android.R.color.holo_red_light));

        }
    }
}

