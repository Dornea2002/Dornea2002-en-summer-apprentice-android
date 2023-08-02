package com.endava.ticketsalesmanagementapp;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EventAdapter eventAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

//         Button backButton=findViewById(R.id.imageButton);
//        backButton.setOnClickListener(view -> );

        recyclerView=findViewById(R.id.rvEvents);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<EventItem> list = new ArrayList<>();
        list.add(new EventItem("Untold", "Festival", "Concert", "Central Park", 100.0, LocalDate.now()));

        eventAdapter= new EventAdapter(list);
        recyclerView.setAdapter(eventAdapter);

        eventAdapter.setOnMyItemClickListener(this::onMyItemClick);

        ImageButton backButton= findViewById(R.id.imageButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void onMyItemClick(){
        //do something
    }

}

