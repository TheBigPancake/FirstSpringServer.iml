package com.example.demo.model.NewTaxi;

import org.bson.Document;

/**
 * Created by IntelliJ IDEA.
 * Taxi.iml.TaxiEmployee
 *
 * @Autor: golde
 * @DateTime: 24.03.2021|21:29
 * @Version TaxiEmployee: 1.0
 */
public abstract class TaxiEmployee {
    public String full_name;
    public int rating;
    public int work_hours_day;
    public int work_hours_night;
    public int premium;

    public TaxiEmployee(String full_name) {
        this.full_name = full_name;
        this.rating = 0;
        this.work_hours_day = 0;
        this.work_hours_night = 0;
        this.premium = 0;
    }
    public TaxiEmployee(Document doc){
        this.full_name = (String) doc.get("full_name");
        this.rating = (int) doc.get("rating");
        this.premium = (int) doc.get("premium");
        this.work_hours_day = (int) doc.get("work_hours_day");
        this.work_hours_night = (int) doc.get("work_hours_night");
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getWork_hours_day() {
        return work_hours_day;
    }

    public void setWork_hours_day(int work_hours_day) {
        this.work_hours_day = work_hours_day;
    }

    public int getWork_hours_night() {
        return work_hours_night;
    }

    public void setWork_hours_night(int work_hours_night) {
        this.work_hours_night = work_hours_night;
    }

    public int getPremium() {
        return premium;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }
}
