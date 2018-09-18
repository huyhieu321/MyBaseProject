package com.example.huypham.mybaseproject.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.huypham.mybaseproject.Fragment.FragmentHotel;
import com.example.huypham.mybaseproject.Fragment.FragmentHotel.OnFragmentInteractionListener;
import com.example.huypham.mybaseproject.R;

public class Details extends AppCompatActivity implements OnFragmentInteractionListener{
    boolean fragmentHotelFlag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        // Get data
        Intent intent = getIntent();
        String data =intent.getStringExtra("title");

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        TextView txtView = findViewById(R.id.txtView);
        txtView.setText(data);
        // add default fragment
        addHotel();

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id){
                    case R.id.action_hotel:
                        if(fragmentHotelFlag) {
                            addHotel();
                        }
                        break;
                    case R.id.action_restaurant:
                        break;
                    case R.id.action_transport:
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    public void addHotel(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FragmentHotel fragmentHotel = new FragmentHotel();
        fragmentTransaction.add(R.id.frameContent,fragmentHotel,"fragHotel");
        fragmentTransaction.commit();
        fragmentTransaction.addToBackStack("fragHotel");
        fragmentHotelFlag=false;
    }

}
