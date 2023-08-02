package com.endava.ticketsalesmanagementapp;

import java.time.LocalDate;

public class EventItem {
    public String name;
    public String description;
    public String category;
    public String Location;
    public Double price;
    public LocalDate date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public CharSequence getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CharSequence getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
