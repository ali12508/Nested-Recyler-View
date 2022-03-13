package com.ui.nestedrecylerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ParentModal> parentModals;
    ArrayList<ChildModal> childModals;
    ArrayList<ChildModal> recentlist;
    ArrayList<ChildModal> favouritelist;
    ArrayList<ChildModal> fastfoodslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rv_parent);
        getSupportActionBar().hide();
        parentModals=new ArrayList<>();
        childModals=new ArrayList<>();
        recentlist=new ArrayList<>();
        favouritelist=new ArrayList<>();
        fastfoodslist=new ArrayList<>();

       recentlist.add(new ChildModal(R.drawable.broast));
       recentlist.add(new ChildModal(R.drawable.fish));
       recentlist.add(new ChildModal(R.drawable.chinese));
       recentlist.add(new ChildModal(R.drawable.fingerfish));
       recentlist.add(new ChildModal(R.drawable.biryani));
       recentlist.add(new ChildModal(R.drawable.beefburger));

        favouritelist.add(new ChildModal(R.drawable.beefburger));
        favouritelist.add(new ChildModal(R.drawable.biryani));
        favouritelist.add(new ChildModal(R.drawable.chinese));
        favouritelist.add(new ChildModal(R.drawable.broast));
        favouritelist.add(new ChildModal(R.drawable.fingerfish));
        favouritelist.add(new ChildModal(R.drawable.fish));

        fastfoodslist.add(new ChildModal(R.drawable.fish));
        fastfoodslist.add(new ChildModal(R.drawable.fingerfish));
        fastfoodslist.add(new ChildModal(R.drawable.broast));
        fastfoodslist.add(new ChildModal(R.drawable.chinese));
        fastfoodslist.add(new ChildModal(R.drawable.biryani));
        fastfoodslist.add(new ChildModal(R.drawable.beefburger));

//        childModals.add(new ChildModal(R.drawable.broast));
//        childModals.add(new ChildModal(R.drawable.broast));
//        childModals.add(new ChildModal(R.drawable.broast));
//        childModals.add(new ChildModal(R.drawable.broast));
//        childModals.add(new ChildModal(R.drawable.broast));

       parentModals.add(new ParentModal("Recent Foods",recentlist));
       parentModals.add(new ParentModal("Favourite Foods",favouritelist));
       parentModals.add(new ParentModal("Most Liked",recentlist));
       parentModals.add(new ParentModal("Fast Foods",fastfoodslist));
       ParentAdaterClass parentAdaterClass=new ParentAdaterClass(parentModals,MainActivity.this);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
       recyclerView.setAdapter(parentAdaterClass);
       parentAdaterClass.notifyDataSetChanged();
    }
}