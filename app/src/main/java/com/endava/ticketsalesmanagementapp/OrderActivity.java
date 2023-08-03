package com.endava.ticketsalesmanagementapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    private OrderAdapter orderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        ImageButton backButton = findViewById(R.id.imageButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.rvOrders);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        int[] id = {1, 2, 3, 4, 5, 6};
        String[] ticketCategory = {"Music", "Party", "Alcohol", "Trap", "Chill", "EDM"};
        int[] numberOfTickets = {4, 5, 1, 2, 7, 3};
        Double[] totalPrice = {300.0, 124.9, 2523.2, 223.23, 356.3, 110.5};

        List<OrderItem> list = new ArrayList<>();
        for (int i = 0; i < id.length; i++) {
            list.add(new OrderItem(id[i], ticketCategory[i], numberOfTickets[i], totalPrice[i], LocalDate.now()));
        }

        orderAdapter = new OrderAdapter(list);
        recyclerView.setAdapter(orderAdapter);
        orderAdapter.setOnMyItemClickListener(this::onMyItemClick);
    }
    private void onMyItemClick() {
        //
    }
}