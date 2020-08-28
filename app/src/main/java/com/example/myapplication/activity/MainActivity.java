package com.example.myapplication.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.myapplication.R;
import com.example.myapplication.fragment.FragmentAlbum;
import com.example.myapplication.fragment.FragmentFavorite;
import com.example.myapplication.fragment.FragmentPersonal;
import com.example.myapplication.fragment.FragmentSinger;
import com.example.myapplication.fragment.FragmentTop;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().add(R.id.fl_container, new FragmentAlbum()).commit();

        }
         navigationView = findViewById(R.id.nav_bottom);
         navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.item_album:
                        selectedFragment = FragmentAlbum.getInstance();
                        break;
                    case R.id.item_rank:
                        selectedFragment = FragmentTop.getInstance();
                        break;
                    case R.id.item_faverite:
                        selectedFragment = FragmentFavorite.getInstance();
                        break;
                    case R.id.item_singer:
                        selectedFragment = FragmentSinger.getInstance();
                        break;
                    case R.id.item_personal:
                        selectedFragment = FragmentPersonal.getInstance();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, selectedFragment).commit();
                return true;
            }
        });
    }

}