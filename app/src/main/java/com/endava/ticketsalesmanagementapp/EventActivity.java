package com.endava.ticketsalesmanagementapp;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EventActivity extends AppCompatActivity {
    private EventAdapter eventAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        ImageButton backButton = findViewById(R.id.imageButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ImageButton filterButton = findViewById(R.id.imageButton4);
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSortDialog();
            }
        });

        RecyclerView recyclerView = findViewById(com.endava.ticketsalesmanagementapp.R.id.rvEvents);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        String[] names = {"Untold", "Neversea", "Electric Castle", "Beach Please", "SummerWell", "Saga"};
        String[] descriptions = {"Music", "Party", "Alcohol", "Trap", "Chill", "EDM"};
        String[] categories = {"Festival", "Concert", "Festival", "Beach", "Forest", "City"};
        String[] locations = {"Central Park", "Mamaia Beach", "Bontida", "Costinesti", "Bucharest", "National Arena"};
        Double[] prices = {550.0, 450.0, 300.0, 250.0, 150.0, 400.0};

        List<EventItem> list = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            list.add(new EventItem(names[i], descriptions[i], categories[i], locations[i], prices[i], LocalDate.now()));
        }

        eventAdapter = new EventAdapter(list);
        recyclerView.setAdapter(eventAdapter);
        eventAdapter.setOnMyItemClickListener(this::onMyItemClick);

    }

    private void showSortDialog() {
        String[] options = {"Sort by Name", "Sort by Price"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Sorting Method")
                .setItems(options, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0) {
                            sortByName();
                        } else if (which == 1) {
                            sortByPrice();
                        }
                    }
                });
        builder.create().show();
    }

    private void sortByName() {
        eventAdapter.getEventItemList().sort(new Comparator<EventItem>() {
            @Override
            public int compare(EventItem o1, EventItem o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        eventAdapter.notifyDataSetChanged(); // Refresh the RecyclerView
    }

    private void sortByPrice() {
        eventAdapter.getEventItemList().sort(new Comparator<EventItem>() {
            @Override
            public int compare(EventItem o1, EventItem o2) {
                return o1.getPrice().compareTo(o2.getPrice());
            }
        });
        eventAdapter.notifyDataSetChanged(); // Refresh the RecyclerView
    }

    private void onMyItemClick() {
        //
    }
}

