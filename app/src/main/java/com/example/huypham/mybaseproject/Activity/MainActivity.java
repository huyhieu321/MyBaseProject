package com.example.huypham.mybaseproject.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.huypham.mybaseproject.R;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("datalogin",MODE_PRIVATE);
        Boolean firstUsing = sharedPreferences.getBoolean("firstUsing",true);
        if(firstUsing){
            Intent intent = new Intent(MainActivity.this,TutorialActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            Editor editor = sharedPreferences.edit();
            editor.putBoolean("firstUsing",false);
            editor.commit();
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(MainActivity.this,DynamicActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
    }
}
