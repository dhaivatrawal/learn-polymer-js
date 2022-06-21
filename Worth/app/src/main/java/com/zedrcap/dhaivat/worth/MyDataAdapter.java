package com.zedrcap.dhaivat.worth;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MyDataAdapter extends RecyclerView.Adapter {

    private Context ctx;
    private ArrayList<data> datalist;

    public MyDataAdapter(Context ctx , ArrayList<data> datalist){
        this.ctx =ctx;
        Log.e("trace data",""+datalist.size());
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View ContactRow = LayoutInflater.from(ctx).inflate(R.layout.data,null);
        NewContainer container = new NewContainer(ContactRow);
        return container;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NewContainer container= (NewContainer) holder;
        Log.e("trace data123",datalist.get(position).getOnetext());
        container.onetext.setText(datalist.get(position).getOnetext());
    }

    @Override
    public int getItemCount() {
        Log.e("trace size",""+datalist.size());
        return datalist.size();
    }

    class NewContainer extends RecyclerView.ViewHolder{
      public TextView onetext;

        public NewContainer(@NonNull View itemView) {
            super(itemView);
            onetext = itemView.findViewById(R.id.onetext);
            }
    }
}
