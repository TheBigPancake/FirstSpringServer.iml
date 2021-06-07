package com.example.demo.model.NewTaxiForms;

import com.example.demo.model.NewTaxi.DBDoced;
import com.example.demo.model.NewTaxi.NewTaxiElement;
import com.example.demo.model.NewTaxi.TaxiEmployee;
import com.example.demo.model.NewTaxi.TaxiOperator;
import org.bson.Document;

/**
 * Created by IntelliJ IDEA.
 * Taxi.iml.TaxiOperator
 *
 * @Autor: golde
 * @DateTime: 24.03.2021|20:37
 * @Version TaxiOperator: 1.0
 */
public class TaxiOperatorForm implements FormatClass{
    public String full_name;
    public String rating;
    public String work_hours_day;
    public String work_hours_night;
    public String premium;
    public String operator_id;

    public TaxiOperatorForm() {
    }

    public TaxiOperatorForm(String full_name, String rating, String work_hours_day, String work_hours_night, String premium, String operator_id) {
        this.full_name = full_name;
        this.rating = rating;
        this.work_hours_day = work_hours_day;
        this.work_hours_night = work_hours_night;
        this.premium = premium;
        this.operator_id = operator_id;
    }
    public TaxiOperatorForm(TaxiOperator elem) {
        this.full_name = elem.full_name;
        this.rating = String.valueOf(elem.rating);
        this.work_hours_day = String.valueOf(elem.work_hours_day);
        this.work_hours_night = String.valueOf(elem.work_hours_night);
        this.premium = String.valueOf(elem.premium);
        this.operator_id = String.valueOf(elem.operator_id);
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getWork_hours_day() {
        return work_hours_day;
    }

    public void setWork_hours_day(String work_hours_day) {
        this.work_hours_day = work_hours_day;
    }

    public String getWork_hours_night() {
        return work_hours_night;
    }

    public void setWork_hours_night(String work_hours_night) {
        this.work_hours_night = work_hours_night;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public String getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(String operator_id) {
        this.operator_id = operator_id;
    }
}
