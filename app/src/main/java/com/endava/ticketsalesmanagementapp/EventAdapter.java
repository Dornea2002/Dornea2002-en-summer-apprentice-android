package com.endava.ticketsalesmanagementapp;

import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder>{

    private final List<EventItem> eventItemList;
    private OnMyItemClickListener eventListener;

    public EventAdapter(List<EventItem> eventItemList) {
        this.eventItemList = eventItemList;
    }


    @NonNull
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.ViewHolder holder, int position) {
        EventItem eventItem=eventItemList.get(position);
        holder.bind(eventItem);
    }

    @Override
    public int getItemCount() {
        return eventItemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView description;
        public TextView category;
        public TextView location;
        public TextView price;
        public TextView date;
        public CardView cardView;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            name=itemView.findViewById(R.id.textView3);
            description=itemView.findViewById(R.id.textView4);
            category=itemView.findViewById(R.id.textView6);
            location=itemView.findViewById(R.id.textView7);
            price=itemView.findViewById(R.id.textView8);
            date=itemView.findViewById(R.id.textView5);
            cardView=itemView.findViewById(R.id.cardView);

        }

        private void bind(EventItem eventItem){
            cardView.setOnClickListener(v -> eventListener.onMyItemClickListener());
            name.setText(eventItem.getName());
            description.setText(eventItem.getDescription());
            category.setText(eventItem.getCategory());
            location.setText(eventItem.getLocation());
            price.setText(eventItem.getPrice());
            date.setText(eventItem.getDate());
        }
    }
    public interface OnMyItemClickListener{
        void onMyItemClickListener();
    }

    public void setOnMyItemClickListener(OnMyItemClickListener listener) {
        eventListener = listener;
    }


}
