package com.ui.nestedrecylerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChildAdapterClass extends RecyclerView.Adapter<ChildAdapterClass.MyviewHolder> {
List<ChildModal> childModalList;

    public ChildAdapterClass(List<ChildModal> childModalList, Context context) {
        this.childModalList = childModalList;
        this.context = context;
    }

    Context context;

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_rv_layout,null,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        holder.imageView.setImageResource(childModalList.get(position).image);

    }

    @Override
    public int getItemCount() {
        return childModalList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.child_rv_image);
        }
    }
}
