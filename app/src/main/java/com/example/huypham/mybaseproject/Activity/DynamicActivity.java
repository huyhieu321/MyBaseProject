package com.example.huypham.mybaseproject.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.huypham.mybaseproject.R;
import com.example.huypham.mybaseproject.View.DynamicAdapter;
import com.example.huypham.mybaseproject.Model.Places;

import java.util.ArrayList;

public class DynamicActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    String[] place = {"Ho chi minh","Ha Noi", " Da Nang","Hai Phong", "Phu Yen","Phu Tho","Quang Ninh","Quang Binh","Quang Tri","Hue","Da Nang"};
    ArrayList<Places> list;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_dynamic);
        list  = new ArrayList<>();
        for(String x: place){
            list.add(new Places(x));
        }
        DynamicAdapter dynamicAdapter = new DynamicAdapter(list,this);
        dynamicAdapter.setEnableHeader(true);
        dynamicAdapter.setEnableFooter(true);
        searchView = (SearchView) findViewById(R.id.searchView);
        recyclerView = findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(dynamicAdapter);
        searchView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DynamicActivity.this,Search.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("list",list);
                intent.putExtra("bundle",bundle);
                startActivity(intent);
                Log.i("MES","Day ne");
            }
        });
    }
}
