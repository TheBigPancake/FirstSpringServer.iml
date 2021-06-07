package com.example.demo.model.NewTaxiForms;


import com.example.demo.model.NewTaxi.Customer;
import com.example.demo.model.NewTaxi.DBDoced;
import com.example.demo.model.NewTaxi.NewTaxiElement;
import org.bson.Document;

/**
 * Created by IntelliJ IDEA.
 * Taxi.iml.Customer
 *
 * @Autor: golde
 * @DateTime: 24.03.2021|21:31
 * @Version Customer: 1.0
 */
public class CustomerForm implements FormatClass{
    public String customer_id;
    public String full_name;
    public String phone;
    public String vip;

    public CustomerForm(String customer_id, String full_name, String phone, String vip) {
        this.customer_id = customer_id;
        this.full_name = full_name;
        this.phone = phone;
        this.vip = vip;
    }
    public CustomerForm(Customer elem) {
        this.customer_id = String.valueOf(elem.customer_id);
        this.full_name = elem.full_name;
        this.phone = elem.phone;
        this.vip = String.valueOf(elem.vip);
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }
}
