package com.endava.ticketsalesmanagementapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
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

        ImageButton filterButton = findViewById(R.id.imageButton4);
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSortDialog();
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
    private void showSortDialog() {
        String[] options = {"Sort by Total Price", "Sort by Order Date", "Sort by Category"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Sorting Method")
                .setItems(options, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0) {
                            sortByPrice();
                        } else if (which == 1) {
                            sortByDate();
                        }
                        else if(which==2){
                            sortByCategory();
                        }
                    }
                });
        builder.create().show();
    }

    private void sortByPrice() {
        orderAdapter.getOrderItemList().sort(new Comparator<OrderItem>() {
            @Override
            public int compare(OrderItem o1, OrderItem o2) {
                return o1.getTotalPrice().compareTo(o2.getTotalPrice());
            }
        });
        orderAdapter.notifyDataSetChanged(); // Refresh the RecyclerView
    }

    private void sortByDate() {
        orderAdapter.getOrderItemList().sort(new Comparator<OrderItem>() {
            @Override
            public int compare(OrderItem o1, OrderItem o2) {
                return o1.getOrderedAt().compareTo(o2.getOrderedAt());
            }
        });
        orderAdapter.notifyDataSetChanged(); // Refresh the RecyclerView
    }

    private void sortByCategory() {
        orderAdapter.getOrderItemList().sort(new Comparator<OrderItem>() {
            @Override
            public int compare(OrderItem o1, OrderItem o2) {
                return o1.getTicketCategory().compareTo(o2.getTicketCategory());
            }
        });
        orderAdapter.notifyDataSetChanged(); // Refresh the RecyclerView
    }
    private void onMyItemClick() {
        //
    }
}