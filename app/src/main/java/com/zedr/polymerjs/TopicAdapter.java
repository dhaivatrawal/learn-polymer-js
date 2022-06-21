package com.zedr.polymerjs;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zedr.polymerjs.R;

import java.util.ArrayList;

public class TopicAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context ctx;
    ArrayList<Topic> topiclist;

    public TopicAdapter(Context ctx, ArrayList<Topic> Topiclist) {
        this.ctx = ctx;
        topiclist = Topiclist;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View topic =  inflater.inflate(R.layout.topirow,null);
        RecyclerView.ViewHolder container = new WidgetContainer(topic);
        return container;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        WidgetContainer container= (WidgetContainer)holder;
        container.lbltitle.setText(topiclist.get(position).getName());
        container.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctx.startActivity(new Intent(ctx,MainActivity.class).putExtra("url",
                        topiclist.get(position).getUrl()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return topiclist.size();
    }

    class WidgetContainer extends  RecyclerView.ViewHolder
    {
        public TextView lbltitle;
        public LinearLayout row;
        public WidgetContainer(@NonNull View itemView)
        {
            super(itemView);
            lbltitle = itemView.findViewById(R.id.lbltitle);
            row = itemView.findViewById(R.id.row);
        }
    }
}
