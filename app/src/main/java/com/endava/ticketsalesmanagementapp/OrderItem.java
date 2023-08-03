package com.endava.ticketsalesmanagementapp;

import java.time.LocalDate;

public class OrderItem {
    public int id;
    public String ticketCategory;
    public int numberOfTickets;
    public Double totalPrice;
    public LocalDate orderedAt;

    public OrderItem(int id, String ticketCategory, int numberOfTickets, Double totalPrice, LocalDate orderedAt) {
        this.id = id;
        this.ticketCategory = ticketCategory;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
        this.orderedAt = orderedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTicketCategory() {
        return ticketCategory;
    }

    public void setTicketCategory(String ticketCategory) {
        this.ticketCategory = ticketCategory;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public String getTotalPrice() {
        return totalPrice.toString();
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderedAt() {
        return orderedAt.toString();
    }

    public void setOrderedAt(LocalDate orderedAt) {
        this.orderedAt = orderedAt;
    }
}
