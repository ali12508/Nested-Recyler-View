package com.ui.nestedrecylerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ParentAdaterClass extends RecyclerView.Adapter<ParentAdaterClass.myviewholder> {




    List<ParentModal>  parentModals;
    Context context;

    public ParentAdaterClass(List<ParentModal> parentModals, Context context) {
        this.parentModals = parentModals;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_rv_layout,null,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
          holder.textView.setText(parentModals.get(position).Title);
          ChildAdapterClass childAdapterClass ;
          childAdapterClass= new ChildAdapterClass(parentModals.get(position).childModalList,context);
          holder.child_recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
          holder.child_recyclerView.setAdapter(childAdapterClass);
          childAdapterClass.notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return parentModals.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView textView;
        RecyclerView child_recyclerView;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.rv_parent_title);
            child_recyclerView=itemView.findViewById(R.id.rv_child);
        }
    }
}
