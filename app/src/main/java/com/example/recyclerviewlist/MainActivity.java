package com.example.recyclerviewlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    private ArrayList<Sport> mSportsData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up data
        initializeData();

        //  Find my recyclerView on the screen
        recyclerView = findViewById(R.id.recycler_view);

        // Create a layout manager for a vertically scrolling screen
        layoutManager = new LinearLayoutManager(this);

        //  Set newly created layout manager as layout manager of my recyclerView
        recyclerView.setLayoutManager(layoutManager);

        // Specify an adapter
        adapter = new SportAdapter(mSportsData);
        recyclerView.setAdapter(adapter);
    }


    private void initializeData() {
        // Get the resources from the XML file.
        String[] sportsList = getResources().getStringArray(R.array.sports_titles);

        String[] sportsInfo = getResources().getStringArray(R.array.sports_info);

        // Set up data
        TypedArray sportsImageResources =
                getResources().obtainTypedArray(R.array.sports_images);

        // Clear the existing data (to avoid duplication).
        mSportsData.clear();

        // Create the ArrayList of Sports objects with titles, information about each sport
        // and an image
        for(int i=0;i<sportsList.length;i++){
            mSportsData.add(new Sport(sportsList[i], sportsInfo[i], sportsImageResources.getResourceId(i, 0)));
        }


        // Notify the adapter of the change.
        //adapter.notifyDataSetChanged();
    }
}
