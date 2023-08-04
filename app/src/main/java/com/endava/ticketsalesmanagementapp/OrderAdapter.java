package com.endava.ticketsalesmanagementapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private final List<OrderItem> orderItemList;
    private OrderAdapter.OnMyItemClickListener orderListener;

    public OrderAdapter(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        return new OrderAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderItem orderItem=orderItemList.get(position);
        holder.bind(orderItem);
    }

    @Override
    public int getItemCount() {
        return orderItemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView id;
        public TextView ticketCategory;
        public TextView numberOfTickets;
        public TextView totalPrice;
        public TextView orderedAt;
        public CardView cardView;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            id=itemView.findViewById(R.id.textView3);
            ticketCategory=itemView.findViewById(R.id.textView6);
            numberOfTickets=itemView.findViewById(R.id.textView7);
            totalPrice=itemView.findViewById(R.id.textView8);
            orderedAt=itemView.findViewById(R.id.textView4);
            cardView=itemView.findViewById(R.id.cardView);
        }

        private void bind(OrderItem orderItem){
            cardView.setOnClickListener(v -> orderListener.onMyItemClickListener());
            id.setText("Order id: " + String.valueOf(orderItem.getId()));
            ticketCategory.setText("Category: " + orderItem.getTicketCategory());
            numberOfTickets.setText(String.valueOf("Number of tikcets: " + orderItem.getNumberOfTickets())); // Convert to string
            totalPrice.setText("Total price: " + orderItem.getTotalPriceString());
            orderedAt.setText("Order date: " + orderItem.getOrderedAtString());

        }
    }
    public interface OnMyItemClickListener{
        void onMyItemClickListener();
    }

    public void setOnMyItemClickListener(OnMyItemClickListener listener) {
        orderListener = listener;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }
}
