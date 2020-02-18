package com.example.recyclerviewlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.CustomViewHolder> {
    private ArrayList<Sport> dataSet;

    public SportAdapter(ArrayList<Sport> dataSet) {
        this.dataSet = dataSet;
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView info_textView;
        public TextView title_textView;
        public ImageView imageView;
        public Context context;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            info_textView = itemView.findViewById(R.id.info_text_view);
            title_textView = itemView.findViewById(R.id.title_text_view);
            imageView = itemView.findViewById(R.id.image_view);
            context = itemView.getContext();
        }
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.custom_item_layout, parent, false);

        CustomViewHolder vh = new CustomViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        // Insert data into view holder -- by layout manager
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.title_textView.setText(dataSet.get(position).getTitle());
        holder.info_textView.setText(dataSet.get(position).getInfo());
        Glide.with(holder.context).load(dataSet.get(position).getImageResource()).into(holder.imageView);
        holder.imageView.setImageResource(dataSet.get(position).getImageResource());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
