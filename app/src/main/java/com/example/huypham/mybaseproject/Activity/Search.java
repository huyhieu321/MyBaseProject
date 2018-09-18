package com.example.huypham.mybaseproject.Activity;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.support.v7.widget.SearchView;

import com.example.huypham.mybaseproject.R;
import com.example.huypham.mybaseproject.View.SearchAdapter;
import com.example.huypham.mybaseproject.Model.Places;

import java.util.ArrayList;

public class Search extends AppCompatActivity {
    SearchAdapter searchAdapter;
    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;
    SearchManager searchManager;
    SearchView searchView;
    ArrayList<Places> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_search);
        Bundle bundle = getIntent().getBundleExtra("bundle");
        list = (ArrayList<Places>) bundle.getSerializable("list");
        for (Places x: list){
            Log.i("MEs",x.getName());
        }
        recyclerView = findViewById(R.id.rvSearchView);
        searchAdapter = new SearchAdapter(this, list);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(searchAdapter);

        // Associate searchable configuration with the SearchView
        searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) findViewById(R.id.searchView);


        searchView.setOnQueryTextListener(new OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.i("MES",newText);
                searchAdapter.filter(newText);
                return false;
            }
        });
    }
}
