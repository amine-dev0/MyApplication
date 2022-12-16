package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class nav extends AppCompatActivity {

    private static BottomNavigationView navigationView;
    HomeFragment homeFragment = new HomeFragment();
    TimeFragment timeFragment = new TimeFragment();
    CaloriFragment caloriFragment = new CaloriFragment();
    ProfileFragment profileFragment = new ProfileFragment();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        navigationView = (BottomNavigationView) findViewById(R.id.navigation_view);

        getSupportFragmentManager().beginTransaction().replace(R.id.container_layout, homeFragment).commit();
        nav.
                navigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container_layout, homeFragment).commit();
                        return true;
                    case R.id.time:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container_layout, timeFragment).commit();
                        return true;
                    case R.id.calori:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container_layout, caloriFragment).commit();
                        return true;
                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container_layout, profileFragment).commit();
                        return true;
                }
                return false;


            }
        });
    }
}


