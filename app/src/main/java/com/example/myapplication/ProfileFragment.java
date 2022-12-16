package com.example.myapplication;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileFragment extends Fragment {

    CircleImageView image;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);


        CircleImageView nav_image = (CircleImageView) rootView.findViewById(R.id.nav_image);
        TextView nav_username = (TextView) rootView.findViewById(R.id.nav_username);
        TextView nav_userage = (TextView) rootView.findViewById(R.id.nav_age);
        TextView nav_email = (TextView) rootView.findViewById(R.id.nav_email);


        DBHelper dbHelper = new DBHelper(this.getContext());
        Cursor cursor = dbHelper.getUser();
        if (cursor.getCount() == 0) {
            Toast.makeText(getContext(), "NO entries", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                nav_username.setText("" + cursor.getString(0));
                nav_userage.setText("" + cursor.getString(1));
                nav_email.setText("" + cursor.getString(2));

                byte[] imageByte = cursor.getBlob(4);
                Bitmap bitmap = BitmapFactory.decodeByteArray(imageByte, 0, imageByte.length);
                nav_image.setImageBitmap(bitmap);
            }
        }
        return rootView;
    }
}


