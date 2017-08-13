package com.salmanwahed.multipletypelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] months = {"January", "February", "March", "April", "May", "June", "July", "August"};
    private String[] days = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private RecyclerView mRecyclerView;
    private CustomAdapter customAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static final int TITLE_VIEW = 1234;
    private static final int ITEM_VIEW = 5678;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(false);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        ArrayList<AdapterItem> itemList = new ArrayList<>();
        itemList.add(new AdapterItem("Months", TITLE_VIEW));
        for (String month: months){
            AdapterItem adapterItem = new AdapterItem(month, ITEM_VIEW);
            itemList.add(adapterItem);
        }
        itemList.add(new AdapterItem("Days", TITLE_VIEW));
        for (String day: days){
            AdapterItem adapterItem = new AdapterItem(day, ITEM_VIEW);
            itemList.add(adapterItem);
        }
        customAdapter = new CustomAdapter(this, itemList);
        mRecyclerView.setAdapter(customAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        customAdapter.notifyDataSetChanged();
    }
}
