package com.zedrcap.dhaivat.worth;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class DataClass extends AppCompatActivity {

    Context ctx = this;
    RecyclerView recyclerView;
    ArrayList<data> datalist = new ArrayList<>();
    MyDataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        String[] datas = getResources().getStringArray(R.array.one);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(ctx));

        Log.e("trace datalength",""+datas.length);
        for (int i = 0; i<datas.length; i++) {
            data d = new data(datas[i]);
            Log.e("trace data",datas[i]);
            datalist.add(d);
        }
        adapter = new MyDataAdapter(ctx , datalist);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}